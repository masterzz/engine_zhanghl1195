package com.unicom.engine_three.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicom.engine_three.mapper.UserCallMapper;
import com.unicom.engine_three.model.UserCall;
import com.unicom.engine_three.service.UserCallService;

@Service
public class UserCallServiceImpl implements UserCallService{
    @Autowired
    UserCallMapper userCallMapper;

    @Override
    public double averageCallTime() {
//		单位为分钟
        return userCallMapper.getAverageCallTime();
    }

    @Override
    public List<UserCall> dayCallTime() {
        return userCallMapper.dayCallTime();
    }

    @Override
    public List<UserCall> dayUseCondition(String day) {
        return userCallMapper.dayUseCondition(day);
    }


    @Override
    public List<UserCall> userCondition(){
        return userCallMapper.userCondition();
    }

}
