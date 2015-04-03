package com.northwindx.model.jpa;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@Column(name = "OrderID")
	private int orderID;
	@Basic(optional = false)
	@Column(name = "ProductID")
	private int productID;
	
	public OrderDetailPK() { }
	
	public OrderDetailPK(int orderID, int productID) {
		this.orderID = orderID;
		this.productID = productID;
	}

	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderID;
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
		OrderDetailPK other = (OrderDetailPK) obj;
		if (orderID != other.orderID)
			return false;
		if (productID != other.productID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "com.northwindx.model.jpa.OrderDetailsPK[orderID="
				+ orderID + ", productID=" + productID + "]";
	}
	
}
