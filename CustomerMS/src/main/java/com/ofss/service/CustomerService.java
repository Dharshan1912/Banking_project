package com.ofss.service;

import com.ofss.model.Customer;
import com.ofss.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Register new customer with uniqueness checks
    public ResponseEntity<?> registerCustomer(Customer customer) {
        try {
            if (customerRepository.emailExists(customer.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Email already exists");
            }
            if (customerRepository.phoneExists(customer.getPhone())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Phone already exists");
            }
            if (customerRepository.panExists(customer.getPan())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("PAN already exists");
            }
            if (customerRepository.aadhaarExists(customer.getAadhaar())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Aadhaar already exists");
            }

            Customer savedCustomer = customerRepository.save(customer);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Customer registered successfully! Customer ID: " + savedCustomer.getCustomerId());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while registering customer: " + e.getMessage());
        }
    }

    // Get all customers
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = customerRepository.findAll();
            return ResponseEntity.ok(customers);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    // Get customer by ID
    public ResponseEntity<?> getCustomerById(Long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);

            if (customer.isPresent()) {
                // Customer exists
                return ResponseEntity.ok(customer.get());
            } else {
                // Customer not found
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Customer not found");
            }

        } catch (Exception e) {
            // Any unexpected error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something went wrong");
        }
    }

    
    
    public ResponseEntity<?> updateCustomer(Long id, Customer updatedCustomer) {
        try {
            Optional<Customer> optionalCustomer = customerRepository.findById(id);
            if (optionalCustomer.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
            }
            Customer existing = optionalCustomer.get();
            // Update only provided fields
            if (updatedCustomer.getFullName() != null) existing.setFullName(updatedCustomer.getFullName());
            if (updatedCustomer.getEmail() != null) existing.setEmail(updatedCustomer.getEmail());
            if (updatedCustomer.getPhone() != null) existing.setPhone(updatedCustomer.getPhone());
            if (updatedCustomer.getDob() != null) existing.setDob(updatedCustomer.getDob());
            if (updatedCustomer.getAddress() != null) existing.setAddress(updatedCustomer.getAddress());
            if (updatedCustomer.getPan() != null) existing.setPan(updatedCustomer.getPan());
            if (updatedCustomer.getAadhaar() != null) existing.setAadhaar(updatedCustomer.getAadhaar());
            customerRepository.save(existing);
            return ResponseEntity.ok("Customer updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while updating customer: " + e.getMessage());
        }
    }
    // :small_blue_diamond: DELETE: Remove customer by ID
    public ResponseEntity<?> deleteCustomer(Long id) {
        try {
            if (!customerRepository.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
            }
            customerRepository.deleteById(id);
            return ResponseEntity.ok("Customer deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while deleting customer: " + e.getMessage());
        }
    }
}









