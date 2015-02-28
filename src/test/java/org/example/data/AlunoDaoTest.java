package org.example.data;

import org.example.domain.Aluno;
import org.example.domain.Professor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@ContextConfiguration(locations = "classpath:springContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration
public class AlunoDaoTest
{
  @Autowired
  private AlunoDao     alunoDao;
  @Autowired
  private ProfessorDao professorDao;

  @Before
  public void before()
  {
    alunoDao.persist(new Aluno());
    professorDao.persist(new Professor());
  }

  @Test
  public void test()
  {
    Aluno aluno = alunoDao.find(1L);
    Professor professor = professorDao.find(1L);

    aluno.setProfessorList(Arrays.asList(professor));
    alunoDao.persist(aluno);
  }
}
