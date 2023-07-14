package com.tarefas.agendaTarefa.domain.tarefas;

public record TarefaDetalhamentoDTO(
        Long id,
        String nome,
        String descricao,

        Realizado realizado,

        String prioridade
) {
    public  TarefaDetalhamentoDTO(Tarefa tarefa){
        this(tarefa.getId(), tarefa.getNome(), tarefa.getDescricao(),tarefa.getRealizado(), tarefa.getPrioridade());
    }
}
