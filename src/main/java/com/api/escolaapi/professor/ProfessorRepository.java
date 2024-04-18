package com.api.escolaapi.professor;

import com.api.escolaapi.aluno.AlunoClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<ProfessorClass, Integer> {
    List<ProfessorClass> findAllByAtivoTrue();

}
