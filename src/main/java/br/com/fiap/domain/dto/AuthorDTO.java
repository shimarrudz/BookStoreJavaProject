package br.com.fiap.domain.dto;

import br.com.fiap.domain.entity.Author;
import jakarta.validation.Valid;

public record AuthorDTO(Long id, @Valid PessoaFisicaDTO pessoa) {

    public static AuthorDTO of(Author p) {
        return new AuthorDTO( p.getId(), PessoaFisicaDTO.of( p.getPessoa() ) );
    }

    public static Author of(AuthorDTO p) {
        return new Author( p.id, PessoaFisicaDTO.of( p.pessoa ) );
    }

}
