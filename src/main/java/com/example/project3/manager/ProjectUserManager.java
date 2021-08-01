package com.example.project3.manager;


import com.example.project3.pojo.ProjectUser;

import java.util.List;

public interface ProjectUserManager {
	Integer insert (ProjectUser target);

	Integer drop (Integer id);

	Integer delete (Integer id);

	Integer update (ProjectUser target);

	List<ProjectUser> selectAll ();

	ProjectUser select (Integer id);

	List<ProjectUser> selectByCorporationId (Integer corporationId);
}
