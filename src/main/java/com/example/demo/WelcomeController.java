package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    private UsersService usersService;
    @Autowired private ApplicationContext applicationContext;

    @PostConstruct
    public void inited() {
        usersService = (UsersService) applicationContext.getBean("usersService");
        Assert.notNull(usersService);
    }

    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        List<User> users = usersService.getUsers();
        model.put("users", users);
        return "main";
    }
}
