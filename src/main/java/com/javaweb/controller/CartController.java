package com.javaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaweb.model.CartDTO;
import com.javaweb.model.CartItemDTO;
import com.javaweb.repository.entity.CartItemEntity;
import com.javaweb.service.impl.CartService;

@Controller

public class CartController {

    @Autowired
    private CartService cartService;
    
    @GetMapping(value="/cart")
    public ModelAndView cartPage() {
    	ModelAndView mav = new ModelAndView("cart");
    	CartDTO cart = cartService.getCart(1L);
    	List<CartItemDTO> cartitems = cart.getCartItems();
    	mav.addObject("cartitems", cartitems);
    	mav.addObject("cart", cart);
    	return mav;
    }
    

    @PostMapping("/cart/add")
    public String addToCart( @RequestParam Long cart_id,@RequestParam Long product_id, @RequestParam Long size_id, @RequestParam int quantity) {
    	
        cartService.addToCart(cart_id, product_id, size_id, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/update")
    public String updateCartItem(@RequestParam Long cart_item_id, @RequestParam int quantity) {
        cartService.updateCartItem(cart_item_id, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeCartItem(@RequestParam Long cart_item_id) {
        cartService.removeCartItem(cart_item_id);
        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String checkout(@RequestParam Long cartId) {
        cartService.checkout(cartId);
        return "redirect:/order/confirmation";
    }
}
