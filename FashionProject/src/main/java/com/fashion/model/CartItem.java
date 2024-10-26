package com.fashion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_cart_item")
public class CartItem {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "cart_id",referencedColumnName = "id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "product_id",referencedColumnName = "id")
	private Product product;

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartItem(Integer id, Integer quantity, Cart cart, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.cart = cart;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
