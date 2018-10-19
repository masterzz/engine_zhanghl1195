package com.unicom.engine_three.service.impl;

import com.unicom.engine_three.mapper.UserMapper;
import com.unicom.engine_three.model.User;
import com.unicom.engine_three.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public User getUserByNameAndPassword(User user) {
        return userMapper.getUserByNameAndPassword(user);
    }

    @Override
    public Map<String,Object> login(HttpServletRequest request) {

        Map<String,Object> map= new HashMap<String,Object>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User user0 = new User();
        user0.setUsername(username);
        user0.setPassword(password);
//		获取用户
        User user = getUserByNameAndPassword(user0);
        if(user != null) {
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role",user.getPassword());

            map.put("username",user.getUsername());
            map.put("role",user.getRole());
            map.put("status",1);
            return map;
        }

        map.put("username",null);
        map.put("role",null);
        map.put("status",0);
        return map;
    }
}
