package com.mmit.online.shop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import com.mmit.online.shop.Customer;

public class CustomerService {
	private EntityManager em;
		
		public CustomerService(EntityManager em)
		{
			this.em=em;
		}
		
		public void customer_info() {
			//Query interface(Dynamic Query)
			Query query=em.createQuery("SELECT c FROM Customer c");
			//TypeQuery interface(dynamic query)
			TypedQuery<Customer> c=em.createQuery("SELECT c FROM Customer c", Customer.class);
			
			//Query interface(static query)
			Query query2=em.createNamedQuery("Customer.getAll");
			
			//TypedQuery(static query)
			TypedQuery<Customer> query3=em.createNamedQuery("Customer.getAll", Customer.class);
		}
		
		public void test_retrieve_data() {
			Query query1=em.createQuery("SELECT c FROM Customer c");
			//Customer c=(Customer) query1.getSingleResult();
			//List<Item> list=query1.getResultList();
			
			TypedQuery<Customer> query2=em.createQuery("SELECT c FROM Customer c WHERE c.id=1", Customer.class);
			Customer c=query2.getSingleResult();//1
			
			List<Customer> c1=query2.getResultList();
			System.out.println("list "+c1.size());
			//assertEquals("123", c.getPassword());
		}
		
		public List<Customer> test_orderby_customer() {
			TypedQuery<Customer> query=em.createQuery("SELECT c FROM Customer c ORDER BY c.customerName desc", Customer.class);
			List<Customer> list=query.getResultList();
			
			return list;
		}

		public List<Customer> findByName(String na) {
			// TODO Auto-generated method stub
			TypedQuery<Customer> query=em.createNamedQuery("Customer.getName", Customer.class);
			query.setParameter(1, na);
			List<Customer> list=query.getResultList();
			return list;
		}
		
		public List<Customer> findByIdWithFromTo(int start,int end)
		{
			return em.createQuery("SELECT c FROM Customer c WHERE c.id>=:start and c.id<=:end", Customer.class)
					.setParameter("start", start)
					.setParameter("end", end).getResultList();
		}
		
		public Long totalCustomer()
		{
			return em.createQuery("SELECT COUNT(c.id) FROM Customer c", Long.class).getSingleResult();
		}
		
		public List<Customer> startWithCustomerName(String name)
		{
			return em.createQuery("SELECT c FROM Customer c WHERE c.customerName LIKE :name", Customer.class)
					.setParameter("name", name.concat("%")).getResultList();
		}
		
		public List<String> containCustomrName(String name)
		{
			return em.createQuery("SELECT c.customerName FROM Customer c WHERE c.customerName LIKE :name", String.class)
					.setParameter("name","%".concat(name).concat("%")).getResultList();
		}
		public void updateCustomerEmail(int id)
		{
			em.getTransaction().begin();
			em.createQuery("UPDATE Customer c SET c.email='naneitheint@gmail.com' WHERE c.id=:id")
			.setParameter("id", id)
			.executeUpdate();
			em.getTransaction().commit();
		}

		public String findById(int id) {
			return em.createQuery("SELECT c.email FROM Customer c WHERE c.id=:id", String.class)
					.setParameter("id", id)
					.getSingleResult();
		}
}
