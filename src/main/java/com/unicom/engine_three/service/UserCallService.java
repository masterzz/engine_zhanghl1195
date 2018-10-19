package com.unicom.engine_three.service;

import java.util.List;
import java.util.Map;

import com.unicom.engine_three.model.UserCall;

public interface UserCallService {
    double averageCallTime();

    List<UserCall> dayCallTime();

    List<UserCall> dayUseCondition(String day);

    List<UserCall> userCondition();
}
