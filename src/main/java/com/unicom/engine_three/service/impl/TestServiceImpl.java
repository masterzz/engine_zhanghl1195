package com.unicom.engine_three.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicom.engine_three.mapper.TestMapper;
import com.unicom.engine_three.model.Test;
import com.unicom.engine_three.service.TestService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;

	@Override
	public Test findById(int id) {
		return testMapper.selectById(id);
	}


    @Override
    public Map<String,Object> getall(int page, int rows) {

        Map<String, Object> map = new HashMap<>();

        PageHelper.startPage(page, rows);

        //System.out.println("begin");
        List<Test> items = testMapper.selectAll();
        System.out.println(items);
        PageInfo<Test> pageInfo = new PageInfo<Test>();
        System.out.println(pageInfo);
        map.put("list", items);
        map.put("total", pageInfo.getTotal());
        return map;
    }
}
