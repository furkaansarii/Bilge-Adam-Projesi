package com.example.deneme.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.deneme.entity.Home;
import com.example.deneme.request.HomeRequest;
import com.example.deneme.response.HomeResponse;

public interface HomeService {
	
	HomeResponse addHome(HomeRequest homeRequest);
	HomeResponse updateHome(Long id, HomeRequest homeRequest);
	
	List<HomeResponse> findAllStatusAndCity(String status,String city);
	List<HomeResponse> findAllStatusAndCityAndDistrict(String status,String city,String district);

	List<HomeResponse> getAll();
	void deleteHome(Long id);
}
