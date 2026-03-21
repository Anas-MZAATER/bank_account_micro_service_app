package net.anas.accountservice.web;

import lombok.AllArgsConstructor;
import net.anas.accountservice.clients.CustomerRestClient;
import net.anas.accountservice.entities.BankAcount;
import net.anas.accountservice.model.Customer;
import net.anas.accountservice.repository.BankAccountRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepo bankAccountRepo;
    private CustomerRestClient customerRestClient;
    public AccountRestController(BankAccountRepo bankAccountRepo,
                                 CustomerRestClient customerRestClient) {
        this.bankAccountRepo = bankAccountRepo;
        this.customerRestClient = customerRestClient;
    }


    @GetMapping("/accounts")
    public List<BankAcount> bankAccountList() {
        return bankAccountRepo.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAcount bankAccountById(@PathVariable String id) {
        BankAcount bankAcount= bankAccountRepo.findById(id).get();
        Customer customer = customerRestClient.getCustomerById(bankAcount.getCustomerId());
        bankAcount.setCustomer(customer);
        return bankAcount;
    }
}
