package com.tarefas.agendaTarefa.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.swing.text.html.parser.Entity;

@RestControllerAdvice
public class TrataErros {

    @ExceptionHandler(EntityNotFoundException.class)
   public ResponseEntity tratarErro404(){
       return ResponseEntity.notFound().build();
   }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(ErrosValidacaoDTO::new).toList());
    }

    private record ErrosValidacaoDTO(String campo,String mensagem){
        public ErrosValidacaoDTO(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
