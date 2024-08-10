package com.api.escolaapi.repositorys;

import com.api.escolaapi.funcionario.FuncionarioClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<FuncionarioClass, Integer> {
    List<FuncionarioClass> findAllByAtivoTrue();
    List<FuncionarioClass> findAllByAtivoFalse();
}
