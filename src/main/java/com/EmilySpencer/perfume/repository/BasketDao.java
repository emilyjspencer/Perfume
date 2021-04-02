package com.EmilySpencer.perfume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmilySpencer.perfume.model.Basket;
import com.EmilySpencer.perfume.model.User;

public interface BasketDao extends JpaRepository<Basket, Long> {

	Basket getByUser(User user);

}
