package com.fashion.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "tbl_category")
public class Category {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name =  "name")
	private String name;
	@Column(name = "status")
	private Boolean status;
	@Valid
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private Set<Product> products;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id, String name, Boolean status, Set<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.products = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Set<Product> getProduct() {
		return products;
	}

	public void setProduct(Set<Product> product) {
		this.products= product;
	}

		
	
	
	
	
	
}