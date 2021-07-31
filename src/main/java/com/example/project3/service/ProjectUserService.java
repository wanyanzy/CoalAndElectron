package com.example.project3.service;

import com.example.project3.pojo.ProjectUser;

import java.util.List;

public interface ProjectUserService {
	void insert (ProjectUser target);

	void drop (Integer id);

	void delete (Integer id);

	void update (ProjectUser target);

	List<ProjectUser> selectAll ();

	ProjectUser select (Integer id);

	List<ProjectUser> selectByCorporationId (Integer corporationId);
}
