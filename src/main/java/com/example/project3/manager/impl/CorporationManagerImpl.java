package com.example.project3.manager.impl;

import com.example.project3.dao.CorporationDao;
import com.example.project3.manager.CorporationManager;
import com.example.project3.pojo.Corporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CorporationManagerImpl implements CorporationManager {
	CorporationDao corporationDao;

	@Autowired
	public void setCorporationDao (CorporationDao corporationDao) {
		this.corporationDao = corporationDao;
	}

	@Override
	public Integer insert (Corporation target) {
		return corporationDao.save(target);
	}

	@Override
	public Integer delete (Integer id) {
		return corporationDao.delete(id);
	}

	@Override
	public Integer drop (Integer id) {
		return corporationDao.drop(id);
	}

	@Override
	public Integer update (Corporation target) {
		return corporationDao.update(target);
	}

	@Override
	public List<Corporation> selectAll () {
		return corporationDao.selectAll();
	}

	@Override
	public Corporation select (Integer id) {
		return corporationDao.select(id);
	}

	@Override
	public List<Corporation> selectByCorporateId (Integer corporateId) {
		return corporationDao.selectAll();
	}
}
