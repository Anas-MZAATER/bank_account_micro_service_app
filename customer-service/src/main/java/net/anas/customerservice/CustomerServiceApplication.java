package net.anas.customerservice;

import net.anas.customerservice.config.GlobalConfig;
import net.anas.customerservice.entities.Customer;
import net.anas.customerservice.repository.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepo customerRepo){
        return args -> {
            Customer c1 = Customer.builder()
                    .firstname("anas")
                    .lastName("mzaater")
                    .email("anasmz@gmail.com")
                    .build();
            //customerRepo.save(c1);
            List<Customer> customerList = List.of(
                    c1,
                    Customer.builder()
                            .firstname("ahmed")
                            .lastName("rami")
                            .email("ahmed123@gmail.com")
                            .build()
                    );
            customerRepo.saveAll(customerList);
        };
    }
}
