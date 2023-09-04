package com.apicomsqlite.aula003.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apicomsqlite.aula003.enity.Aluno;

@Repository
public interface AlunoRespository extends JpaRepository<Aluno, Integer> {

    public boolean existsByEmail(String email);

    public List<Aluno> findByEmail(String email);

    @Query("select max(s.id) from Aluno s")
    public Integer findMaxId();
}