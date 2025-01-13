package com.javaweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaweb.repository.entity.UserEntity;
import com.javaweb.service.impl.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register"; 
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserEntity user, Model model) {
        try {
            userService.registerUser(user);
            model.addAttribute("successMessage", "Đăng ký thành công!");
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Đăng ký thất bại! Vui lòng thử lại.");
        }
        return "register"; 
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("error", "");
        return "login"; 
    }
    
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") UserEntity user, Model model) {
        UserEntity existingUser = userService.findUserByUserName(user.getUser_name());
        if (existingUser != null && passwordEncoder.matches(user.getPassword_hash(), existingUser.getPassword_hash())) {
            
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUser_name(), user.getPassword_hash());
            Authentication auth = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return "redirect:/";
        } else {
            model.addAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout"; 
    }
}
