package com.unicom.engine_three.controller;

import com.unicom.engine_three.model.User;
import com.unicom.engine_three.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/login")
    public Map<String, Object> test1(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//		根据用户名找到user，并将用户的用户名信息、角色信息添加到session中
        return userService.login(request);


    }



}
