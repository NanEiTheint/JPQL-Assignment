package com.mmit.online.shop.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.mmit.online.shop.Category;

public class CategoryService {

	private EntityManager em;
	public CategoryService(EntityManager em) {
		this.em=em;
	}
	
	public Category findById(int id)
	{
		return em.createQuery("SELECT c FROM Category c WHERE c.id=:id", Category.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public List<Category> orderByNameCategory()
	{
		return em.createQuery("SELECT c FROM Category c ORDER BY c.name desc", Category.class)
				.getResultList();
	}
	
	public Category greatestIdCategory()
	{
		return em.createQuery("SELECT c FROM Category c WHERE c.id=(SELECT MAX(c.id) FROM Category c)", Category.class)
				.getSingleResult();
	}
	
	public List<Category> endWithCategory(String name)
	{
		return em.createQuery("SELECT c FROM Category c WHERE c.name LIKE :name", Category.class)
				.setParameter("name", name.concat("%s"))
				.getResultList();
	}

	public void updateCategoryById(int id,String updateName)
	{
		em.getTransaction().begin();
		em.createQuery("UPDATE Category c SET c.name=:updateName WHERE c.id=:id")
		.setParameter("updateName", updateName)
		.setParameter("id", id)
		.executeUpdate();
		em.getTransaction().commit();
	}
	
	public void removeCategoryById(int id)
	{
		Category c=em.find(Category.class, id);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		
	}
	
	public void removeCategoryByIds(int id1,int id2, int id3)
	{
		em.getTransaction().begin();
		em.createQuery("DELETE FROM Category c WHERE c.id=:id1 OR c.id=:id2 OR c.id=:id3")
		.setParameter("id1", id1)
		.setParameter("id2", id2)
		.setParameter("id3", id3)
		.executeUpdate();
		em.getTransaction().commit();
	}
}
