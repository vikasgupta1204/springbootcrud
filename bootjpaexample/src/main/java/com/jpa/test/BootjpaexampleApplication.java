package com.jpa.test;

import java.util.Collection;
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
//	User user1=new User("Rajesh","Mumbai","Programmer");
//	User user2=new User("Jagga","Delhi","Analyst");
//	User user3=new User("Trish","Kota","Model");
//	User user4=new User("Umesh","Lucknow","Cricketer");
//	User user5=new User("Govind","Delhi","Poltician");
//	User user6=new User("Gopal","Delhi","Teacher");
//	User user7=new User("Radhe","Delhi","Model");
//	User user8=new User("Tara","Jaipur","Teacher");
//	List<User> users=List.of(user,user1,user2,user3,user4,user5,user6 ,user7 ,user8);
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
//	Iterable<User> itr=  userRepository.findAll();
//	itr.forEach(usr->{
//		System.out.println(usr	);
//	});
	
	//userRepository.deleteById(11);
//	System.out.println("Deleted");
//	Iterable<User> itr1=  userRepository.findAll();
//	userRepository.deleteAll(itr1);
	
	
	//---------------------XXXXXXXXXXXXXXXXXXXXXXXXXXXX-----------------------
	//custom finder methods
//	Iterable<User> usersbyCity=userRepository.findByCity("Delhi");
//	usersbyCity.forEach(u1->{System.out.println(u1);});
//	System.out.println("----------------XXXXXXXXXXX------------------");
//	userRepository.findByCityAndStatus("Delhi","Teacher").forEach(fcs->{
//		System.out.println(fcs);
//	});
//	
//	//---------------------XXXXXXXXXXXXXXXXXXXXXXXXXXXX-----------------------
//	//findByCityLikeAndNameLike
//	System.out.println("---------------------XXXXXXXXXXXXXx-------------------");
//	userRepository.findByCityLikeAndNameLike("%u%","%a%").forEach(fcs->{
//		System.out.println(fcs);
//	});;
//	
//	System.out.println("---------------------XXXXXXXXXXXXXx-------------------");
//	userRepository.findByCityContaining("j").forEach(fcs->{
//		System.out.println(fcs);
//	});
//	
//	System.out.println("---------------------XXXXXXXXXXXXXXXX-------------------");
//	Collection<String> collection=List.of("Jaipur","Chennai","Jalandhar");
//	userRepository.findByCityIn(collection).forEach(fcs->{
//		System.out.println(fcs);
//	});
	//----------------->Query Language<--------------------------------------------
	userRepository.getAllCities().forEach(c->{
		System.out.println(c);
	});
	
	userRepository.getUSerByCityName("Delhi").forEach(c->{
		System.out.println(c);
	});
	//-----------------------XXXXXXXXXXXXXXXXXXXXXXXXXXXx-----------------
	userRepository.getDataByNameAndCity("Tara","Jaipur").forEach(c->{
		System.out.println(c);
	});
	
	//----------------------XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX---------------
	userRepository.getAllUsers().forEach(e->{System.out.println(e);});
	
	
	
	
	}
	//--------------------------------XXXXXXXXXXXX-------------------------------------
	
}


