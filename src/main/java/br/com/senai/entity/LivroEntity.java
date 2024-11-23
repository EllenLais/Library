package br.com.senai.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "livros")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeLivro;

    private String autor;

    private String genero;

    private String editora;

    private int anoPublicacao;
}
