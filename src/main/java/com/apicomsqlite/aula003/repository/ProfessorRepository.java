package com.apicomsqlite.aula003.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.apicomsqlite.aula003.enity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    public List<Professor> findAll();
}