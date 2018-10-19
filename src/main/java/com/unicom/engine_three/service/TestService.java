package com.unicom.engine_three.service;

import com.unicom.engine_three.model.Test;

import java.util.Map;

public interface TestService {
	Test findById(int id);
	Map<String,Object> getall(int page, int rows);

}


