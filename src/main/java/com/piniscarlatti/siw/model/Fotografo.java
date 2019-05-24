package com.piniscarlatti.siw.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
public class Fotografo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private Set<Album> album;
    private String username;
    private String password;
}
