package com.EmilySpencer.perfume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmilySpencer.perfume.model.User;

public interface UserDao extends JpaRepository<User, Long> {

	User getByUsernameAndPassword(String username, String password);

}