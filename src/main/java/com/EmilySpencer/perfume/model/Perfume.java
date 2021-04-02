package com.EmilySpencer.perfume.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Perfume {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfume_gen")
	@SequenceGenerator(name = "perfume_gen", sequenceName = "PERFUME_SEQ", allocationSize = 1)
	private long perfumeId;

	@Column
	private String name;

	@Column
	private Double price;

	@Column
	private String description;

	@Column
	private int volume;

	@Column
	private int yearReleased;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "StoreId")
	@JoinTable(name = "PERFUME_STORE")
	private List<Store> stores;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "brandId")
	private Brand brand;

	public Perfume(String name, Double price, String description, int volume, int yearReleased, List<Store> stores,
			Brand brand) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.volume = volume;
		this.yearReleased = yearReleased;
		this.stores = stores;
		this.brand = brand;
	}

	public Perfume() {
		super();
	}

	public long getPerfumeId() {
		return perfumeId;
	}

	public void setPerfumeId(long perfumeId) {
		this.perfumeId = perfumeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (perfumeId ^ (perfumeId >>> 32));
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((stores == null) ? 0 : stores.hashCode());
		result = prime * result + volume;
		result = prime * result + yearReleased;
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
		Perfume other = (Perfume) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (perfumeId != other.perfumeId)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (stores == null) {
			if (other.stores != null)
				return false;
		} else if (!stores.equals(other.stores))
			return false;
		if (volume != other.volume)
			return false;
		if (yearReleased != other.yearReleased)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Perfume [perfumeId=" + perfumeId + ", name=" + name + ", price=" + price + ", description="
				+ description + ", volume=" + volume + ", yearReleased=" + yearReleased + ", stores=" + stores
				+ ", brand=" + brand + "]";
	}
	
	

}