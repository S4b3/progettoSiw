package com.piniscarlatti.siw.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
public class Fotografo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "fotografo")
    private Set<Album> album;

    protected Fotografo(){}

    private Fotografo (String username, String password){
        this.username=username;
        this.password=password;
    }


}
