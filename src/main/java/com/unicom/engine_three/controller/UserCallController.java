package com.unicom.engine_three.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unicom.engine_three.model.UserCall;
import com.unicom.engine_three.service.UserCallService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCallController {
    @Autowired
    UserCallService userCallService;

    //	每月的平均通话时长
    @RequestMapping(value="/averageCallTime")
    public double averageCallTime(){
        return userCallService.averageCallTime();
    }

    //	每天的通话时长（K线图）
    @RequestMapping(value="/dayCallTime")
    public List<UserCall> dayCallTime(){
        return userCallService.dayCallTime();
    }

    //	使用用户数按时段展示柱状图
    @RequestMapping(value="/dayUseCondition")
    public List<Object> dayUseCondition()
    {
        return userCallService.dayUseCondition();
    }

    // 根据用户数按时段展示柱状图
    @RequestMapping(value="/userCondition")
    public List<UserCall> userCondition()
    {
        return  userCallService.userCondition();
    }

    //根据基站统计热力图
    @RequestMapping(value="/userJizhan")
    public List<Map<String,Object>> userJizhan()
    {
        return  userCallService.userJizhan();
    }



}
