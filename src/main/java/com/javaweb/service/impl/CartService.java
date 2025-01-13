package com.javaweb.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.converter.CartDTOConverter;
import com.javaweb.converter.ProductDTOConverter;
import com.javaweb.converter.SizeDTOConverter;
import com.javaweb.model.CartDTO;
import com.javaweb.model.CartItemDTO;
import com.javaweb.model.ProductDTO;
import com.javaweb.model.SizeDTO;
import com.javaweb.repository.CartItemRepository;
import com.javaweb.repository.CartRepository;
import com.javaweb.repository.entity.CartEntity;
import com.javaweb.repository.entity.CartItemEntity;
import com.javaweb.repository.entity.ProductEntity;
import com.javaweb.repository.entity.SizeEntity;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private CartDTOConverter cartDTOConverter;
    @Autowired
    private ProductDTOConverter productDTOConverter;
    @Autowired
    private SizeDTOConverter sizeDTOConverter;

    @Transactional
    public void addToCart(Long cart_id, Long product_id, Long size_id, int quantity) {
        CartEntity cart = cartRepository.findById(cart_id).orElseThrow(() -> new RuntimeException("Cart not found"));
        ProductEntity product = new ProductEntity();
        product.setProduct_id(product_id);
        SizeEntity size = new SizeEntity();
        size.setSize_id(size_id);

        CartItemEntity cartItem = new CartItemEntity();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setSize(size);
        cartItem.setQuantity(quantity);

        cart.getCartItems().add(cartItem);
        cartRepository.save(cart);
    }

    @Transactional
    public void updateCartItem(Long cartItemId, int quantity) {
        Optional<CartItemEntity> cartItemOptional = cartItemRepository.findById(cartItemId);
        CartItemEntity cartItem = cartItemOptional.orElseThrow(() -> new RuntimeException("Cart item not found"));

        // Log the cart item details
        System.out.println("Updating cart item: " + cartItem);

        // Update the quantity
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);

        // Update the total amount in the cart
        CartEntity cart = cartItem.getCart();
        double totalAmount = cart.getCartItems().stream()
            .mapToDouble(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())).doubleValue())
            .sum();
        cart.setTotalAmount(totalAmount);
        cartRepository.save(cart);
    }

    @Transactional
    public void removeCartItem(Long cart_id, Long cartItemId) {
        CartEntity cart = cartRepository.findById(cart_id).orElseThrow(() -> new RuntimeException("Cart not found"));
        CartItemEntity cartItem = cart.getCartItems().stream()
            .filter(item -> item.getCart_item_id().equals(cartItemId))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cart.getCartItems().remove(cartItem);
        cartRepository.save(cart);
    }

    @Transactional
    public void checkout(Long cartId) {
        CartEntity cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        // Implement checkout logic here
        // Clear the cart after successful payment
        cart.getCartItems().clear();
        cart.setTotalAmount(0);
        cartRepository.save(cart);
    }

    public CartDTO getCart(Long cart_id) {
        CartEntity cart = cartRepository.findById(cart_id).orElseThrow(() -> new RuntimeException("Cart not found"));
        CartDTO result = cartDTOConverter.toCartDTO(cart);
        List<CartItemEntity> cartItems = cart.getCartItems();
        List<CartItemDTO> cartItemDTOs = new ArrayList<>();
        for (CartItemEntity item : cartItems) {
            ProductEntity pro = item.getProduct();
            ProductDTO product = productDTOConverter.toProductDTO(pro);
            SizeEntity s = item.getSize();
            SizeDTO size = sizeDTOConverter.toSizeDTO(s);
            CartItemDTO cartitem = cartDTOConverter.toCartItemDTO(item);
            cartitem.setCart(result);
            cartitem.setProduct(product);
            cartitem.setSize(size);
            cartItemDTOs.add(cartitem);
        }
        result.setCartItems(cartItemDTOs);
        return result;
    }

    public void saveCart(CartEntity cart) {
        cartRepository.save(cart);
    }
}