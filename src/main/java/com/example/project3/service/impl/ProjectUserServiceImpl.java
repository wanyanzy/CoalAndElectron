package com.example.project3.service.impl;

import com.example.project3.manager.ProjectUserManager;
import com.example.project3.pojo.ProjectUser;
import com.example.project3.service.ProjectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectUserServiceImpl implements ProjectUserService {
	ProjectUserManager projectUserManager;

	@Autowired
	public void setProjectUserManager (ProjectUserManager projectUserManager) {
		this.projectUserManager = projectUserManager;
	}

	@Override
	public void insert (ProjectUser target) {
		projectUserManager.insert(target);
	}

	@Override
	public void drop (Integer id) {
		projectUserManager.drop(id);
	}

	@Override
	public void delete (Integer id) {
		projectUserManager.delete(id);
	}

	@Override
	public void update (ProjectUser target) {
		projectUserManager.update(target);
	}

	@Override
	public List<ProjectUser> selectAll () {
		return projectUserManager.selectAll();
	}

	@Override
	public ProjectUser select (Integer id) {
		return projectUserManager.select(id);
	}

	@Override
	public List<ProjectUser> selectByCorporationId (Integer corporationId) {
		return projectUserManager.selectByCorporationId(corporationId);
	}
}
