package com.example.market.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.market.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	void deleteUserById(Long id);

    Optional<User> findUserById(Long id);
	
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);


}
