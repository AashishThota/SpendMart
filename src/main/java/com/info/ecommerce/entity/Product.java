package com.info.ecommerce.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "product")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "sku")
	private String sku;
	@ManyToOne
	@JoinColumn(name = "category_id",nullable = false)
	private ProductCategory category;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "unit_price")
	private BigDecimal unitPrice;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "active")
	private boolean active;
	@Column(name = "units_in_stock")
	private int unitInStock;
	@Column(name = "date_created")
	private Date dateCreated;
	@Column(name = "last_updated")
	private Date lastUpdated;
}
