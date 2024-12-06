package com.aerochinquihue.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class AssistantData {
    private String nombre, apellidos, telefono, rut, direccion, destino, tipoEncomienda, peso, fecha,avionSel, asiento;
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

    public String getTipoEncomienda() { return tipoEncomienda; }
    public void setTipoEncomienda(String tipoEncomienda) { this.tipoEncomienda = tipoEncomienda; }

    public String getFecha() { return fecha; }
    public void setFecha(String Fecha) { this.fecha = Fecha; }

    public String getAvionSel() { return avionSel; }
    public void setAvion(String avionSel) { this.avionSel = avionSel; }
    
    public String getAsiento() { return asiento; }
    public void setAsiento(String asientos) { this.asiento = asientos; }
    public boolean isEmergencia() { return emergencia; }
    public void setEmergencia(boolean emergencia) { this.emergencia = emergencia; }

    public int getDescuento() { return descuento; }
    public void setDescuento(int descuento) { this.descuento = descuento; }

    public int getValorFinal() { return valorFinal; }
    public void setValorFinal(int valorFinal) { this.valorFinal = valorFinal; }

    public String generateHash() {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append(this.fecha)
                   .append(this.destino)
                   .append(this.avionSel)
                   .append(this.tipoEncomienda);
        
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(builder.toString().getBytes());
        
            return byteArrayToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    private String byteArrayToHex(byte[] byteArray) {
        try (Formatter formatter = new Formatter()) {
            for (byte b : byteArray) {
                formatter.format("%02x", b);
            }
            return formatter.toString();
        }
    }
}

