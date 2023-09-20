package br.com.fiap.domain.dto;

import br.com.fiap.domain.entity.Authority;
import br.com.fiap.domain.entity.Pessoa;
import br.com.fiap.domain.entity.Usuario;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UsuarioDTO(Long id, @NotNull String username, Pessoa pessoa, String password, String authorization, Set<Authority> authorities) {

    public static UsuarioDTO of(Usuario p, String key) {
        return new UsuarioDTO( p.getId(), p.getUsername(), p.getPessoa(), "", key , p.getAuthorities());
    }

    public static UsuarioDTO of(Usuario p) {
        return new UsuarioDTO( p.getId(), p.getUsername(), p.getPessoa(), "", "", p.getAuthorities() );
    }

    public static Usuario of(UsuarioDTO b) {
        return new Usuario( b.id, b.username, b.password );
    }
}
