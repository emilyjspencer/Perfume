package com.EmilySpencer.perfume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmilySpencer.perfume.model.Store;

public interface StoreDao extends JpaRepository<Store, Long> {

}
