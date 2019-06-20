package com.piniscarlatti.siw.repository;

import com.piniscarlatti.siw.entity.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarrelloRepository extends JpaRepository<Carrello, Long> {

}
