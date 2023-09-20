package br.com.fiap.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_USER", uniqueConstraints = {
        @UniqueConstraint(name = "UK_USER_EMAIL", columnNames = "USER_EMAIL")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USER")
    private Long id;

    @Email
    @Column(name = "USER_EMAIL", nullable = false)
    private String username;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "PESSOA", referencedColumnName = "ID_PESSOA", foreignKey = @ForeignKey(name = "FK_USER_PESSOA"))
    private Pessoa pessoa;

    @ElementCollection(targetClass = Authority.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(name = "authority")
    private Set<Authority> authorities = new LinkedHashSet<>();


    public Usuario() {
    }

    public Usuario(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public Usuario(Long id, String username, String password, Pessoa pessoa, Set<Authority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.pessoa = pessoa;
        this.authorities = Objects.nonNull( authorities ) ? authorities : new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Usuario setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Usuario setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Usuario setPassword(String password) {
        this.password = password;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Usuario setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Usuario setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
        return this;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pessoa=" + pessoa +
                ", authorities=" + authorities +
                '}';
    }
}
