package com.piniscarlatti.siw.service;

import com.piniscarlatti.siw.entity.Funzionario;

public interface FunzionarioService {
    Funzionario perUsername(String username);
    Funzionario perId(Long id);
}
