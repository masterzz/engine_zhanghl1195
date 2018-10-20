package com.unicom.engine_three.service;

import com.unicom.engine_three.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {

    User getUserByName(String string);

    Map<String,Object> login(HttpServletRequest request);

    User getUserByNameAndPassword(User user);

    Map<String,Object> getall(int page, int rows);

    User get(int id) ;

    Map<String,Object>  delete(int id);

    Map<String,Object>  updatebyname(int id,String username,String role);

    Map<String,Object>  add(String username,String password,String role);




}
