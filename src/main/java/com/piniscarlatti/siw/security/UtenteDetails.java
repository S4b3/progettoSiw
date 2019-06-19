package com.piniscarlatti.siw.security;

import com.piniscarlatti.siw.entity.Utente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UtenteDetails implements UserDetails {
    private Utente utente;

    public UtenteDetails(Utente utente){
        this.utente = utente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority auth = new SimpleGrantedAuthority(this.utente.getRole());
        authorities.add(auth);
        GrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + this.utente.getRole());
        authorities.add(role);
        return authorities;
    }

    @Override
    public String getPassword(){
        return this.utente.getPassword();
    }

    @Override
    public String getUsername() {
        return this.utente.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
