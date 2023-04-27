package com.tekbbes.viajes.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tekbbes.viajes.dao.ITravelDao;
import com.tekbbes.viajes.model.Travel;
import com.tekbbes.viajes.service.ITravelService;

import jakarta.transaction.Transactional;

@Service
public class TravelServiceImpl implements ITravelService {

	@Autowired
	private ITravelDao travelDao;
	
	@Override
	public long count() {
		return travelDao.count();
	}

	@Override
	public long countCity(Long id) {
		return travelDao.countCity(id);
	}

	@Override
	public long countCountry(Long id) {
		return travelDao.countCountry(id);
	}

	@Override
	public Travel findByid(Long id) {
		return travelDao.findById(id).orElse(null);
	}

	@Override
	public List<Travel> findAll() {
		return travelDao.findAll();
	}

	@Override
	public Page<Travel> findAll(Pageable pageable) {
		return travelDao.findAll(pageable);
	}

	@Override
	@Transactional()
	public Travel save(Travel travel) {
		return travelDao.save(travel);
	}

}
