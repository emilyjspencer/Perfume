package com.EmilySpencer.perfume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_gen")
	@SequenceGenerator(name = "brand_gen", sequenceName = "BRAND_SEQ", allocationSize = 1)
	private long brandId;

	@Column
	private String name;

	@Column
	private int yearFounded;

	public Brand(String name, int yearFounded) {
		this.name = name;
		this.yearFounded = yearFounded;
	}

	public Brand() {
		super();
	}

	public long getBrandId() {
		return brandId;
	}

	public String getName() {
		return name;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (brandId ^ (brandId >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + yearFounded;
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
		Brand other = (Brand) obj;
		if (brandId != other.brandId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (yearFounded != other.yearFounded)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", name=" + name + ", yearFounded=" + yearFounded + "]";
	}
}
