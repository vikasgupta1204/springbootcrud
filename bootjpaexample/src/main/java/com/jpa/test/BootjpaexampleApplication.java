package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entity.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
	ApplicationContext context=	  SpringApplication.run(BootjpaexampleApplication.class, args);
	
	UserRepository userRepository=context.getBean(UserRepository.class);
//	User user=new User();
//	user.setName("Ishan");
//	user.setCity("Chennai");
//	user.setStatus("Cricketer");
//	User user1=new User("Rajesh","Mumbaai","Programmer");
//	User user2=new User("Jagga","Delhi","Analyst");
//	User user3=new User("Trish","Kota","Model");
//	User user4=new User("Umesh","Lucknow","Farmer");
//	List<User> users=List.of(user,user1,user2,user3,user4);
//	//save multiple objects
//	Iterable<User> getUsers=userRepository.saveAll(users);
//	getUsers.forEach(userr->{
//		System.out.println(userr);
//		});
//	
	//-----------------XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx---------------
	
	//to update the data
//	Optional<User> optional=userRepository.findById(11);
//	System.out.println("optional data here!!");
//	System.out.println(optional);
//	System.out.println("Getting the optional data in user object");
//	User getUser=optional.get();
//	System.out.println("Printing the name!!");
//	System.out.println(getUser.getName()+" ");
//	System.out.println("updating name and city");
//	getUser.setName("Anuradha");
//	getUser.setCity("Jodhpur");
//	System.out.println("update operation");
//	User u=userRepository.save(getUser);
//	System.out.println("print data");
//	System.out.println(u);
	
//--------------------XXXXXXXXXXXXXXXXXXXXXXXXXXXXx----------------------
	//to fetch all the records in a table
	Iterable<User> itr=  userRepository.findAll();
	itr.forEach(user->{
		System.out.println(user	);
	});
	
	//userRepository.deleteById(11);
	//System.out.println("Deleted");
	Iterable<User> itr1=  userRepository.findAll();
	userRepository.deleteAll(itr1);
	
	
	
	}

}


