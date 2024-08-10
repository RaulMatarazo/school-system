package com.api.escolaapi.funcionario.DTOs;

import com.api.escolaapi.Enums.TipoEnum;
import com.api.escolaapi.funcionario.FuncionarioClass;

public record FuncionarioDTOGet(int id, String primeiro_nome, String sobrenome, TipoEnum tipo, Float salario) {
    public FuncionarioDTOGet(FuncionarioClass funcionarioClass){
        this(funcionarioClass.getFuncionario_id(), funcionarioClass.getPrimeiro_nome(), funcionarioClass.getSobrenome(), funcionarioClass.getTipo(),
                funcionarioClass.getSalario());
    }
}
