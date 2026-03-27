package net.anas.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.anas.accountservice.enums.AcountType;
import net.anas.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @Builder
public class BankAcount {
    @Id
    private String accountId;
    private Double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AcountType acountType;
    @Transient // pour ignorer cette attribue, il n'a pas representer au niveau de la BDD (ne préciser pas le type de relation)
    private Customer customer;
    private Long customerId;
}
