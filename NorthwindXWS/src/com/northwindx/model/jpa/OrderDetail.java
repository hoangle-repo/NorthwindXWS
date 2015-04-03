package com.northwindx.model.jpa;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	protected OrderDetailPK orderDetailsPK;
	@Basic(optional = false)
	@Column(name = "UnitPrice")
	private BigDecimal unitPrice;
	@Basic(optional = false)
	@Column(name = "Quantity")
	private short quantity;
	@Basic(optional = false)
	@Column(name = "Discount")
	private float discount;
	
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Product product;
	
	@JoinColumn(name = "OrderID", referencedColumnName = "OrderID", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Order order;
	
	public OrderDetail() { }
	
	public OrderDetail(OrderDetailPK orderDetailsPK) {
		this.orderDetailsPK = orderDetailsPK;
	}
	
	public OrderDetail(OrderDetailPK orderDetailsPK, BigDecimal unitPrice, short quantity, Float discount) {
		this.orderDetailsPK = orderDetailsPK;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
	}
	
	public OrderDetail(int orderID, int productID) {
		this.orderDetailsPK = new OrderDetailPK(orderID, productID);
	}

	public OrderDetailPK getOrderDetailsPK() {
		return orderDetailsPK;
	}
	public void setOrderDetailsPK(OrderDetailPK orderDetailsPK) {
		this.orderDetailsPK = orderDetailsPK;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public short getQuantity() {
		return quantity;
	}
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orderDetailsPK == null) ? 0 : orderDetailsPK.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
		if (orderDetailsPK == null) {
			if (other.orderDetailsPK != null)
				return false;
		} else if (!orderDetailsPK.equals(other.orderDetailsPK))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "com.northwindx.model.jpa.OrderDetails[orderDetailsPK="
				+ orderDetailsPK + "]";
	}
}
