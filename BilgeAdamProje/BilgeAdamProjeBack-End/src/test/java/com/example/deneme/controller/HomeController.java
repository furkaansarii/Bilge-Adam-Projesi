package com.example.deneme.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.deneme.business.abstracts.HomeService;
import com.example.deneme.entity.Home;
import com.example.deneme.repository.HomeRepository;
import com.example.deneme.request.HomeRequest;
import com.example.deneme.response.HomeResponse;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {
	
	private final HomeService homeService;
	private final HomeRepository homeRepository;
	
	@PostMapping("/homes")
    @ResponseStatus(HttpStatus.CREATED)
    public HomeResponse addHome(@RequestBody HomeRequest homeRequest){
        return homeService.addHome(homeRequest);
    }
	
	@PutMapping("/homes/{id}")
    public HomeResponse updatedHome(@PathVariable Long id, @RequestBody HomeRequest homeRequest){
        return homeService.updateHome(id, homeRequest);
    }
	
	@DeleteMapping("/homes/{id}")
    public void deleteHome(@PathVariable Long id){
        homeService.deleteHome(id);
    }
	
	@GetMapping("/home-status-city")
	public List<HomeResponse> findAllStatusAndCity(@RequestParam String status,String city){
		return homeService.findAllStatusAndCity(status, city);
	}
	
	@GetMapping("/home-status-city-district")
	public List<HomeResponse> findAllStatusAndCityAndDistrict(@RequestParam String status,String city,String district){
		return homeService.findAllStatusAndCityAndDistrict(status, city, district);
	}
	
	
	
	
	
	
	
	@GetMapping("/homes")
    public List<HomeResponse> getAll(){
        return homeService.getAll();
    }

}
