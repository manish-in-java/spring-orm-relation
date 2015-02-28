package org.example.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Professor")
public class Professor implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "idProfessor", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "ALUNO_PROFESSOR",
      joinColumns = @JoinColumn(name = "idProfessor"),
      inverseJoinColumns = @JoinColumn(name = "idAluno"))
  private List<Aluno> alunoList;

  public Long getId()
  {
    return id;
  }

  public List<Aluno> getAlunoList()
  {
    return alunoList;
  }

  public void setAlunoList(List<Aluno> alunoList)
  {
    this.alunoList = alunoList;
  }
}
