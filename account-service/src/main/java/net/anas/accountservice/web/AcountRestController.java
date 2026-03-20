package net.anas.accountservice.web;

import lombok.AllArgsConstructor;
import net.anas.accountservice.entities.BankAcount;
import net.anas.accountservice.repository.BankAccountRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AcountRestController {
    private BankAccountRepo bankAccountRepo;
    public AcountRestController(BankAccountRepo bankAccountRepo) {
        this.bankAccountRepo = bankAccountRepo;
    }

    @GetMapping("/accounts")
    public List<BankAcount> bankAccountList() {
        return bankAccountRepo.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAcount bankAccountById(String id) {
        return bankAccountRepo.findById(id).get();
    }
}
