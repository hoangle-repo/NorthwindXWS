package com.northwindx.model.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ProductID")
	private int productID;
	@Basic(optional = false)
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "QuantityPerUnit")
	private String quantityPerUnit;
	@Column(name = "UnitPrice")
	private BigDecimal unitPrice;
	@Column(name = "UnitsInStock")
	private Short unitsInStock;
	@Column(name = "UnitsOnOrder")
	private Short unitsOnOrder;
	@Column(name = "ReorderLevel")
	private Short reorderLevel;
	@Basic(optional = false)
	@Column(name = "Discontinued")
	private boolean discontinued;
	@JoinColumn(name = "SupplierID", referencedColumnName = "SupplierID")
	@ManyToOne
	private Supplier supplier;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Collection<OrderDetail> orderDetails;
	@JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
	@ManyToOne
	private Category category;
	@Column(name = "CategoryID", insertable = false, updatable = false)
	private int categoryID;
	@Column(name = "SupplierID", insertable = false, updatable = false)
	private int supplierID;

	public Product() { }

	public Product(Integer productID) {
		this.productID = productID;
	}

	public Product(Integer productID, String productName, boolean discontinued) {
		this.productID = productID;
		this.productName = productName;
		this.discontinued = discontinued;
	}

	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}
	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Short getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(Short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public Short getUnitsOnOrder() {
		return unitsOnOrder;
	}
	public void setUnitsOnOrder(Short unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}
	public Short getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(Short reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	public boolean getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productID;
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
		Product other = (Product) obj;
		if (productID != other.productID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "com.northwindx.model.jpa.Products[productID="
			+ productID + "]";
	}
}
