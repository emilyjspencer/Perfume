package com.EmilySpencer.perfume.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "basket_gen")
	@SequenceGenerator(name = "basket_gen", sequenceName = "BASKET_SEQ", allocationSize = 1)
	private long basketId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId")
	private User user;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "perfumeId")
	@JoinTable(name = "BASKET_PERFUME")
	private List<Perfume> perfumes;

	public Basket(List<Perfume> perfumes, User user) {
		super();
		this.perfumes = perfumes;
		this.user = user;
	}

	public Basket() {
		super();
	}

	public long getBasketId() {
		return basketId;
	}

	public void setBasketId(long basketId) {
		this.basketId = basketId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Perfume> getPerfumes() {
		return perfumes;
	}

	public void setPerfumes(List<Perfume> perfumes) {
		this.perfumes = perfumes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (basketId ^ (basketId >>> 32));
		result = prime * result + ((perfumes == null) ? 0 : perfumes.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Basket other = (Basket) obj;
		if (basketId != other.basketId)
			return false;
		if (perfumes == null) {
			if (other.perfumes != null)
				return false;
		} else if (!perfumes.equals(other.perfumes))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Basket [basketId=" + basketId + ", user=" + user + ", perfumes=" + perfumes + "]";
	}

}
