package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FunzionarioServiceImpl implements FunzionarioService {

    private FunzionarioRepository funzionarioRepository;

    @Override
    public Funzionario perUsername(String username) {
        return  funzionarioRepository.findByUsername(username);
    }

    @Override
    public Funzionario perId(Long id) {
        return funzionarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Fotografo Id:" + id));
    }
}
