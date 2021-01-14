package com.mmit.online.shop;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "category", cascade = REMOVE, orphanRemoval = true)
	private List<Item> items;
	public Category() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
   
}
