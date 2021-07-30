package com.example.project3.manager.impl;

import com.example.project3.dao.ProjectUserDao;
import com.example.project3.manager.ProjectUserManager;
import com.example.project3.pojo.ProjectUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectUserManagerImpl implements ProjectUserManager {
    ProjectUserDao projectUserDao;

    @Autowired
    public void setProjectUserDao(ProjectUserDao projectUserDao) {
        this.projectUserDao = projectUserDao;
    }

    @Override
    public Integer insert(ProjectUser target) {
        return projectUserDao.save(target);
    }

    @Override
    public Integer drop(Integer id) {
        return projectUserDao.drop(id);
    }

    @Override
    public Integer delete(Integer id) {
        return projectUserDao.delete(id);
    }

    @Override
    public Integer update(ProjectUser target) {
        return projectUserDao.update(target);
    }

    @Override
    public List<ProjectUser> selectAll() {
        return projectUserDao.selectAll();
    }

    @Override
    public ProjectUser select(Integer id) {
        return projectUserDao.select(id);
    }

    @Override
    public List<ProjectUser> selectByCorporationId(Integer corporationId) {
        return projectUserDao.selectByCorporationId(corporationId);
    }
}
