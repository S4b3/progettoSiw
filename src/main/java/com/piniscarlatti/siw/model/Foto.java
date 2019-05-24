package com.piniscarlatti.siw.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    private String nome;
    private String categoria;
    private Fotografo fotografo;
}
