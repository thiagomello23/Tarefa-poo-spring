package com.apicomsqlite.aula003.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.Aluno;
import com.apicomsqlite.aula003.repository.AlunoRespository;
import jakarta.transaction.Transactional;

@Service
public class AlunoService {

    @Autowired(required = false)
    private AlunoRespository alunoRespository;

    @Transactional
    public String createaluno(Aluno aluno) {
        try {
            if (!alunoRespository.existsByEmail(aluno.getEmail())) {
                aluno.setId(null == alunoRespository.findMaxId() ? 0 : alunoRespository.findMaxId() + 1);
                alunoRespository.save(aluno);
                return "aluno cadastrado com sucesso.";
            } else {
                return "aluno já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Aluno> readalunos() {
        return alunoRespository.findAll();
    }

    @Transactional
    public String updatealuno(Aluno aluno) {
        if (alunoRespository.existsByEmail(aluno.getEmail())) {
            try {
                List<Aluno> alunos = alunoRespository.findByEmail(aluno.getEmail());
                alunos.stream().forEach(s -> {
                    Aluno alunoToBeUpdate = alunoRespository.findById(s.getId()).get();
                    alunoToBeUpdate.setnome(aluno.getnome());
                    alunoToBeUpdate.setEmail(aluno.getEmail());
                    alunoRespository.save(alunoToBeUpdate);
                });
                return "aluno atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "aluno não existe no banco.";
        }
    }

    @Transactional
    public String deletealuno(Aluno aluno) {
        if (alunoRespository.existsByEmail(aluno.getEmail())) {
            try {
                List<Aluno> alunos = alunoRespository.findByEmail(aluno.getEmail());
                alunos.stream().forEach(s -> {
                    alunoRespository.delete(s);
                });
                return "aluno deletado.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "aluno n\u00E3o existe no banco.";
        }
    }
}