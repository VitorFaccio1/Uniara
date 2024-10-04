package org.example.service;

import org.example.model.Atividade;
import org.example.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {
    @Autowired
    private AtividadeRepository atividadeRepository;

    public void save(Atividade client){
        atividadeRepository.save(client);
    }

    public List<Atividade> findAll(){
        return atividadeRepository.findAll();
    }

    public Optional<Atividade> findById(String id){
        return atividadeRepository.findById(id);
    }

    public void delete(String id){
        atividadeRepository.deleteById(id);
    }
}