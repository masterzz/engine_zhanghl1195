package com.unicom.engine_three.controller;

import com.unicom.engine_three.model.Test;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.unicom.engine_three.service.TestService;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/peixun/test/")
@Api("swagger相关的api测试")
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "hello",method = RequestMethod.GET)
    @ApiOperation(value = "欢迎页面", notes = "欢迎界面")
    @ApiImplicitParam(name = "id", value = "学生ID", paramType = "path", required = true, dataType = "Integer")
	public String hello(){
		return "hello";
	}

	
	@RequestMapping(value = "index",method = RequestMethod.GET)
    @ApiOperation(value = "测试数据库页面", notes = "测试数据库界面")
	public Test index(){
		System.out.println("index");
		//System.out.println(testService.findById(1));
		return testService.findById(1);
	}


	@RequestMapping(value = "pagetest/{page}/{rows}",method = RequestMethod.GET)
	@ApiOperation(value = "测试分页", notes = "测试分页界面")
	public Map<String,Object> findAllTest(@PathVariable int page, @PathVariable int rows){
		System.out.println("ok");
		return testService.getall(page,rows);
	}



}
