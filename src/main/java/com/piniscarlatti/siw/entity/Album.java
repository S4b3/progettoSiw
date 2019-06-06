package com.piniscarlatti.siw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "album")
@Data
@EqualsAndHashCode
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "album")
    @MapKey(name = "id")
    private Map<Long, Foto> fotografie;
    @ManyToOne
    private Fotografo fotografo;

    public Album() {

    }

    public Album(String nome, Fotografo fotografo) {
        this.nome = nome;
        this.fotografo = fotografo;
        this.fotografie = new HashMap<>();

    }

    @Override
    public boolean equals(Object o) {
        Album that = (Album) o;
        if (this.nome.equals(that.getNome()) && this.fotografo.equals(that.getFotografo())) {
            return true;
        }
        return false;
    }
}
