package com.northwindx.model.jpa;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Basic(optional = false)
	@Column(name = "CustomerID")
	private String customerID;
	@Basic(optional = false)
	@Column(name = "CompanyName")
	private String companyName;
	@Column(name = "ContactName")
	private String contactName;
	@Column(name = "ContactTitle")
	private String contactTitle;
	@Column(name = "Email")
	private String email;
	@JsonIgnore
	@Column(name = "Password")
	private String password;
	@Column(name = "Address")
	private String address;
	@Column(name = "City")
	private String city;
	@Column(name = "Region")
	private String region;
	@Column(name = "PostalCode")
	private String postalCode;
	@Column(name = "Country")
	private String country;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "Fax")
	private String fax;
	@JsonIgnore
	@Column(name = "Role")
	private String role;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private Collection<Order> Orders;
	
	@JsonIgnore
	public Customer() { }
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTitle() {
		return contactTitle;
	}
	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonIgnore
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@JsonIgnore
	public Collection<Order> getOrders() {
		return Orders;
	}
	
	@JsonIgnore
	public void setOrders(Collection<Order> orders) {
		this.Orders = orders;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonIgnore
	public void setRole(String role) {
		this.role = role;
	}
	@JsonIgnore
	public String getRole() {
		return role;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerID == null) ? 0 : customerID.hashCode());
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
		Customer other = (Customer) obj;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		return true;
	}

	@JsonIgnore
	@Override
	public String toString() {
		return "com.northwindx.model.jpa.Customers[customerID=" + customerID + "]";
	}
}
