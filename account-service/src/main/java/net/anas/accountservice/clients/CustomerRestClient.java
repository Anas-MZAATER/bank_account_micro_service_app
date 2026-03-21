package net.anas.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.anas.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customer-service", fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable() Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customer-service", fallbackMethod = "getAllCustomers")
    List<Customer> getAllCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer defaultCustomer=new Customer();
        defaultCustomer.setId(id);
        defaultCustomer.setFirstname("not Available");
        defaultCustomer.setLastname("not Available");
        defaultCustomer.setEmail("not Available");
        return defaultCustomer;
    }
    // returner une liste vide
    default List<Customer> getAllCustomers(Exception exception){
        return List.of();
    }

}
