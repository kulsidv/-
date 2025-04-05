package ru.kpfu.itis.kulsidv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.kulsidv.entity.User;
import ru.kpfu.itis.kulsidv.service.CustomUserDetailsService;

@Controller
public class RegistrationController {

    @Autowired
    private CustomUserDetailsService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // Проверка, существует ли пользователь
        if (userService.loadUserByUsername(user.getUsername()) != null) {
            return "redirect:/index";
        }

        // Создание нового пользователя
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Сохранение пользователя
        userService.saveUser(user);

        return "redirect:/login?registered";
    }
}
