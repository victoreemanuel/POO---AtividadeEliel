package com.example.Biblioteca.Service;

import com.example.Biblioteca.Model.Livro;
import com.example.Biblioteca.Repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro createLivro (Livro livro){
        return livroRepository.save(livro);
    }

    public Optional<Livro> findLivro (Long id) {
        return livroRepository.findById(id);
    }

    public void deleteLivro (Long id) {
        livroRepository.deleteById(id);
    }

    @Transactional
    public Livro updateLivro(Long id, Livro novoLivro) {
        return livroRepository.findById(id).map(livro -> {
            livro.setNome(novoLivro.getNome());
            livro.setStatus(novoLivro.getStatus());
            return livroRepository.save(livro);
        }).orElseThrow(() -> new RuntimeException("Livro não encontrado com o id: " + id));
    }

}
