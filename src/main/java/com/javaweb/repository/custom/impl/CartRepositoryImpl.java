package com.javaweb.repository.custom.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.javaweb.model.CartDTO;
import com.javaweb.model.CartItemDTO;
import com.javaweb.model.ProductDTO;
import com.javaweb.repository.custom.CartRepositoryCustom;

@Repository
public class CartRepositoryImpl implements CartRepositoryCustom {

    private final JdbcTemplate jdbcTemplate;

    public CartRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CartDTO getCart() {
        String sql = "SELECT ci.cart_item_id, ci.product_id, ci.quantity, ci.size_id, p.product_name, p.price, p.image_url " +
                     "FROM cart_items ci " +
                     "JOIN products p ON ci.product_id = p.product_id " +
                     "WHERE ci.cart_id = ?";

        List<CartItemDTO> cartItems = jdbcTemplate.query(sql, new Object[]{1L}, new RowMapper<CartItemDTO>() {
        	@Override
        	public CartItemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        	    try (ResultSet resultSet = rs) {
        	        CartItemDTO item = new CartItemDTO();
        	        item.setCartItemId(resultSet.getLong("cart_item_id"));
        	        item.setCartId(1L); // Giả sử cartId là 1 như trong câu truy vấn SQL
        	        item.setQuantity(resultSet.getInt("quantity"));
        	        item.setSizeId(resultSet.getLong("size_id"));

        	        ProductDTO product = new ProductDTO();
        	        product.setProduct_id(resultSet.getLong("product_id"));
        	        product.setProduct_name(resultSet.getString("product_name"));
        	        product.setPrice(resultSet.getLong("price"));
        	        product.setImage_url(resultSet.getString("image_url"));

        	        item.setProduct(product);
        	        return item;
        	    }
        	}
        });

        double totalAmount = cartItems.stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();

        CartDTO cart = new CartDTO();
        cart.setCartId(1L);
        cart.setUserId(1L); // Assuming user_id is 1 as per the context
        cart.setCartItems(cartItems);
        cart.setTotalAmount(totalAmount);

        return cart;
    }

    @Override
    public void addCartItem(Long productId, int quantity,Long sizeId) {
        String sql = "INSERT INTO cart_items (cart_id, product_id, quantity, size_id) " +
                     "VALUES (?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE quantity = quantity + VALUES(quantity)";
        jdbcTemplate.update(sql, 1L, productId, quantity, sizeId);
    }

    @Override
    public void updateCartItem(Long cartItemId, int quantity) {
        String sql = "UPDATE cart_items SET quantity = ? WHERE cart_item_id = ?";
        jdbcTemplate.update(sql, quantity, cartItemId);
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        String sql = "DELETE FROM cart_items WHERE cart_item_id = ?";
        jdbcTemplate.update(sql, cartItemId);
    }

    @Override
    public void checkout( Long cartId) {
        String orderSql = "INSERT INTO orders (cart_id, total_price, created_at) " +
                          "SELECT c.cart_id, SUM(p.price * ci.quantity) AS total_price, NOW() " +
                          "FROM cart_items ci " +
                          "JOIN products p ON ci.product_id = p.product_id " +
                          "JOIN carts c ON ci.cart_id = c.cart_id " +
                          "WHERE c.cart_id = ? GROUP BY c.cart_id";
        jdbcTemplate.update(orderSql, cartId);

        String deleteSql = "DELETE FROM cart_items WHERE cart_id = ?";
        jdbcTemplate.update(deleteSql, cartId);
    }

	
}
