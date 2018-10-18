package com.unicom.engine_three.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicom.engine_three.mapper.TestMapper;
import com.unicom.engine_three.model.Test;
import com.unicom.engine_three.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;

	@Override
	public Test findById(int id) {
		return testMapper.selectById(id);
	}

}
