package net.anas.accountservice;

import net.anas.accountservice.clients.CustomerRestClient;
import net.anas.accountservice.entities.BankAcount;
import net.anas.accountservice.enums.AcountType;
import net.anas.accountservice.repository.BankAccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepo bankAccountRepo){
        return args -> {
            BankAcount bankAcount1 = BankAcount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balence(Double.valueOf(99000))
                    .createdAt(LocalDate.now())
                    .acountType(AcountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(1))
                    .build();
            BankAcount bankAcount2 = BankAcount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .currency("MAD")
                    .balence(Double.valueOf(55001))
                    .createdAt(LocalDate.now())
                    .acountType(AcountType.CURRENT_ACCOUNT)
                    .customerId(Long.valueOf(2))
                    .build();

            List<BankAcount> bankAccountList = List.of(bankAcount1, bankAcount2);
            bankAccountRepo.saveAll(bankAccountList);
        };
    }

}
