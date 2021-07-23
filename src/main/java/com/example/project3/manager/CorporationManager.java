package com.example.project3.manager;

import com.example.project3.pojo.Corporation;

import java.util.List;

public interface CorporationManager {
    Integer insert (Corporation target);

    Integer delete (Integer id);

    Integer drop (Integer id);

    Integer update (Corporation target);

    List<Corporation> selectAll();

    Corporation select(Integer id);

    List<Corporation> selectByCorporateId(Integer corporateId);

}
