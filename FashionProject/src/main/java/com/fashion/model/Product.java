package com.fashion.model;

import jakarta.persistence.Table;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name="tbl_product")
public class Product {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	 	@Column(name = "name")
	    @NotNull(message = "Tên sản phẩm là bắt buộc")
	    @Size(min = 1, max = 128, message = "Tên sản phẩm phải từ 1 đến 128 ký tự")
	    private String name;
	 	 @Column(name = "price")
	     @NotNull(message = "Giá bán là bắt buộc")
	     @Min(value = 0, message = "Giá bán phải lớn hơn hoặc bằng 0")
	    private Float price;
	    @Column(name="sale_price")
	    private Float salePrice;
	    @Column(name="image")
	    private String image;
	    @Column(name="status")
	    private Boolean status;
	    @Column(name="description",length = 4000)
	   
	    private String description;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @Column(name="created_at")
	    private Date createdAt;
	
	    
	    @ManyToOne
	    @JoinColumn(name = "category_id",referencedColumnName = "id")
	    private Category category;
	    
	    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
		private Set<ImageProduct> imageProducts;
	    
	    public Set<ImageProduct> getImageProducts() {
			return imageProducts;
		}

		public void setImageProducts(Set<ImageProduct> imageProducts) {
			this.imageProducts = imageProducts;
		}

		

		

		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Product(Integer id, String name, Float price, Float salePrice, String image, Boolean status,
				String description, Date createdAt, Category category,Set<ImageProduct> imageProducts) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.salePrice = salePrice;
			this.image = image;
			this.status = status;
			this.description = description;
			this.createdAt = createdAt;
			this.category = category;
			this.imageProducts = imageProducts;
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

		public Float getPrice() {
			return price;
		}

		public void setPrice(Float price) {
			this.price = price;
		}

		public Float getSalePrice() {
			return salePrice;
		}

		public void setSalePrice(Float salePrice) {
			this.salePrice = salePrice;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public Boolean getStatus() {
			return status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		

		
}
