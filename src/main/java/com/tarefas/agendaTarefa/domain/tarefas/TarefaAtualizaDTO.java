package com.tarefas.agendaTarefa.domain.tarefas;

public record TarefaAtualizaDTO(

        Long id,
        String nome,
        String descricao,

        Realizado realizado,

        String prioridade
) {
}
