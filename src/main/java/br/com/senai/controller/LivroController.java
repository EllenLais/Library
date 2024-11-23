package br.com.senai.controller;

import br.com.senai.entity.LivroEntity;
import br.com.senai.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;


    @GetMapping("/listar")
    public List<LivroEntity> listarLivros(){
        return livroService.listarLivros();
    }


    @PostMapping
    public LivroEntity cadastrarLivro(@RequestBody LivroEntity livro){
        return livroService.cadastrarLivro(livro);
    }


    @GetMapping("/{idLivro}")
    public LivroEntity buscarLivroPorId(@PathVariable Long idLivro){
        return livroService.buscarLivroPorId(idLivro);
    }


    @GetMapping("/nome/{nomeLivro}")
    public List<LivroEntity> buscarLivroPorNome(@PathVariable String nomeLivro){
        return livroService.buscarLivroPorNome(nomeLivro);
    }


    @PutMapping("/editar/{idLivro}")
    public LivroEntity editarLivro(@PathVariable Long idLivro, @RequestBody LivroEntity livro){
        return livroService.editarLivro(idLivro, livro);
    }


    @DeleteMapping("/{idLivro}")
    public void excluirLivro(@PathVariable Long idLivro){
        livroService.excluirLivro(idLivro);
    }
}
