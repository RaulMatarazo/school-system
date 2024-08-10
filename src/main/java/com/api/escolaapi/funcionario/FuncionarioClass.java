package com.api.escolaapi.funcionario;

import com.api.escolaapi.Enums.CursoEnum;
import com.api.escolaapi.Enums.TipoEnum;
import com.api.escolaapi.funcionario.DTOs.FuncionarioDTO;
import com.api.escolaapi.funcionario.DTOs.FuncionarioDTOPut;
import com.api.escolaapi.professor.DTOs.ProfessorDTO;
import com.api.escolaapi.professor.DTOs.ProfessorDTOPut;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "Funcionarios")
@Entity(name = "funcionarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "funcionario_id")
public class FuncionarioClass {

    public FuncionarioClass(FuncionarioDTO dados) {
        this.primeiro_nome = dados.primeiro_nome();
        this.sobrenome = dados.sobrenome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.sexo = dados.sexo();
        this.data_nascimento = dados.data_nascimento();
        this.tipo = dados.tipo();
        this.salario = dados.salario();
        this.telefone = dados.telefone();
        this.ativo = true;
    }

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int funcionario_id;
    // Strings
    private String primeiro_nome, sobrenome, email, telefone, senha;
    // Ints
    private boolean sexo;
    // Local Dates
    private LocalDate data_nascimento;
    // Enums
    @Enumerated(EnumType.STRING)
    private TipoEnum tipo;
    // Booleanos
    private boolean ativo;
    // Floats
    private Float salario;

    public void atualizarInformacoes(FuncionarioDTOPut dados) {
        if (dados.tipo() != null && !dados.tipo().isEmpty()){
            this.tipo = dados.tipo();
        }
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
