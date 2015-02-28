package org.example.data;

import org.example.domain.Professor;

public interface ProfessorDao
{
  Professor find(Long id);

  void persist(Professor professor);
}
