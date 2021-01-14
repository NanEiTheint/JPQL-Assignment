package com.mmit.test;

import static org.junit.jupiter.api.Assertions.*;

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

import com.mmit.online.shop.Category;
import com.mmit.online.shop.service.CategoryService;


@TestMethodOrder(OrderAnnotation.class)
class CategoryService_Test {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private CategoryService service;
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
		service=new CategoryService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	//@Test
	//@Order(1)
	void findById() 
	{
		Category c=service.findById(3);
		if(c!=null)
		{
			System.out.println("Find With ID 3................");
			System.out.println("Category Name:"+c.getName());
		}
	}
	
	//@Test
	//@Order(2)
	void orderByNameCategory()
	{
		List<Category> list=service.orderByNameCategory();
		System.out.println("Category List Order By Name.........................");
		for(Category c:list)
		{	
			System.out.println(c.getName());
		}
	}
	
	//@Test
	//@Order(3)
	void greatestIdCategory()
	{
		Category c=service.greatestIdCategory();
		System.out.println("Category With Greatest Id..............");
		System.out.println(c.getId()+"   "+c.getName());
	}
	
	//@Test
	//@Order(4)
	void endWithCategory()
	{
		List<Category> list=service.endWithCategory("s");
		if(list!=null)
		{
			System.out.println("Category End With s...........................");
			for(Category c:list)
			{
				System.out.println(c.getName());
			}
		}
	}
	
	//@Test
	//@Order(5)
	void updateCategoryById()
	{
		service.updateCategoryById(2, "Boy Shoes");
		Category c=service.findById(2);
		System.out.println("Updated Category.............");
		System.out.println(c.getName());
	}
	
	//@Test
	//@Order(6)
	void removeCategoryById()
	{
		service.removeCategoryById(1);
	}
	
	@Test
	@Order(7)
	void removeCategoryByIds()
	{
		service.removeCategoryByIds(2, 3, 4);
	}

}
