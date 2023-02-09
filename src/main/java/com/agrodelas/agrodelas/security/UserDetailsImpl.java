package com.agrodelas.agrodelas.security;

import com.agrodelas.agrodelas.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    //-------------------------Verifica se usuario e senha estão presentes no banco de dados------------------------------

    private String userName;
    private String password;

    private List<GrantedAuthority> authorities;

    public UserDetailsImpl(Usuario usuario) {
        this.userName = usuario.getEmail();
        this.password = usuario.getSenha();
    }

    public UserDetailsImpl(){}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
