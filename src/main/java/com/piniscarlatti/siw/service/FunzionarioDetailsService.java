package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import com.piniscarlatti.siw.security.FunzionarioDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FunzionarioDetailsService implements UserDetailsService {

    @Autowired
    private FunzionarioRepository funzionarioRepository;

    public FunzionarioDetailsService(FunzionarioRepository funzionarioRepository){
        this.funzionarioRepository = funzionarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Funzionario funzionario = funzionarioRepository.findByUsername(username);
        if (funzionario == null){
            throw new UsernameNotFoundException("Bad Username!");

        }
        FunzionarioDetails funzionarioDetails = new FunzionarioDetails(funzionario);
        return funzionarioDetails;
    }

}

