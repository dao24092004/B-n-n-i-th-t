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
@Table(name = "tbl_image_product")
public class ImageProduct {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Column(name = "image")
    private String image ;
	@ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;
	public ImageProduct(Integer id, String image, Product product) {
		super();
		this.id = id;
		this.image = image;
		this.product = product;
	}
	public ImageProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getId() {
		return id;
	}
	public String getImage() {
		return image;
	}
	public Product getProduct() {
		return product;
	}
	

}
