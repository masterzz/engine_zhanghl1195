package com.unicom.engine_three.mapper;

import com.unicom.engine_three.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByName(String username);

    User getUserByNameAndPassword(String username, String password);

    User getUserByNameAndPassword(User user);
}
