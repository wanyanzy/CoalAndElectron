package com.example.project3.dao;

import com.example.project3.pojo.Corporation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CorporationDao {

    Integer save (@Param("Corporation") Corporation corporation);

    Integer drop (@Param("id") Integer id);

    Integer delete(@Param("id") Integer id);

    Integer update (@Param("Corporation") Corporation corporation);

    Corporation select(@Param("id") Integer id);

    List<Corporation> selectAll ();



}
