package com.unicom.engine_three.controller;

import com.unicom.engine_three.model.User;
import com.unicom.engine_three.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login")
    public Map<String, Object> test1(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//		根据用户名找到user，并将用户的用户名信息、角色信息添加到session中
        return userService.login(request);
    }

    @RequestMapping(value = "/manage/{page}/{rows}")
    public Map<String, Object> manage(@PathVariable int page, @PathVariable int rows) {

        return userService.getall(page, rows);

    }

    @RequestMapping(value = "/manage/get/{id}")
    public User getUser(@PathVariable int id) {

        return userService.get(id);

    }

    @RequestMapping(value = "/manage/delete/{id}")
    public Map<String, Object> deleteUser(@PathVariable int id) {
        return userService.delete(id);
    }

    @RequestMapping(value = "/manage/update")
    public Map<String, Object> UpdateByUser(int id, String username,String role) {
        return userService.updatebyname(id,username,role);
        //}
    }

    @RequestMapping(value = "/manage/add")
    public Map<String, Object> addUser( String username,String password,String role) {
        return userService.add(username,password,role);
        //}
    }





}