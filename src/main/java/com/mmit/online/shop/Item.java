package com.mmit.online.shop;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity

public class Item implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String name;
	private int price;
	private LocalDate expireDate;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@OneToMany(mappedBy = "item", cascade = REMOVE, orphanRemoval = true)
	private List<OrderDetail> orderDetails;
	public Item() {
		super();
	}
   
}
