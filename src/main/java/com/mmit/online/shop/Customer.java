package com.mmit.online.shop;

import java.io.Serializable;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@Table(name="customers")
@NamedQuery(name = "Customer.getAll",query = "SELECT c FROM Customer c")
@NamedQuery(name = "Customer.getName",query = "SELECT c FROM Customer c WHERE c.customerName=?1")
public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	@Column(name="customer_name")
	private String customerName;
	private String email;
	private String password;
	private String phone;
	
//	@OneToMany(mappedBy = "customer", cascade = REMOVE, orphanRemoval = true)
//	private List<Orders> orders;
	
	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
