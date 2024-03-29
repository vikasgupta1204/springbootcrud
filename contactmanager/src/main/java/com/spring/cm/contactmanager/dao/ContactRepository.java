package com.spring.cm.contactmanager.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.cm.contactmanager.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
    //pagination....
    @Query("from Contact as c where c.user.id=:userId")
    /*pageable contains two information i.e current page and contact per page */
    public Page<Contact> findContactByUser(@Param("userId") int userId, Pageable pageable); 

}