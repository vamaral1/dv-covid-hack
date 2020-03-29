package com.pandemicsupply.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "test")
public class TestKit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String UPC;
	
	@JsonIgnore
	@OneToMany(mappedBy = "testKit")
	private List<FacilityTestKit> testKits;

	public TestKit() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUPC() {
		return UPC;
	}

	public void setUPC(String uPC) {
		UPC = uPC;
	}

	public List<FacilityTestKit> getTestKits() {
		return testKits;
	}

	public void setTestKits(List<FacilityTestKit> testKits) {
		this.testKits = testKits;
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
		TestKit other = (TestKit) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Test [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", UPC=");
		builder.append(UPC);
		builder.append("]");
		return builder.toString();
	}
	
}
