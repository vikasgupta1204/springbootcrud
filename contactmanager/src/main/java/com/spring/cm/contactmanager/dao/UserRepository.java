package com.spring.cm.contactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.cm.contactmanager.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    
}