package com.javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaweb.repository.OrderRepository;
import com.javaweb.repository.entity.UserEntity;
import com.javaweb.service.impl.CartService;
import com.javaweb.service.impl.UserService;

@Controller
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserService userService;

    private UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userService.findUserByUserName(username);
    }

    @GetMapping("/orders")
    public ModelAndView orderPage() {
        UserEntity user = getCurrentUser();
        ModelAndView mav = new ModelAndView("orders");
        mav.addObject("orders", orderRepository.findByUser(user));
        return mav;
    }

    // @GetMapping(value="/orders/{order_id}")
    // public ModelAndView orderDetailPage(@PathVariable("order_id") Long orderId) {
    //     UserEntity user = getCurrentUser();
    //     ModelAndView mav = new ModelAndView("orderDetail");
    //     OrderDTO orderDetail = orderService.getOrder(orderId);
    //     List<OrderItemDTO> orderItems = orderDetail.getOrderItems();
    //     mav.addObject("orderItems", orderItems);
    //     mav.addObject("totalAmount", orderDetail.getTotalAmount());
    //     return mav;
    // }
}
