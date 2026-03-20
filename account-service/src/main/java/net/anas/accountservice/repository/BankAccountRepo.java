package net.anas.accountservice.repository;

import net.anas.accountservice.entities.BankAcount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAcount, String> {

}
