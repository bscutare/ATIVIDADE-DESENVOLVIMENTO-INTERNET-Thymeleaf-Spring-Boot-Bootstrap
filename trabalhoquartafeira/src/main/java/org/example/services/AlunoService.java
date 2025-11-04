package org.example.services;


import org.example.models.Aluno;
import org.example.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class AlunoService {


    @Autowired
    private AlunoRepository alunoRepository;


    public Aluno add(Aluno aluno) {
        return alunoRepository.save(aluno);
    }


    public List<Aluno> get() {
        return alunoRepository.findAll();
    }


    public Optional<Aluno> getById(Integer id) {
        return alunoRepository.findById(id);
    }


    public Aluno update(Aluno aluno) {
        // Se id for nulo, save faz insert; aqui pressupomos que o caller valida
        return alunoRepository.save(aluno);
    }


    public void deleteById(Integer id) {
        alunoRepository.deleteById(id);
    }
}
