package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.Aluno;
import com.apicomsqlite.aula003.service.AlunoService;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info() {
        return "Aplicacao ativa";
    }

    @RequestMapping(value = "createaluno", method = RequestMethod.POST)
    public String createaluno(@RequestBody Aluno aluno) {
        return alunoService.createaluno(aluno);
    }

    @RequestMapping(value = "readalunos", method = RequestMethod.GET)
    public List<Aluno> readalunos() {
        return alunoService.readalunos();
    }

    @RequestMapping(value = "updatealuno", method = RequestMethod.PUT)
    public String updatealuno(@RequestBody Aluno aluno) {
        return alunoService.updatealuno(aluno);
    }

    @RequestMapping(value = "deletealuno", method = RequestMethod.DELETE)
    public String deletealuno(@RequestBody Aluno aluno) {
        return alunoService.deletealuno(aluno);
    }
}
