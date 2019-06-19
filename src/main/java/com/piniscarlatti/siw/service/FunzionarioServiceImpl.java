package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import com.piniscarlatti.siw.security.FunzionarioDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Override
    public Funzionario funzionarioCorrente() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long idFunzionario = ((FunzionarioDetails)principal).getId();
        Funzionario funz = this.perId(idFunzionario);
        return funz;
    }


}
