package com.northwindx.model.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "CategoryID")
	private int categoryID;
	@Lob
	@Column(name = "Description")
	private String description;
	@Basic(optional = false)
	@Column(name = "CategoryName")
	private String categoryName;
	@Lob
	@Column(name = "Picture")
	private byte[] picture;
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Collection<Product> products;

	public Category() { }

	public Category(Integer categoryID) {
		this(categoryID, null);
	}

	public Category(Integer categoryID, String categoryName) {
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.products = new ArrayList<Product>();
	}

	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public Collection<Product> getProducts() {
		return products;
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryID != other.categoryID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "com.northwindx.model.jpa.Categories[categoryID="
				+ categoryID + "]";
	}
}
