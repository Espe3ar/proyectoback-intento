package com.ucema.proga3.clase.dto;

import com.ucema.proga3.clase.Model.User;

import java.util.List;

public class AvisoDTO {

    private String texto;
    private User usuario;

  public  AvisoDTO(){

  }
  public AvisoDTO(String texto, User usuario){
      this.texto=texto;
      this.usuario=usuario;

  }
  public User getUsuario(){ return usuario;}

  public String getTexto(){return texto;}
}
