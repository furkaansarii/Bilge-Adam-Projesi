package com.example.deneme.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.deneme.request.HomeRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "home")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Home {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String city;
	private String district;
	private String neighborhood;
	private String status;
	private String ownerName;
	private String ownerSurname;
	private String ownerPhone;
	private int price;
	public Home(String city, String district, String neighborhood, String status, String ownerName, String ownerSurname,
			String ownerPhone, int price) {
		this.city = city;
		this.district = district;
		this.neighborhood = neighborhood;
		this.status = status;
		this.ownerName = ownerName;
		this.ownerSurname = ownerSurname;
		this.ownerPhone = ownerPhone;
		this.price = price;
	}
	
	public static Home from(HomeRequest homeRequest) {
		return Home.builder()
				.city(homeRequest.getCity())
				.district(homeRequest.getDistrict())
				.neighborhood(homeRequest.getNeighborhood())
				.status(homeRequest.getStatus())
				.ownerName(homeRequest.getOwnerName())
				.ownerSurname(homeRequest.getOwnerSurname())
				.ownerPhone(homeRequest.getOwnerPhone())
				.price(homeRequest.getPrice())
				.build();
	}
	
	

}
