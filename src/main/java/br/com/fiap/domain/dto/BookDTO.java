package br.com.fiap.domain.dto;

import br.com.fiap.domain.entity.Book;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record BookDTO(Long id, String name, String isbn, LocalDateTime launch, Set<AuthorDTO> writers) {

    public static BookDTO of(Book p) {
        return new BookDTO( p.getId(), p.getName(), p.getISBN(), p.getLaunch(), p.getWriters().stream().map( AuthorDTO::of ).collect( Collectors.toSet() ) );
    }

    public static Book of(BookDTO b) {

        return new Book( b.id, b.name, b.isbn, b.launch, b.writers.stream().map( AuthorDTO::of ).collect( Collectors.toSet() ) );
    }

}
