package com.aerochinquihue.model;

public class EncomiendaData {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String rut;
    private String direccion;
    private String destino;
    private String peso;
    private String fecha;
    private String avionSel;
    private String remitente;
    private Boolean emergencia;
    private int descuento, valorFinal;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getPeso() { return peso; }
    public void setPeso(String peso) { this.peso = peso; }

    public String getFecha() { return fecha; }
    public void setFecha(String Fecha) { this.fecha = Fecha; }

    public String getAvionSel() { return avionSel; }
    public void setAvion(String avionSel) { this.avionSel = avionSel; }
    
    public boolean isEmergencia() { return emergencia; }
    public void setEmergencia(boolean emergencia) { this.emergencia = emergencia; }

    public int getDescuento() { return descuento; }
    public void setDescuento(int descuento) { this.descuento = descuento; }

    public int getValorFinal() { return valorFinal; }
    public void setValorFinal(int valorFinal) { this.valorFinal = valorFinal; }

    public String getRemitente() { return remitente; }
    public void setRemitente(String remitente) { this.remitente = remitente; }
}
