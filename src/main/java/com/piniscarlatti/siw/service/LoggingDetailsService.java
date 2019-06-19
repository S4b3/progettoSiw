package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Funzionario;
import com.piniscarlatti.siw.entity.Utente;
import com.piniscarlatti.siw.repository.FunzionarioRepository;
import com.piniscarlatti.siw.repository.UtenteRepository;
import com.piniscarlatti.siw.security.FunzionarioDetails;
import com.piniscarlatti.siw.security.UtenteDetails;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoggingDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger("logger");

    private FunzionarioRepository funzionarioRepository;
    private UtenteRepository utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Funzionario funzionario = funzionarioRepository.findByUsername(username);

        logger.info("Cerco username = " + username);

        if (funzionario == null){
            logger.info("Non ho trovato funzionari, cerco utenti" );
            Utente utente = utenteRepository.findByUsername(username);
            logger.info("Ho trovato l'utente? "+ utente.getUsername());

            if(utente == null){
                logger.info("Non ho trovato utenti, muoio");
                throw new UsernameNotFoundException("Bad Username!");
            }
            logger.info("Ho trovato l'utente : " + utente.toString());
            UtenteDetails utenteDetails = new UtenteDetails(utente);
            return utenteDetails;

        }
        logger.info("Ho trovato er funzionario : " + funzionario.toString());
        FunzionarioDetails funzionarioDetails = new FunzionarioDetails(funzionario);
        return funzionarioDetails;
    }

}

