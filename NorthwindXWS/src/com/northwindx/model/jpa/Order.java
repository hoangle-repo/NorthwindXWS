package com.northwindx.model.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "OrderID")
	private int orderID;
	@Column(name = "CustomerID", insertable = false, updatable = false)
	private String customerID;
	@Column(name = "EmployeeID", insertable = false, updatable = false)
	private Integer employeeID;
	@Column(name = "OrderDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	@Column(name = "RequiredDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requiredDate;
	@Column(name = "ShippedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date shippedDate;
	@Column(name = "ShipVia")
	private Integer shipVia;
	@Column(name = "Freight")
	private BigDecimal freight;
	@Column(name = "ShipName")
	private String shipName;
	@Column(name = "ShipAddress")
	private String shipAddress;
	@Column(name = "ShipCity")
	private String shipCity;
	@Column(name = "ShipRegion")
	private String shipRegion;
	@Column(name = "ShipPostalCode")
	private String shipPostalCode;
	@Column(name = "ShipCountry")
	private String shipCountry;
	@JoinColumn(name = "CustomerID")
	@ManyToOne
	private Customer customer;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private Collection<OrderDetail> orderDetails;
	@JoinColumn(name = "EmployeeID")
	@ManyToOne
	private Employee employee;
	
	public Order() { }
	
	public Order(Integer orderID) {
		this.orderID = orderID;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}
	public Date getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}
	public Integer getShipVia() {
		return shipVia;
	}
	public void setShipVia(Integer shipVia) {
		this.shipVia = shipVia;
	}
	public BigDecimal getFreight() {
		return freight;
	}
	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public String getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}
	public String getShipCity() {
		return shipCity;
	}
	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}
	public String getShipRegion() {
		return shipRegion;
	}
	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}
	public String getShipPostalCode() {
		return shipPostalCode;
	}
	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}
	public String getShipCountry() {
		return shipCountry;
	}
	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + orderID;
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
		Order other = (Order) obj;
		if (orderID != other.orderID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "com.northwindx.model.jpa.Orders[orderID=" + orderID 
				+ "]";
	}
}
