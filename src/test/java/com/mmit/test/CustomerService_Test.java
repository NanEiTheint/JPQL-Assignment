package com.mmit.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mmit.online.shop.Customer;
import com.mmit.online.shop.service.CustomerService;

@TestMethodOrder(OrderAnnotation.class)
class CustomerService_Test {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private CustomerService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf=Persistence.createEntityManagerFactory("13-jpa-relationship");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if(emf!=null && emf.isOpen())
		{
			emf.close();
		}
	}

	@BeforeEach
	void setUp() throws Exception {
		em=emf.createEntityManager();
		service=new CustomerService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	//@Test
	//@Order(1)
	void customer_info() {
		service.customer_info();
	}
	
	//@Test
	//@Order(2)
	void test_retrieve_data() {
		service.test_retrieve_data();
	}
	
	//@Test
	//@Order(3)
	void test_orderby_customer()
	{
		List<Customer> list=service.test_orderby_customer();
		for(Customer c : list)
		{
			System.out.println(c.getCustomerName());
		}
	}
	
	//@Test
	//@Order(4)
	void findByName()
	{
		List<Customer> list=service.findByName("Nan Ei");
		if(list!=null)
		{
			System.out.println(list.get(0).getEmail());
		}
	}
	
	//@Test
	//@Order(5)
	void findByIdWithFromTo()
	{
		List<Customer> list=service.findByIdWithFromTo(2, 6);
		if(list!=null)
		{
			for(Customer c:list)
			{
				System.out.println(c.getCustomerName()+" and "+c.getId());
			}
		}
	}
	
	//@Test
	//@Order(6)
	void totalCustomer()
	{
		Long total=service.totalCustomer();
		System.out.println("Number of customer:"+total);
	}
	
	//@Test
	//@Order(7)
	void startWithCustomerName()
	{
		List<Customer> list=service.startWithCustomerName("N");
		if(list!=null)
		{
			for(Customer c:list)
			{
				System.out.println(c.getCustomerName());
				
			}
		}
	}
	
	//@Test
	//@Order(8)
	void containCustomerName()
	{
		List<String> list=service.containCustomrName("n");
		if(list!=null)
		{
			for(String c:list)
			{
				System.out.println(c);
				
			}
		}
	}
	
	@Test
	@Order(9)
	void updateCustomerEmail()
	{
		service.updateCustomerEmail(1);
		String c=service.findById(1);
		System.out.println(c);
	}
	
	

}
