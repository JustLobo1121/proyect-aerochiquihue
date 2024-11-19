package com.aerochinquihue;
/*
 * posiblemente desechar
 */
public class Avion {
    public Double PesoMax;
    public Double PesoActual;
    public int Asientos;

    Avion(Double PesoMax, int Asientos) {
        this.PesoMax = PesoMax;
        this.Asientos = Asientos;
    }
    public int getAsientos() {
        return this.Asientos;
    }
    public Double getPesoMax() {
        return this.PesoMax;
    }
    public Double getActualPeso() {
        return this.PesoActual;
    }   
}