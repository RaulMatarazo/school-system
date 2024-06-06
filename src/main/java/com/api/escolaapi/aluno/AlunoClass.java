package com.api.escolaapi.aluno;

import com.api.escolaapi.Enums.CursoEnum;
import com.api.escolaapi.Enums.SerieEnum;
import com.api.escolaapi.aluno.DTOs.AlunoDTO;
import com.api.escolaapi.aluno.DTOs.AlunoDTOPut;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Table(name = "Alunos")
@Entity(name = "alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "aluno_id")
public class AlunoClass {

    public AlunoClass(AlunoDTO dados) {
        this.primeiro_nome = dados.primeiro_nome();
        this.sobrenome = dados.sobrenome();
        this.data_nascimento = dados.data_nascimento();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.curso = dados.curso();
        this.serie = dados.serie();
        this.ativo = true;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aluno_id;

    private String primeiro_nome, sobrenome, email, telefone;

    private LocalDate data_nascimento;

    @Enumerated(EnumType.STRING)
    private SerieEnum serie;

    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    private boolean ativo;

    public void atualizarInformacoes(@Valid AlunoDTOPut dados) {
        if (dados.serie() != null) {
            this.serie = dados.serie();
        }
        if (dados.telefone() != null && !dados.telefone().isEmpty()) {
            this.telefone = dados.telefone();
        }
        if (dados.email() != null && !dados.email().isEmpty()) {
            this.email = dados.email();
        }
    }

    public void desativar() {
        this.ativo = false;
    }
    public void ativar(){
        this.ativo = true;
    }
}
