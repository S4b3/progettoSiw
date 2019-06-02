package com.piniscarlatti.siw.security;

import com.piniscarlatti.siw.entity.Funzionario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FunzionarioDetails implements UserDetails {
    private Funzionario funzionario;

    public FunzionarioDetails(Funzionario funzionario){
        this.funzionario = funzionario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority auth = new SimpleGrantedAuthority(this.funzionario.getRole());
        authorities.add(auth);
        GrantedAuthority role = new SimpleGrantedAuthority("ROLE_" + this.funzionario.getRole());
        authorities.add(role);
        return authorities;
    }

    @Override
    public String getPassword(){
        return this.funzionario.getPassword();
    }

    @Override
    public String getUsername() {
        return this.funzionario.getUsername();
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
