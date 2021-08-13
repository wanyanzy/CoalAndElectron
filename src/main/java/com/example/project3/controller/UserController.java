package com.example.project3.controller;

import com.example.project3.comons.exception.ProjectException;
import com.example.project3.comons.transporter.SuccessFactory;
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
	private SuccessFactory successFactory;
	private ProjectUserService projectUserService;

	@Autowired
	public void setProjectUserService (ProjectUserService projectUserService) {
		this.projectUserService = projectUserService;
	}

	@Autowired
	public void setSuccessFactory(SuccessFactory successFactory) {
		this.successFactory = successFactory;
	}

	@ApiOperation("新建用户")
	@GetMapping("/create/{userName}/{password}/{role}/{name}/{tel}/{department}/{corporateId}")
	public Transporter creat (@PathVariable("userName") String userName,
	                          @PathVariable("password") String password,
	                          @PathVariable("role") String role,
	                          @PathVariable("name") String name,
	                          @PathVariable("tel") String tel,
	                          @PathVariable("department") String department,
	                          @PathVariable("corporateId") Integer corporateId) throws CloneNotSupportedException {
		var projectUser = new ProjectUser();
		byte enable = 0;
		var transporter = successFactory.getDeliverPackage("创建成功");
		projectUser.setUserName(userName)
				.setPassword(password)
				.setRole(role)
				.setName(name)
				.setTel(tel)
				.setDepartment(department)
				.setCorporateId(corporateId)
				.setEnable(enable);
		projectUserService.insert(projectUser);
		transporter.addData("data",projectUser);
		return transporter;

	}

	@ApiOperation("查找公司旗下用户")
	@GetMapping("/selectByCorporateId/{corporateId}")
	public Transporter selectByCorporateId (@PathVariable("corporateId") Integer corporateId) throws CloneNotSupportedException {
		var result = projectUserService.selectByCorporationId(corporateId);
		var transporter = successFactory.getDeliverPackage(Integer.toString(result.size()));
		transporter.addData("data",result);
		return transporter;
	}

	@ApiOperation("删除指定用户")
	@GetMapping("/delete/{userId}/")
	public Transporter delete (@PathVariable("userId") Integer userId) throws CloneNotSupportedException {
		projectUserService.delete(userId);
		return successFactory.getDeliverPackage("成功删除");

	}

	@ApiOperation("更新用户信息")
	@GetMapping("update/{userId}/{userName}/{password}/{role}/{name}/{tel}/{department}/{corporateId}")
	public Transporter update (@PathVariable("userId") Integer userId,
	                           @PathVariable("userName") String userName,
	                           @PathVariable("password") String password,
	                           @PathVariable("role") String role,
	                           @PathVariable("name") String name,
	                           @PathVariable("tel") String tel,
	                           @PathVariable("department") String department,
							   @PathVariable("corporateId") Integer corporateId) throws CloneNotSupportedException {
		var user = new ProjectUser();
		byte enable = 0;
		user.setId(userId)
				.setUserName(userName)
				.setPassword(password)
				.setRole(role)
				.setName(name)
				.setTel(tel)
				.setDepartment(department)
				.setCorporateId(corporateId)
				.setEnable(enable);
		projectUserService.update(user);
		return successFactory.getDeliverPackage("更新成功");

	}

}
