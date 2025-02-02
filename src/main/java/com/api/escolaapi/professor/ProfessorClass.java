package com.api.escolaapi.professor;

import com.api.escolaapi.Enums.CursoEnum;
import com.api.escolaapi.professor.DTOs.ProfessorDTO;
import com.api.escolaapi.professor.DTOs.ProfessorDTOPut;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "Professores")
@Entity(name = "professores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "professor_id")
public class ProfessorClass {

    // Construtor para cadastrar um novo professor
    public ProfessorClass(ProfessorDTO dados) {
        this.primeiro_nome = dados.primeiro_nome();
        this.sobrenome = dados.sobrenome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.data_nascimento = dados.data_nascimento();
        this.salario = dados.salario();
        this.curso = dados.curso();
        this.ativo = true;
    }

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professor_id;
    // Strings
    private String primeiro_nome, sobrenome;
    @Column(unique = true)
    private String email, telefone;
    // Local Dates
    private LocalDate data_nascimento;
    // Enums
    @Enumerated(EnumType.STRING)
    private CursoEnum curso;
    // Booleanos
    private boolean ativo;
    // Floats
    private Float salario;

    public void atualizarInformacoes(ProfessorDTOPut dados) {
        if (dados.email() != null && !dados.email().isEmpty()) {
            this.email = dados.email();
        }
        if (dados.telefone() != null && !dados.telefone().isEmpty()) {
            this.telefone = dados.telefone();
        }
        if (dados.salario() != null) {
            this.salario = dados.salario();
        }
    }

    public void desativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }
}
