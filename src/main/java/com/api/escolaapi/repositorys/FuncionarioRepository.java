package com.api.escolaapi.repositorys;

import com.api.escolaapi.funcionario.FuncionarioClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioClass, Integer> {
}
