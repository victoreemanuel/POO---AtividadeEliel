package com.example.Biblioteca.Repository;

import com.example.Biblioteca.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Long> {
}
