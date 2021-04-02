package com.EmilySpencer.perfume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmilySpencer.perfume.model.Checkout;

public interface CheckoutDao extends JpaRepository<Checkout, Long> {

}
