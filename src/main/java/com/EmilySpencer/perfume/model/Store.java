package com.EmilySpencer.perfume.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_gen")
	@SequenceGenerator(name = "store_gen", sequenceName = "STORE_SEQ", allocationSize = 1)
	private long storeId;

	@Column
	private String name;

	@Column
	private String location;

	@Column
	private int phone;
	
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", name=" + name + ", location=" + location + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + phone;
		result = prime * result + (int) (storeId ^ (storeId >>> 32));
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
		Store other = (Store) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone != other.phone)
			return false;
		if (storeId != other.storeId)
			return false;
		return true;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Store(String name, String location, int phone) {
		super();
		this.name = name;
		this.location = location;
		this.phone = phone;
	}

	public Store() {
		super();
	}



}
