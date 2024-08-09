package com.api.escolaapi.funcionario;

import com.api.escolaapi.Enums.CursoEnum;
import com.api.escolaapi.Enums.TipoEnum;
import com.api.escolaapi.professor.DTOs.ProfessorDTO;
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

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int funcionario_id;
    // Strings
    private String primeiro_nome, sobrenome, email, telefone, senha;
    // Ints
    private int sexo;
    // Local Dates
    private LocalDate data_nascimento;
    // Enums
    @Enumerated(EnumType.STRING)
    private TipoEnum tipo;
    // Booleanos
    private boolean ativo;
    // Floats
    private Float salario;
}
