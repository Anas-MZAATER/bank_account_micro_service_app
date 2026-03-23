package net.anas.customerservice.web;


import net.anas.customerservice.entities.Customer;
import net.anas.customerservice.repository.CustomerRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {

    private CustomerRepo customerRepo;

    public CustomerRestController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/customers")
    public List<Customer> customerList() {
        return customerRepo.findAll();
    }
    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id) {
        return customerRepo.findById(id).get();
    }
}
