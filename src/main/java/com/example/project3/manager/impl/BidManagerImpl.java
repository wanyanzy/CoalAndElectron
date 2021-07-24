package com.example.project3.manager.impl;

import com.example.project3.dao.BidDao;
import com.example.project3.manager.BidManager;
import com.example.project3.pojo.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidManagerImpl implements BidManager {

    BidDao bidDao;

    @Autowired
    public void setBidDao (BidDao bidDao){
        this.bidDao=bidDao;
    }

    @Override
    public Integer insert (Bid target){
        return this.bidDao.save(target);
    }

    @Override
    public Integer drop (Integer id){
        return this.bidDao.drop(id);
    }

    @Override
    public Integer delete (Integer id){
        return this.bidDao.delete(id);
    }

    @Override
    public Integer update (Bid target){
        return this.bidDao.update(target);
    }

    @Override
    public List<Bid> selectAll(){
        return this.bidDao.selectAll();
    }

    @Override
    public Bid select(Integer id){
        return this.bidDao.select(id);
    }

    @Override
    public List<Bid> selectByCorporateId(Integer corporateId){
        return this.bidDao.selectByCorporationId(corporateId);
    }


}
