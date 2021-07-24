package com.example.project3.manager.impl;

import com.example.project3.dao.ProjectUserDao;
import com.example.project3.manager.ProjectUserManager;
import com.example.project3.pojo.ProjectUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectUserManagerImpl implements ProjectUserManager {
    ProjectUserDao projectUserDao;

    @Override
    public Integer insert(ProjectUser target) {
        return this.projectUserDao.save(target);
    }

    @Override
    public Integer drop(Integer id) {
        return this.projectUserDao.drop(id);
    }

    @Override
    public Integer delete(Integer id) {
        return this.projectUserDao.delete(id);
    }

    @Override
    public Integer update(ProjectUser target) {
        return this.projectUserDao.update(target);
    }

    @Override
    public List<ProjectUser> selectAll() {
        return this.projectUserDao.selectAll();
    }

    @Override
    public ProjectUser select(Integer id) {
        return this.projectUserDao.select(id);
    }
}
