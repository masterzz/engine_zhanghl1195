package com.unicom.engine_three.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.unicom.engine_three.model.Test;

@Mapper
public interface TestMapper {
	Test selectById(int id);
	List<Test> selectAll();
}
