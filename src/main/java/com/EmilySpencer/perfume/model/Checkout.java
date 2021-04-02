package com.EmilySpencer.perfume.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Checkout {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkout_gen")
	@SequenceGenerator(name = "checkout_gen", sequenceName = "CHECKOUT_SEQ", allocationSize = 1)
	private long checkoutId;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "basketId")
	private Basket basket;

	public Checkout(Basket basket) {
		super();
		this.basket = basket;
	}
	
	public Checkout() {
		super();
	}

	public long getCheckoutId() {
		return checkoutId;
	}

	public void setCheckoutId(long checkoutId) {
		this.checkoutId = checkoutId;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		result = prime * result + (int) (checkoutId ^ (checkoutId >>> 32));
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
		Checkout other = (Checkout) obj;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
			return false;
		if (checkoutId != other.checkoutId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Checkout [checkoutId=" + checkoutId + ", basket=" + basket + "]";
	}
	
	
}
