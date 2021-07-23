package com.example.project3.dao;

import com.example.project3.pojo.ProjectUser;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectUserDao {
    Integer save (@Param("target") ProjectUser projectUser);

    Integer drop (@Param("id") Integer id);

    Integer delete(@Param("id") Integer id);

    Integer update(@Param("target") ProjectUser projectUser);

    ProjectUser select(@Param("id") Integer id);

    List<ProjectUser> selectAll();

}
