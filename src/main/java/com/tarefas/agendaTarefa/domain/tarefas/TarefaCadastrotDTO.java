package com.tarefas.agendaTarefa.domain.tarefas;

import jakarta.validation.constraints.NotNull;

public record TarefaCadastrotDTO(

        @NotNull
        String nome,
        @NotNull
        String descricao,
        @NotNull
        Realizado realizado,
        @NotNull
        String prioridade
){
}
