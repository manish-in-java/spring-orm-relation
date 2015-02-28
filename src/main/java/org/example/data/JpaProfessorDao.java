package org.example.data;

import org.example.domain.Professor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaProfessorDao implements ProfessorDao
{
  @PersistenceContext
  private EntityManager em;

  public Professor find(Long id)
  {
    return em.find(Professor.class, id);
  }

  @Transactional
  public void persist(Professor professor)
  {
    em.persist(professor);
  }
}
