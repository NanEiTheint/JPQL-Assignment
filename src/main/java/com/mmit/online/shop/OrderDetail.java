package com.mmit.online.shop;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Entity implementation class for Entity: OrderDetail
 *
 */
@Entity

public class OrderDetail implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private int subQty;
	private int subTotal;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name = "orders_id")
	private Orders orders;

	public OrderDetail() {
		super();
	}
   
}
