package br.com.fiap.domain.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AUTHOR")
    @Column(name = "ID_AUTHOR")
    private Long id;

    @Column(name = "NM_AUTHOR")
    private String name;

    public Author() {
    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Author setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
