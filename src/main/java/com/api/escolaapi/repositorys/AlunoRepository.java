package com.api.escolaapi.repositorys;

import com.api.escolaapi.aluno.AlunoClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AlunoRepository extends JpaRepository<AlunoClass, Integer> {
    List<AlunoClass> findAllByAtivoTrue();
}
