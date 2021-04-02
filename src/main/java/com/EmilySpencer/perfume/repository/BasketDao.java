package com.EmilySpencer.perfume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmilySpencer.perfume.model.Basket;

public interface BasketDao extends JpaRepository<Basket, Long> {

}
