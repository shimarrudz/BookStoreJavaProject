package br.com.fiap.domain.dto;

import br.com.fiap.domain.entity.PessoaFisica;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record PessoaFisicaDTO(
        Long id,
        @NotNull String nome,
        @PastOrPresent LocalDate nascimento,
        @NotNull String cpf
) {
    public static PessoaFisicaDTO of(PessoaFisica p) {
        return new PessoaFisicaDTO( p.getId(), p.getNome(), p.getNascimento(), p.getCpf() );
    }

    public static PessoaFisica of(PessoaFisicaDTO p) {
        return new PessoaFisica( p.id, p.nome, p.nascimento, p.cpf );
    }
}
