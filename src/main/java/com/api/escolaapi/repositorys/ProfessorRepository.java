package com.api.escolaapi.repositorys;

import com.api.escolaapi.aluno.AlunoClass;
import com.api.escolaapi.professor.ProfessorClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<ProfessorClass, Integer> {
    List<ProfessorClass> findAllByAtivoTrue();
}
