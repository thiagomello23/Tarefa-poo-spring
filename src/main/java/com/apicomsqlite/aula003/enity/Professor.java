package com.apicomsqlite.aula003.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professor {
    
  @Id
  private int id;

  private String nome;
  private String sobrenome;
  private String telefone;
  private String email;
  private String materia; 

  public Professor(){}

  // Getters
  public String getEmail() {
      return email;
  }
  public int getId() {
      return id;
  }
  public String getMateria() {
      return materia;
  }
  public String getNome() {
      return nome;
  }
  public String getSobrenome() {
      return sobrenome;
  }
  public String getTelefone() {
      return telefone;
  }

  // Setters
  public void setEmail(String email) {
      this.email = email;
  }
  public void setId(int id) {
      this.id = id;
  }
  public void setMateria(String materia) {
      this.materia = materia;
  }
  public void setNome(String nome) {
      this.nome = nome;
  }
  public void setSobrenome(String sobrenome) {
      this.sobrenome = sobrenome;
  }
  public void setTelefone(String telefone) {
      this.telefone = telefone;
  }
}
