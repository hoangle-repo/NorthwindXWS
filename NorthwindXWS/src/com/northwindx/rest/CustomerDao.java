package com.northwindx.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jettison.json.JSONObject;

import com.northwindx.model.jpa.Customer;
import com.northwindx.util.Constants;
import com.northwindx.util.PersistenceUtil;

@Path("/customers")
public class CustomerDao {

	/*
	 * Method retrieve customer in Contact Name order Request type: GET Path:
	 * rest/customers/{id}
	 */
	@Path("{id}")
	@GET
	@Produces("application/json;charset=utf8")
	public Customer getCustomerById(@PathParam("id") int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Customer customer = new Customer();
		em.getTransaction().begin();

		@SuppressWarnings("unchecked")
		List<Customer> customerlist = em.createQuery(
				"from Customer c order by c.contactName ASC").getResultList();
		em.getTransaction().commit();

		if (customerlist.size() > id) {
			customer = customerlist.get(id);
		}

		return customer;
	}

	/*
	 * Method retrieve customer by customer ID Request type: GET Path:
	 * rest/customers/customerID/{id}
	 */
	@Path("/customerID/{customerId}")
	@GET
	@Produces("application/json;charset=utf8")
	public Customer getCustomerByCustomerID(
			@PathParam("customerId") String customerId) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Customer customer = new Customer();
		em.getTransaction().begin();
		customer = em.find(Customer.class, customerId);
		em.getTransaction().commit();
		return customer;
	}

	/*
	 * Method retrieve the list of all customers in database Request type: GET
	 * Path: rest/customers/search
	 */
	@Path("/search")
	@GET
	@Produces("application/json;charset=utf8")
	public List<Customer> searchCustomer() {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Customer> customerList = em.createQuery("from Customer c order by c.contactName")
				.getResultList();
		em.getTransaction().commit();
		return customerList;
	}

	/*
	 * Method retrieve the list of customer found by contact name and company
	 * name Request type: GET Path: rest/customers/search/{key}
	 */
	@Path("/search/{key}")
	@GET
	@Produces("application/json;charset=utf8")
	public List<Customer> searchCustomer(@PathParam("key") String key) {
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Customer> customerList = em.createQuery(
				"from Customer c where c.contactName like \'%" + key
						+ "%\' or c.companyName like \'%" + key + "%\' order by c.contactName")
				.getResultList();
		em.getTransaction().commit();

		return customerList;
	}

	/*
	 * Method to add a new customer into database Return a message string to
	 * display on customer screen Request type: POST Path: rest/customers/add
	 */
	@Path("/add")
	@POST
	public String addCustomer(String customerString) {
		String returnString = "Customer created";

		// Parse json string customerString to HashMap
		Map<String, String> customer = null;
		try {
			customer = new ObjectMapper().readValue(customerString, TypeFactory
					.mapType(HashMap.class, String.class, String.class));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create new customer
		Customer tempCustomer = new Customer();
		tempCustomer.setCustomerID(customer.get("customerID").toUpperCase());
		tempCustomer.setCompanyName(customer.get("companyName"));
		tempCustomer.setContactName(customer.get("contactName"));
		tempCustomer.setContactTitle(customer.get("contactTitle"));
		tempCustomer.setEmail(customer.get("email"));
		tempCustomer.setPassword(Constants.createMD5("password"));
		tempCustomer.setAddress(customer.get("address"));
		tempCustomer.setCity(customer.get("city"));
		tempCustomer.setRegion(customer.get("region"));
		tempCustomer.setPostalCode(customer.get("postalCode"));
		tempCustomer.setCountry(customer.get("country"));
		tempCustomer.setPhone(customer.get("phone"));
		tempCustomer.setFax(customer.get("fax"));
		tempCustomer.setRole("USER");

		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();

		// Add into database if customerID is not already exist
		if (em.find(Customer.class, customer.get("customerID")) == null) {
			em.persist(tempCustomer);
		} else {
			returnString = "Customer Already Existed";
		}

		em.getTransaction().commit();

		return returnString;
	}

	/*
	 * Method update a customer in database Request type: POST Path:
	 * rest/customers/update/{id}
	 */
	@Path("/update/{id}")
	@POST
	public void updateCustomer(@PathParam("id") String customerId,
			String customerString) {
		Map<String, String> customer = null;
		try {
			customer = new ObjectMapper().readValue(customerString, TypeFactory
					.mapType(HashMap.class, String.class, String.class));
		} catch (IOException e) {
			e.printStackTrace();
		}

		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		Customer tempCustomer = em.find(Customer.class, customerId);
		tempCustomer.setCustomerID(customerId);
		tempCustomer.setCompanyName(customer.get("companyName"));
		tempCustomer.setContactName(customer.get("contactName"));
		tempCustomer.setContactTitle(customer.get("contactTitle"));
		tempCustomer.setEmail(customer.get("email"));
		tempCustomer.setPassword(Constants.createMD5("password"));
		tempCustomer.setAddress(customer.get("address"));
		tempCustomer.setCity(customer.get("city"));
		tempCustomer.setRegion(customer.get("region"));
		tempCustomer.setPostalCode(customer.get("postalCode"));
		tempCustomer.setCountry(customer.get("country"));
		tempCustomer.setPhone(customer.get("phone"));
		tempCustomer.setFax(customer.get("fax"));
		tempCustomer.setRole("USER");
		em.persist(tempCustomer);
		em.getTransaction().commit();

	}

	/*
	 * Method remove a customer from database Request type: POST Path:
	 * rest/customers/delete/{customerID}
	 */
	@POST
	@Path("/delete/{customerId}")
	public void removeCustomer(@PathParam("customerId") String customerId,
			String confirm) {
		if (confirm.equals("DELETECUSTOMER")) {
			EntityManager em = PersistenceUtil.getEntityManager();
			em.getTransaction().begin();
			Customer customer = em.find(Customer.class, customerId);
			if (customer != null) {
				em.remove(customer);
			}
			em.getTransaction().commit();
		}
		System.out.println(confirm);
	}
}
