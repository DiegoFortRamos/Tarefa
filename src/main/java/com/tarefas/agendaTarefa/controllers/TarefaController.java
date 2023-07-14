package com.tarefas.agendaTarefa.controllers;

import com.tarefas.agendaTarefa.domain.tarefas.*;
import com.tarefas.agendaTarefa.repositories.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid TarefaCadastrotDTO dados,UriComponentsBuilder uribilder){
        var tarefa = repository.save(new Tarefa(dados));
        var uri = uribilder.path("/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();

        return ResponseEntity.created(uri).body(new TarefaDetalhamentoDTO(tarefa));
    }

    @GetMapping
    public ResponseEntity<Page<TarefaListaDTO>> listar(@PageableDefault(size = 5) Pageable paginacao){
        var page = repository.findAll(paginacao).map(TarefaListaDTO::new);
        return  ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody TarefaAtualizaDTO dados){
        var tarefa = repository.getReferenceById(dados.id());
        tarefa.atualiza(dados);

        return ResponseEntity.ok(new TarefaDetalhamentoDTO(tarefa));

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhaTarefa(@PathVariable Long id ){
        var tarefa = repository.getReferenceById(id);
        return ResponseEntity.ok(new TarefaDetalhamentoDTO(tarefa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
         repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
