package com.ucema.proga3.clase.dto;

public class AvisoDTO {

    private Long id;
    private String texto;
    private UserDTO usuario;

    public AvisoDTO() {
    }

    public AvisoDTO(Long id, String texto, UserDTO usuario) {
        this.id = id;
        this.texto = texto;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public UserDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UserDTO usuario) {
        this.usuario = usuario;
    }

}
