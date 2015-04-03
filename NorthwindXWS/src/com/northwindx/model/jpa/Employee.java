package com.northwindx.model.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employees")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "EmployeeID")
	private int employeeID;
	@Basic(optional = false)
	@Column(name = "LastName")
	private String lastName;
	@Basic(optional = false)
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "Title")
	private String title;
	@Column(name = "TitleOfCourtesy")
	private String titleOfCourtesy;
	@Column(name = "BirthDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;
	@Column(name = "HireDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date hireDate;
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
	@Column(name = "HomePhone")
	private String homePhone;
	@Column(name = "Extension")
	private String extension;
	@Lob
	@Column(name = "Photo")
	private byte[] photo;
	@Lob
	@Column(name = "Notes")
	private String notes;
	@Column(name = "ReportsTo")
	private Integer reportsTo;
	@Column(name = "PhotoPath")
	private String photoPath;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	private Collection<Order> order;
	
	public Employee() { }
	
	public Employee(Integer employeeID) {
		this.employeeID = employeeID;
	}
	
	public Employee(Integer employeeID, String lastName, String firstName) {
		this.employeeID = employeeID;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitleOfCourtesy() {
		return titleOfCourtesy;
	}
	public void setTitleOfCourtesy(String titleOfCourtesy) {
		this.titleOfCourtesy = titleOfCourtesy;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
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
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Integer getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(Integer reportsTo) {
		this.reportsTo = reportsTo;
	}
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	public Collection<Order> getOrder() {
		return order;
	}
	public void setOrder(Collection<Order> order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
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
		Employee other = (Employee) obj;
		if (employeeID != other.employeeID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "com.northwindx.model.jpa.Employees[employeeID="
			+ employeeID + "]";
	}
}
