package com.datarest.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datarest.springdatarest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
