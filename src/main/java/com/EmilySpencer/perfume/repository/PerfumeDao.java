package com.EmilySpencer.perfume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmilySpencer.perfume.model.Perfume;

public interface PerfumeDao extends JpaRepository<Perfume, Long> {

}