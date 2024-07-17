package com.ucema.proga3.clase.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "aviso")
public class Aviso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_aviso")
  private Long id;
  @Column(updatable = true, nullable = false, length = 30000)
  private String texto;


  @ManyToOne(cascade = {CascadeType.MERGE})
  @JoinColumn(name = "id_usuario", nullable = true)
  private User user;

    public Aviso(){}
    public Aviso(String texto, User user) {
      this.texto = texto;
      this.user=user;
    }

    public String getTexto() {
        return texto;
    }
    public User getUser(){return user;}
    public void setUser(User user){
      user= user;
  }

  public void setTexto(String aviso) {
        aviso = texto;
    }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
