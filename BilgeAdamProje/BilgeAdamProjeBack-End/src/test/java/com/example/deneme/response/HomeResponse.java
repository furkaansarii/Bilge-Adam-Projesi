package com.example.deneme.response;

import com.example.deneme.entity.Home;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeResponse {
	 	private String city;
	    private String district;
	    private String neighborhood;
	    private String status;
	    private String ownerName;
	    private String ownerSurname;
	    private String ownerPhone;
	    private int price;
	    
	    public static HomeResponse from(Home home) {
	    	return HomeResponse.builder()
	    			.city(home.getCity())
	    			.district(home.getDistrict())
	    			.neighborhood(home.getNeighborhood())
	    			.status(home.getStatus())
	    			.ownerName(home.getOwnerName())
	    			.ownerSurname(home.getOwnerSurname())
	    			.ownerPhone(home.getOwnerPhone())
	    			.price(home.getPrice())
	    			.build();
	    	
	    }
}
