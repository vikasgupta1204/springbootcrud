package com.springboot.jpatesting;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	@Order(1)
	@Rollback(value  =false)
	public void saveEmployeeTest() {
	
		Employee emp=Employee.builder().firstName("Rakesh").lastName("Singh").email("rak@gmail.com").build();
	
		Employee emp1=Employee.builder().
				firstName("mahesh").lastName("Singh").email("mah@gmail.com").build();
	
		Employee emp2=Employee.builder().
				firstName("Vikesh").lastName("Kumar").email("vik@gmail.com").build();
		
		Employee emp3=Employee.builder().
				firstName("Lokesh").lastName("Singh").email("lok@gmail.com").build();
		employeeRepository.save(emp);
	employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		employeeRepository.save(emp3);
		Assertions.assertThat(emp.getId()).isGreaterThan(0);
		List<Employee> employees =employeeRepository.findAll();
		System.out.println(employees);

		
		
	}
	@Test
	@Order(2)
	public void getEmployeeTest() {
		
		Employee employee =employeeRepository.findById((long)1).get();
		System.out.println(employee);
		Assertions.assertThat(employee.getId()).isEqualTo(1);
	}
	
	@Test
	@Order(3)
	public void getListOfEmployeeTest() {
		
		List<Employee> employees =employeeRepository.findAll();
		System.out.println(employees);
		System.out.println(employees.size());
		Assertions.assertThat(employees.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value=false)
	public void updateEmployee() {
		Employee emp=employeeRepository.findById(1L).get();
		emp.setEmail("jaipur@gmail.com");
		Employee updatedEmployee=employeeRepository.save(emp);
		Assertions.assertThat(updatedEmployee.getEmail()).isEqualTo("jaipur@gmail.com");
	}
	@Test
	@Order(5)
	@Rollback(value=false)
	public void deleteEmployee() {
		Employee employee = employeeRepository.findByEmail("jaipur@gmail.com");
		employeeRepository.delete(employee);
		Employee emp1=null;
		Optional<Employee> optionalEmployee=Optional.of(employeeRepository.findByEmail("jaipur@gmail.com"));
	
		if(optionalEmployee.isPresent()){
			emp1=optionalEmployee.get();
			
		}
		Assertions.assertThat(emp1).isNull();
	}
}
