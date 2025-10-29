package com.example.Biblioteca.Controller;

import com.example.Biblioteca.Model.Livro;
import com.example.Biblioteca.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.createLivro(livro);
        return ResponseEntity.ok(novoLivro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findLivro(@PathVariable Long id) {
        return livroService.findLivro(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @RequestBody Livro novoLivro) {
        try {
            Livro livroAtualizado = livroService.updateLivro(id, novoLivro);
            return ResponseEntity.ok(livroAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroService.deleteLivro(id);
        return ResponseEntity.noContent().build();
    }
}