package org.example.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Aluno")
public class Aluno implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "idAluno", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "ALUNO_PROFESSOR",
      joinColumns = @JoinColumn(name = "idAluno"),
      inverseJoinColumns = @JoinColumn(name = "idProfessor"))
  private List<Professor> professorList;

  public Long getId()
  {
    return id;
  }

  public List<Professor> getProfessorList()
  {
    return professorList;
  }

  public void setProfessorList(List<Professor> professorList)
  {
    this.professorList = professorList;
  }
}
