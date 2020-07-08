package com.comulynx.wallet.rest.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comulynx.wallet.rest.api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerId(String customerId);

	// TODO : Implement the query and function below to delete a customer using
	// Customer Id

	@Query("DELETE * FROM Customer c WHERE c.customerId = customerId")
	int deleteCustomerByCustomerId(String customer_id);

	// TODO : Implement the query and function below to update customer firstName
	// using Customer Id

	@Query("UPDATE Customer SET  firstName = 'Adam' WHERE c.customerId = customerId")
	int updateCustomerByCustomerId(String firstName, String customer_id);

	// TODO : Implement the query and function below and to return all customers
	// whose Email contains 'gmail'
	@Query("SELECT * FROM Customer c WHERE c.email CONTAINS 'gmail'")
	List<Customer> findAllCustomersWhoseEmailContainsGmail(@Param("gmail") String email);
}
