package com.spring.cm.contactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.cm.contactmanager.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    /*Defining custom method to getch user by user email. 
    @Param is used to send the dynamic email into the query string */
    @Query("select u from User u where u.email=:email")
    public User getUserByUserName(@Param("email") String email);
}