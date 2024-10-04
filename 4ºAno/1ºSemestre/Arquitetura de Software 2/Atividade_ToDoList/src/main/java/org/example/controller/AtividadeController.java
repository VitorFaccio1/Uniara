package org.example.controller;

import org.example.constant.Constant;
import org.example.model.Atividade;
import org.example.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping(Constant.API_CLIENT)
    public void save(@RequestBody String descricao){

        var atividade = new Atividade();
        atividade.setDescricao(descricao);

        atividadeService.save(atividade);
    }

    @GetMapping(Constant.API_CLIENT)
    public List<Atividade> findAll(){
        return atividadeService.findAll();
    }

    @GetMapping(Constant.API_CLIENT + "/{id}")
    public Optional<Atividade> findById(@PathVariable("id") String id){
        return atividadeService.findById(id);
    }

    @DeleteMapping(Constant.API_CLIENT + "/{id}")
    public void delete(@PathVariable("id") String id){
        atividadeService.delete(id);
    }
}
