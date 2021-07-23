package com.example.project3.manager.impl;

import com.example.project3.dao.CorporationDao;
import com.example.project3.manager.CorporationManager;
import com.example.project3.pojo.Corporation;

import java.util.List;

public class CorporationManagerImpl implements CorporationManager {
    CorporationDao corporationDao;

    @Override
    public Integer insert(Corporation target) {
        return this.corporationDao.save(target);
    }

    @Override
    public Integer delete(Integer id) {
        return this.corporationDao.delete(id);
    }

    @Override
    public Integer drop(Integer id) {
        return this.drop(id);
    }

    @Override
    public Integer update(Corporation target) {
        return this.update(target);
    }

    @Override
    public List<Corporation> selectAll() {
        return this.corporationDao.selectAll();
    }

    @Override
    public Corporation select(Integer id) {
        return null;
    }

    @Override
    public List<Corporation> selectByCorporateId(Integer corporateId) {
        return null;
    }
}
