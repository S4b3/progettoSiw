package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class FunzionarioService implements UserDetailsService {

    @Autowired
    private FunzionarioRepository funzionarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Funzionario funzionario = funzionarioRepository.findFunzionarioByUsername(username);
        if (funzionario == null){
            throw new UsernameNotFoundException("Bad Username!");

        }
        return new org.springframework.security.core.userdetails.User(
                username
                , funzionario.getPassword()
                , Collections.singleton(new SimpleGrantedAuthority("funzionario")));
    }

}

