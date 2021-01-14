package com.mmit.online.shop;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Orders
 *
 */
@Entity

public class Orders implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private LocalDate orderDate;
	private int totalQty;
	private int totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "orders", cascade = REMOVE, orphanRemoval = true)
	private List<OrderDetail> orderDetails;

	public Orders() {
		super();
	}
   
}
