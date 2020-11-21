package com.upc.group.parkingapp.modelos;

public class ControlMarcacionUsuario {

    private String id;
    private String personaId;
    private String tipoMarcacion;
    private String fechaHoraMarcacion;
    private String marca;
    private String modelo;
    private String numeroPlaca;

    public ControlMarcacionUsuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonaId() {
        return personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public String getTipoMarcacion() {
        return tipoMarcacion;
    }

    public void setTipoMarcacion(String tipoMarcacion) {
        this.tipoMarcacion = tipoMarcacion;
    }

    public String getFechaHoraMarcacion() {
        return fechaHoraMarcacion;
    }

    public void setFechaHoraMarcacion(String fechaHoraMarcacion) {
        this.fechaHoraMarcacion = fechaHoraMarcacion;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
