package com.omnicuris.ecommerce.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "email_id")
    @NotBlank
    private String emailId;
    @Column(name = "user_name")
    private String userName;
}