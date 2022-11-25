package com.example.deneme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.deneme.entity.Home;

public interface HomeRepository extends JpaRepository<Home, Long>{
	
	@Query("FROM Home WHERE status=:status AND city=:city")
	List<Home> findAllStatusAndCity(String status,String city);
	
	@Query("FROM Home WHERE status=:status AND city=:city AND district=:district")
	List<Home> findAllStatusAndCityAndDistrict(String status,String city,String district);

	
}
