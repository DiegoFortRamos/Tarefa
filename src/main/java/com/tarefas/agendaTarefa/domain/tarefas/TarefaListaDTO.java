package com.tarefas.agendaTarefa.domain.tarefas;

import jakarta.validation.constraints.NotNull;

public record TarefaListaDTO(

        String nome,
        String descricao,

        Realizado realizado,

        String prioridade
)  {
    public TarefaListaDTO(Tarefa tarefa){
        this( tarefa.getNome(), tarefa.getDescricao(),tarefa.getRealizado(), tarefa.getPrioridade());
    }
}
