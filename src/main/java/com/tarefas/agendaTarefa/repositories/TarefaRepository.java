package com.tarefas.agendaTarefa.repositories;

import com.tarefas.agendaTarefa.domain.tarefas.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
