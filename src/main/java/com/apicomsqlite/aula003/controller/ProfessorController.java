package com.apicomsqlite.aula003.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicomsqlite.aula003.enity.Professor;
import com.apicomsqlite.aula003.service.ProfessorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController()
public class ProfessorController {

  @Autowired
  ProfessorService professorService;

  @PostMapping(value = "professor")
  public String createProfessor(@RequestBody Professor body) {
    professorService.createProfessor(body);
    return "Cadastrado com sucesso!";
  }

  @GetMapping(value="professor")
  public List<Professor> getAllProfessores() {
    return professorService.getAllProfessores();
  }

  @PutMapping(value = "professor")
  public String updateProfessor(@RequestBody Professor body) {
    professorService.updateProfessor(body);
    return "Professor atualizado com sucesso!";
  }

  @DeleteMapping(value = "professor")
  public String deleteProfessor() {
    professorService.deleteProfessor();
    return "Todos os professores deletados com sucesso!";
  }
}