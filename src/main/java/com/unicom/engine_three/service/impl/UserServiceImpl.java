package com.unicom.engine_three.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unicom.engine_three.mapper.UserMapper;
import com.unicom.engine_three.model.User;
import com.unicom.engine_three.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public Map<String,Object> getall(int page, int rows) {

        PageHelper.startPage(page, rows);
        Map<String, Object> map1 = new HashMap<>();
        List<User> items = userMapper.selectAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(items);
        map1.put("list", items);
        map1.put("total", pageInfo.getTotal());
        return map1;
    }

    @Override
    public User get(int id) {
        // TODO Auto-generated method stub
        return userMapper.get(id);
    }

    @Override
    public Map<String, Object> delete(int id) {
        return null;
    }

    @Override
    @Transactional
    public Map<String,Object> updatebyname(int id,String username,String role) {

        Map<String, Object> map_update = new HashMap<>();

        if(userMapper.updatename(id,username,role) == 0 ){
            map_update.put("code", 0);
            map_update.put("message","fail");
            return  map_update;
        }
        map_update.put("code", 1);
        map_update.put("message","ok");
        return map_update;
    }

    @Override
    @Transactional
    public Map<String,Object> add(String username,String password,String role) {

        Map<String, Object> map_update = new HashMap<>();

        if(userMapper.add(username,password,role) == 0 ){
            map_update.put("code", 0);
            map_update.put("message","fail");
            return  map_update;
        }
        map_update.put("code", 1);
        map_update.put("message","ok");
        return map_update;
    }















}
