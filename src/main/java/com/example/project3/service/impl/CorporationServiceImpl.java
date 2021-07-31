package com.example.project3.service.impl;

import com.example.project3.manager.CorporationManager;
import com.example.project3.pojo.Corporation;
import org.springframework.stereotype.Service;
import com.example.project3.service.CorporationService;

import java.util.List;
@Service
public class CorporationServiceImpl implements CorporationService {
    private CorporationManager corporationManager;

    public void setCorporationManager(CorporationManager corporationManager) {
        this.corporationManager = corporationManager;
    }

    @Override
    public void insert(Corporation corporation) {
        corporationManager.insert(corporation);
    }

    @Override
    public void delete(Integer corporationId) {
        corporationManager.delete(corporationId);
    }

    @Override
    public void drop(Integer corporationId) {
        corporationManager.drop(corporationId);
    }

    @Override
    public Corporation select(Integer corporationId) {
        return corporationManager.select(corporationId);
    }


    @Override
    public List<Corporation> selectByCorporateId(Integer corporationId) {
        return corporationManager.selectByCorporateId(corporationId);
    }

    @Override
    public List<Corporation> selectAll() {
        return corporationManager.selectAll();
    }

    @Override
    public void update(Corporation corporation) {
        corporationManager.update(corporation);
    }
}
