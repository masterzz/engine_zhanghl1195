package com.unicom.engine_three.service.impl;

import java.util.*;

import com.unicom.engine_three.model.User;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
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
    public List<Object> dayUseCondition() {


        List<UserCall> list = new ArrayList<>();
        List<Object> list1= new ArrayList<>();
        Set<String>  list2= new HashSet<>();
        list = userCallMapper.dayUseCondition();

        for (UserCall userCall:list) {
            list2.add(userCall.getStartDate());
        }


        List<Object> list3= new ArrayList<>();
        Map<String,Object> map_use = new HashMap<String,Object>();

        for (String value : list2) {
            list3= new ArrayList<>();
            map_use = new HashMap<String,Object>();

            for (UserCall userCall:list) {

                if (value.equals(userCall.getStartDate())){
                    System.out.println(userCall.getStartDate());
                    list3.add(userCall);
                }

            }
            map_use.put(value,list3);
            System.out.println(map_use);
            list1.add(map_use);
        }
        System.out.println(list1);
        return list1;
    }

    @Override
    public List<UserCall> userCondition(){
        return userCallMapper.userCondition();
    }

    @Override
    public List<Map<String, Object>> userJizhan() {
        return userCallMapper.selectJizhan();
    }


}
