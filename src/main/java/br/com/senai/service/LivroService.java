package br.com.senai.service;

import br.com.senai.entity.LivroEntity;
import br.com.senai.exception.LivroException;
import br.com.senai.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // Cadastrar livro
    public LivroEntity cadastrarLivro(LivroEntity livro) {
        return livroRepository.save(livro);
    }


    public List<LivroEntity> listarLivros() {
        return livroRepository.findAll();
    }


    public LivroEntity editarLivro(Long idLivro, LivroEntity livro) {
        LivroEntity livroOld = livroRepository.findById(idLivro).orElseThrow(() ->
                new LivroException("Livro não encontrado!!"));

        livroOld.setNomeLivro(livro.getNomeLivro());
        livroOld.setAutor(livro.getAutor());
        livroOld.setGenero(livro.getGenero());
        livroOld.setEditora(livro.getEditora());
        livroOld.setAnoPublicacao(livro.getAnoPublicacao());

        return livroRepository.save(livroOld);
    }


    public LivroEntity buscarLivroPorId(Long idLivro) {
        return livroRepository.findById(idLivro).orElseThrow(() ->
                new LivroException("Cadastro de livro não encontrado!!"));
    }


    public List<LivroEntity> buscarLivroPorNome(String nomeLivro) {
        return livroRepository.buscarLivroPorNome(nomeLivro);
    }


    public void excluirLivro(Long idLivro) {
        livroRepository.deleteById(idLivro);
    }
}
