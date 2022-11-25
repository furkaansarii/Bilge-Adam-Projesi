package com.example.deneme.request;

import lombok.Data;

@Data
public class HomeRequest {
	
	 	private String city;
	    private String district;
	    private String neighborhood;
	    private String status;
	    private String ownerName;
	    private String ownerSurname;
	    private String ownerPhone;
	    private int price;

}
