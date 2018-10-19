package com.unicom.engine_three.service;

import com.unicom.engine_three.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService {

    User getUserByName(String string);

    Map<String,Object> login(HttpServletRequest request);

    User getUserByNameAndPassword(User user);

}
