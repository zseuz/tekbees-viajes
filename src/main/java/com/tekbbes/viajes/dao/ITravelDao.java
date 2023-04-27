package com.tekbbes.viajes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.tekbbes.viajes.model.Travel;

public interface ITravelDao extends JpaRepository<Travel, Long>{

	long count();
	
	@Query("select count(t) from Travel t inner join City c on c.id = t.city where c.id = :id")
	long countCity(@RequestParam("id")Long id);
	
	@Query("select count(t) from Travel t inner join Country c on c.id = t.country where c.id = :id ")
	long countCountry(@RequestParam("id")Long id);
	
}
