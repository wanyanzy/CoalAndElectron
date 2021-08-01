package com.example.project3.controller;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.comons.transporter.Transporter;
import com.example.project3.pojo.ProjectUser;
import com.example.project3.service.ProjectUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	private Transporter transporter;
	private ProjectUserService projectUserService;

	@Autowired
	public void setProjectUserService (ProjectUserService projectUserService) {
		this.projectUserService = projectUserService;
	}

	@ApiOperation("新建用户")
	@GetMapping("/create/{userName}/{password}/{role}/{name}/{tel}/{department}/{corporateId}")
	public Transporter creat (@PathVariable("userName") String userName,
	                          @PathVariable("password") String password,
	                          @PathVariable("role") String role,
	                          @PathVariable("name") String name,
	                          @PathVariable("tel") String tel,
	                          @PathVariable("department") String department,
	                          @PathVariable("corporateId") Integer corporateId) throws ProjectException {
		var projectUser = new ProjectUser();
		projectUser.setUserName(userName)
				.setPassword(password)
				.setRole(role)
				.setName(name)
				.setTel(tel)
				.setDepartment(department)
				.setCorporateId(corporateId);
		return transporter;

	}

	@ApiOperation("查找公司旗下用户")
	@GetMapping("/selectByCorporateId/{corporateId}")
	public Transporter selectByCorporateId (@PathVariable("corporateId") Integer corporateId) throws ProjectException {
		var result = projectUserService.selectByCorporationId(corporateId);
		return transporter;
	}

	@ApiOperation("删除指定用户")
	@GetMapping("/delete/{userId}/")
	public Transporter delete (@PathVariable("userId") Integer userId) throws ProjectException {
		projectUserService.delete(userId);
		return transporter;
	}

	@ApiOperation("更新用户信息")
	@GetMapping("update/{userId}/{userName}/{password}/{role}/{name}/{tel}/{department}")
	public Transporter update (@PathVariable("userId") Integer userId,
	                           @PathVariable("userName") String userName,
	                           @PathVariable("password") String password,
	                           @PathVariable("role") String role,
	                           @PathVariable("name") String name,
	                           @PathVariable("tel") String tel,
	                           @PathVariable("department") String department) throws ProjectException {
		var user = new ProjectUser();
		user.setId(userId)
				.setUserName(userName)
				.setPassword(password)
				.setRole(role)
				.setName(name)
				.setTel(tel)
				.setDepartment(department);
		projectUserService.update(user);
		return transporter;

	}

}
