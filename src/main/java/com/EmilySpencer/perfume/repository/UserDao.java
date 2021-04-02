package com.EmilySpencer.perfume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.EmilySpencer.perfume.model.User;

public interface UserDao extends JpaRepository<User, Long> {

	User getByUsernameAndPassword(String username, String password);

	@Query(value = "Select userId from User u where u.username = :username", nativeQuery = true)
	public List<Long> getUsername(@Param("username") String username);

	List<User> getByUsername(String username);

}