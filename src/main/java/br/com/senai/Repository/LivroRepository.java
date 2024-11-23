package br.com.senai.repository;

import br.com.senai.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository <LivroEntity, Long> {

    @Query("select l from LivroEntity l where l.nomeLivro = ?1")
    List<LivroEntity> buscarLivroPorNome(String nomeLivro);
}
