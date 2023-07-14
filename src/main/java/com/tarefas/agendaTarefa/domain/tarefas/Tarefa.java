package com.tarefas.agendaTarefa.domain.tarefas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tarefas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tarefa")
    private Long id;
    private String nome;
    private String descricao;
    @Enumerated
    private Realizado realizado;
    private String prioridade;

    public Tarefa(TarefaCadastrotDTO dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.realizado = dados.realizado();
        this.prioridade = dados.prioridade();

    }

    public void atualiza(TarefaAtualizaDTO dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if(dados.realizado() != null){
            this.realizado = dados.realizado();
        }
        if(dados.prioridade() != null){
            this.prioridade = dados.prioridade();
        }
    }


}
