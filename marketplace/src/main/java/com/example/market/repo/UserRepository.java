package com.example.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.market.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
