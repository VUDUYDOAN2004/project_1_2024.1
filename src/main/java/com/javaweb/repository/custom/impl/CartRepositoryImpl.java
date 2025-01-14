package com.javaweb.repository.custom.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaweb.repository.custom.CartRepositoryCustom;
import com.javaweb.repository.entity.CartEntity;

@Repository
public class CartRepositoryImpl implements CartRepositoryCustom {

    private final JdbcTemplate jdbcTemplate;
    @PersistenceContext
	private EntityManager entityManager;

    public CartRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    

    @Transactional
    public void addCartItem(Long cart_id, Long product_id, Long size_id, int quantity) {
        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        String checkSql = "SELECT COUNT(*) FROM cart_items WHERE cart_id = ? AND product_id = ? AND size_id = ?";
        Query checkQuery = entityManager.createNativeQuery(checkSql);
        checkQuery.setParameter(1, cart_id);
        checkQuery.setParameter(2, product_id);
        checkQuery.setParameter(3, size_id);
    
        // Lấy kết quả kiểm tra
        Long count = ((Number) checkQuery.getSingleResult()).longValue();
    
        if (count > 0) {
            // Nếu sản phẩm đã tồn tại, tăng quantity thêm 1
            String updateSql = "UPDATE cart_items SET quantity = quantity + ? WHERE cart_id = ? AND product_id = ? AND size_id = ?";
            Query updateQuery = entityManager.createNativeQuery(updateSql);
            updateQuery.setParameter(1, quantity);
            updateQuery.setParameter(2, cart_id);
            updateQuery.setParameter(3, product_id);
            updateQuery.setParameter(4, size_id);
            updateQuery.executeUpdate();
        } else {
            // Nếu sản phẩm chưa tồn tại, thêm sản phẩm mới
            String insertSql = "INSERT INTO cart_items (cart_id, product_id, size_id, quantity) VALUES (?, ?, ?, ?)";
            Query insertQuery = entityManager.createNativeQuery(insertSql);
            insertQuery.setParameter(1, cart_id);
            insertQuery.setParameter(2, product_id);
            insertQuery.setParameter(3, size_id);
            insertQuery.setParameter(4, quantity);
            insertQuery.executeUpdate();
        }
    }
    

    
    

    @Override
    @Transactional
    public void updateCartItem(Long cart_item_id, int quantity) {
        String sql = "UPDATE cart_items SET quantity = ? WHERE cart_item_id = ?";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, quantity);
	    query.setParameter(2, cart_item_id);
	    query.executeUpdate();
    }

    @Override
    @Transactional
    public void removeCartItem(Long cartItemId) {
        String sql = "DELETE FROM cart_items WHERE cart_item_id = ?";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, cartItemId);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void checkout( Long cartId) {
        String orderSql = "INSERT INTO orders (cart_id, total_price, created_at) " +
                          "SELECT c.cart_id, SUM(p.price * ci.quantity) AS total_price, NOW() " +
                          "FROM cart_items ci " +
                          "JOIN products p ON ci.product_id = p.product_id " +
                          "JOIN carts c ON ci.cart_id = c.cart_id " +
                          "WHERE c.cart_id = ? GROUP BY c.cart_id";
        entityManager.createNativeQuery(orderSql)
                     .setParameter(1, cartId)
                     .executeUpdate();

        String deleteSql = "DELETE FROM cart_items WHERE cart_id = ?";
        entityManager.createNativeQuery(deleteSql)
                     .setParameter(1, cartId)
                     .executeUpdate();
    }

	@Override
	public CartEntity getCart(Long cart_id) {
		StringBuilder sql = new StringBuilder("select * from carts where cart_id = :cartId");
		
		Query query = entityManager.createNativeQuery(sql.toString(), CartEntity.class);
		query.setParameter("cartId", cart_id);
		return (CartEntity) query.getSingleResult();
	}

	

	
}
