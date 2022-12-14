package com.jpa.test.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entity.User;

public interface UserRepository extends CrudRepository<User,Integer>{

	//custom finder methods
	
	public List<User> findByName(String name);
	public List<User> findByCity(String  city);
	public List<User> findByStatus(String status);
	public List<User> findByCityAndStatus(String city,String status);
	public List<User> findByCityLikeAndNameLike(String city,String name);
	public List<User> findByNameStartingWith(String name);
	public List<User> findByNameEndingWith(String name);
	public List<User> findByCityContaining(String subbstr);
	public List<User> findByCityIn(Collection<String> city);
	
	@Query("select city from User")
	public List<String> getAllCities();
	
	@Query("select u from User u where u.city= :n")
	public List<User> getUSerByCityName(@Param("n") String city);
	
	@Query("select u from User u where u.name=:n and u.city=:c")
	public List<User> getDataByNameAndCity(@Param("n") String name,@Param("c") String city);
	
	@Query(value="select * from User", nativeQuery = true)
	public List<User> getAllUsers();
}
