package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.javaweb.repository.CartRepository;
import com.javaweb.repository.custom.CartRepositoryCustom;
import com.javaweb.repository.entity.CartEntity;
import com.javaweb.repository.entity.CartItemEntity;
import com.javaweb.repository.entity.ProductEntity;
import com.javaweb.repository.entity.SizeEntity;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
	private CartDTOConverter cartDTOConverter;
    @Autowired
	private ProductDTOConverter productDTOConverter;
    @Autowired
	private SizeDTOConverter sizeDTOConverter;

//    public CartDTO getCart() {
//        return cartRepository.getCart();
//    }cart_id, product_id, size_id, quantity
    @Transactional
    public void addToCart(Long cart_id,Long product_id , Long size_id, int quantity) {
        cartRepository.addCartItem(cart_id, product_id, size_id, quantity);
    }
    @Transactional
    public void updateCartItem(Long cartItemId, int quantity) {
        cartRepository.updateCartItem(cartItemId, quantity);
    }
    @Transactional
    public void removeCartItem(Long cartItemId) {
        cartRepository.removeCartItem(cartItemId);
    }

    public void checkout(Long cartId) {
        cartRepository.checkout(cartId);
    }
    
	

	public CartDTO getCart(Long cart_id) {
		CartEntity cart = cartRepository.getCart(cart_id);
		CartDTO result = cartDTOConverter.toCartDTO(cart);
		List<CartItemEntity> cartItems = cart.getCartItems();
		List<CartItemDTO> cartItemDTOs = new ArrayList<CartItemDTO>();
		for(CartItemEntity item: cartItems) {
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
}