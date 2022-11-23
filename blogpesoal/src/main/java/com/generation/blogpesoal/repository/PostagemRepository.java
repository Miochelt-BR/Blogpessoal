package com.generation.blogpesoal.repository;

import com.generation.blogpesoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long> {

}
