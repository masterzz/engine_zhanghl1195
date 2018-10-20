package com.unicom.engine_three.mapper;

import com.unicom.engine_three.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserByName(String username);

    User getUserByNameAndPassword(User user);

    List<User> selectAllUser();

    @Select("select * from sys_user_1 where id = #{id}")
    User get(@Param("id") int id);

    @Delete("delete from sys_user_1 where id = #{id}")
    int delete(@Param("id") int id);

    @Update("update sys_user_1 set username = #{username} , role = #{role} where id = #{id}")
    int updatename(@Param("id") int id,@Param("username") String username,@Param("role") String role);

    @Insert("INSERT INTO sys_user_1(username,password,role) VALUES(#{username}, #{password}, #{role})")
    int add(@Param("username") String username,@Param("password") String password,@Param("role") String role );


}
