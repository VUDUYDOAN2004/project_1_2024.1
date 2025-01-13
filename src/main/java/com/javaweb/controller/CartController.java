package com.javaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaweb.model.CartDTO;
import com.javaweb.model.CartItemDTO;
import com.javaweb.repository.entity.UserEntity;
import com.javaweb.service.impl.CartService;
import com.javaweb.service.impl.UserService;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;

    private UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.findUserByUserName(username);
    }

    @GetMapping(value="/cart")
    public ModelAndView cartPage() {
        UserEntity user = getCurrentUser();
        ModelAndView mav = new ModelAndView("cart");
        CartDTO cart = cartService.getCart(user.getCart().getCart_id());
        List<CartItemDTO> cartitems = cart.getCartItems();
        mav.addObject("cartitems", cartitems);
        mav.addObject("cart", cart);
        return mav;
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long product_id, @RequestParam Long size_id, @RequestParam int quantity) {
        UserEntity user = getCurrentUser();
        cartService.addToCart(user.getCart().getCart_id(), product_id, size_id, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/update")
    public String updateCartItem(@RequestParam("cart_item_id") Long cartItemId, @RequestParam("quantity") int quantity) {
        cartService.updateCartItem(cartItemId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeCartItem(@RequestParam Long cart_item_id) {
        UserEntity user = getCurrentUser();
        cartService.removeCartItem(user.getCart().getCart_id(), cart_item_id);
        return "redirect:/cart";
    }

    @GetMapping("/cart/checkout")
    public String checkout() {
        UserEntity user = getCurrentUser();
        cartService.checkout(user.getCart().getCart_id());
        return "checkoutSuccess";
    }
}
