package com.piniscarlatti.siw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
public class Funzionario {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role;

    public Funzionario(){ }

    public Funzionario(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = "FUNZIONARIO";
    }

    public Funzionario(String username, String password, String ruolo){
        this.username = username;
        this.password = password;
        this.role = ruolo;
    }

}
