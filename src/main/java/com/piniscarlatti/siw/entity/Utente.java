package com.piniscarlatti.siw.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
}
