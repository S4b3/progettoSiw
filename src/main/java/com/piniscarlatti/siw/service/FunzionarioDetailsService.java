package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import com.piniscarlatti.siw.security.FunzionarioDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FunzionarioDetailsService implements UserDetailsService {

    private FunzionarioRepository funzionarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(funzionarioRepository.existsByUsername(username)){
            Funzionario funzionario = funzionarioRepository.findByUsername(username);
            FunzionarioDetails funzionarioDetails = new FunzionarioDetails(funzionario);
            return funzionarioDetails;
        }
        throw new UsernameNotFoundException("Bad Username!");
    }

}

