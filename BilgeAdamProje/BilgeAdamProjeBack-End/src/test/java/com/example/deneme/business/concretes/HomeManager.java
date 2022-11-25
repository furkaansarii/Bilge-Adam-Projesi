package com.example.deneme.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.deneme.business.abstracts.HomeService;
import com.example.deneme.entity.Home;
import com.example.deneme.repository.HomeRepository;
import com.example.deneme.request.HomeRequest;
import com.example.deneme.response.HomeResponse;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HomeManager implements HomeService{
	
	private final HomeRepository homeRepository;

	@Override
	public HomeResponse addHome(HomeRequest homeRequest) {
		 Home home = homeRepository.save(new Home(homeRequest.getCity(),homeRequest.getDistrict(),homeRequest.getNeighborhood(),homeRequest.getStatus()
			       ,homeRequest.getOwnerName(),homeRequest.getOwnerSurname(),homeRequest.getOwnerPhone(),homeRequest.getPrice()));
			       return HomeResponse.from(home);
	}

	@Override
	public HomeResponse updateHome(Long id, HomeRequest homeRequest) {
		 Home home = homeRepository.getById(id);
	        home.setCity(homeRequest.getCity());
	        home.setDistrict(homeRequest.getDistrict());
	        home.setNeighborhood(homeRequest.getNeighborhood());
	        home.setStatus(homeRequest.getStatus());
	        home.setOwnerName(homeRequest.getOwnerName());
	        home.setOwnerSurname(homeRequest.getOwnerSurname());
	        home.setOwnerPhone(homeRequest.getOwnerPhone());
	        home.setPrice(homeRequest.getPrice());
	        Home updatedHome = homeRepository.save(home);
	        return HomeResponse.from(updatedHome);
	}

	@Override
	public List<HomeResponse> getAll() {
		
		return homeRepository.findAll().stream().map(HomeResponse::from).collect(Collectors.toList());
	}

	@Override
	public void deleteHome(Long id) {
		Home home = homeRepository.getById(id);
		homeRepository.deleteById(home.getId());
		
	}

	@Override
	public List<HomeResponse> findAllStatusAndCity(String status, String city) {
		return homeRepository.findAllStatusAndCity(status, city).stream().map(HomeResponse::from).collect(Collectors.toList());
	}

	@Override
	public List<HomeResponse> findAllStatusAndCityAndDistrict(String status, String city, String district) {
		return homeRepository.findAllStatusAndCityAndDistrict(status, city, district).stream().map(HomeResponse::from).collect(Collectors.toList());

	}

	

	
	
	

}
