package org.example.data;

import org.example.domain.Aluno;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaAlunoDao implements AlunoDao
{
  @PersistenceContext
  private EntityManager em;

  public Aluno find(Long id)
  {
    return em.find(Aluno.class, id);
  }

  @Transactional
  public void persist(Aluno aluno)
  {
    em.persist(aluno);
  }
}
