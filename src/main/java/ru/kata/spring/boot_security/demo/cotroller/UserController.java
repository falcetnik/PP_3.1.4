package ru.kata.spring.boot_security.demo.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getTemplateForUserList(ModelMap model) {
        User current = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<User> userList = new LinkedList<>();
        userList.add(current);
        model.addAttribute("users", userList);
        model.addAttribute("currentUser", current);

        return "user";
    }
}