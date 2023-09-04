package com.apicomsqlite.aula003.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicomsqlite.aula003.enity.Professor;
import com.apicomsqlite.aula003.repository.ProfessorRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfessorService {
    
    @Autowired()
    private ProfessorRepository professorRepository;

    @Transactional()
    public String createProfessor(Professor professor) {
        professorRepository.save(professor);
        return "Usuario salvo com sucesso";
    } 

    @Transactional()
    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    @Transactional()
    public void deleteProfessor() {
        professorRepository.deleteAll();
    }

    @Transactional()
    public void updateProfessor(Professor professor) {
        Professor professorUpdate = professorRepository.getReferenceById(professor.getId());
        professorUpdate.setEmail(professor.getEmail());
        professorUpdate.setMateria(professor.getMateria());
        professorUpdate.setNome(professor.getNome());
        professorUpdate.setSobrenome(professor.getSobrenome());
        professorUpdate.setTelefone(professor.getTelefone());
        professorRepository.save(professorUpdate);
    }
}
