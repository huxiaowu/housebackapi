package com.team.house.housebackapi.controller;

import com.team.house.housebackapi.entity.Users;
import com.team.house.housebackapi.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin(value = "*",allowCredentials ="true")
public class UserController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/userReg")
    public String userReg(Users users) {
        int temp = usersService.regUser(users);
        return "{\"result\":" + temp + "}";
    }

    @RequestMapping("/loginUser")
    public String loginUser(String name, String password, HttpSession session) {
        Users users = usersService.loginUer(name, password);
        if (users == null) {
            return "{\"result\":0}";  //登入失败
        } else {
            session.setAttribute("logininfo", users);
            session.setMaxInactiveInterval(10 * 60);
            return "{\"result\":1}";  //登入成功
        }
    }
}
