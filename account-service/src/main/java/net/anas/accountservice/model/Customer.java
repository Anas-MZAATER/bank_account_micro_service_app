package net.anas.accountservice.model;

import lombok.*;

@Getter @Setter @ToString
public class Customer {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
