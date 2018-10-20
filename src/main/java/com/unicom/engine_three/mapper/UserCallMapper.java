package com.unicom.engine_three.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.unicom.engine_three.model.User;
import com.unicom.engine_three.model.UserCall;

@Mapper
public interface UserCallMapper {

    double getAverageCallTime();

    List<UserCall> dayCallTime();

    List<UserCall> dayUseCondition();

    List<UserCall> userCondition();

    List<Map<String,Object>> selectJizhan();
}