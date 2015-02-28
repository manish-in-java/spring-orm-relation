package org.example.data;

import org.example.domain.Aluno;

public interface AlunoDao
{
  Aluno find(Long id);

  void persist(Aluno aluno);
}
