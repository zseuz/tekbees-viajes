package com.tekbbes.viajes.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tekbbes.viajes.model.Travel;

public interface ITravelService{

	long count();
	
	public List<Travel> findAll();
	
	public Page<Travel> findAll(Pageable pageable);
	
	long countCity(Long id);
	
	long countCountry(Long id);
	
	public Travel findByid(Long id);
	
	public Travel save(Travel travel);
	
	
}
