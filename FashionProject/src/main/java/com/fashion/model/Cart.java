package com.fashion.model;



import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.websocket.OnError;

@Entity
@Table(name = "tbl_cart")
public class Cart {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private User user;
	
	@OneToMany(mappedBy = "cart")
	private Set<CartItem> cartItems;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Integer id, User user, Set<CartItem> cartItems) {
		super();
		this.id = id;
		this.user = user;
		this.cartItems = cartItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	
	
	

}
