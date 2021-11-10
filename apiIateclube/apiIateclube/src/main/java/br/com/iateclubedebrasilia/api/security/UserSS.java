package br.com.iateclubedebrasilia.api.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.iateclubedebrasilia.api.entitys.Grupo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class UserSS implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String email;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS() {
    }

    public UserSS(Integer id, String email, String senha, Collection<Grupo> grupos) {
        super();
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.authorities = grupos.stream().map(x ->
                new SimpleGrantedAuthority(x.getGrpDescricao())).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
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

    public boolean hasRole(Grupo perfil) {
        return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getGrpDescricao()));
    }
}
