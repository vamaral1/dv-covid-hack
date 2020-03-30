package com.pandemicsupply.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private int id;
	private String city;
	private Double latitude;
	private Double longitude;
	private String phone;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "state_province")
	private String stateProvince;
	private String street;
	
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	private Facility facility;
	
	
	//ctors
	public Address() {
		super();
	}
	public Address(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Address(Double latitude, Double longitude, String phone) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.phone = phone;
	}
	public Address(String street, String city, String stateProvince, String postalCode) {
		super();
		this.city = city;
		this.postalCode = postalCode;
		this.stateProvince = stateProvince;
		this.street = street;
	}
	public Address(String street, String city, String stateProvince) {
		super();
		this.city = city;
		this.stateProvince = stateProvince;
		this.street = street;
	}
	
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	//getters & setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", city=");
		builder.append(city);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append(", stateProvince=");
		builder.append(stateProvince);
		builder.append(", street=");
		builder.append(street);
		return builder.toString();
	}
	
	
	
	
	
	

}
