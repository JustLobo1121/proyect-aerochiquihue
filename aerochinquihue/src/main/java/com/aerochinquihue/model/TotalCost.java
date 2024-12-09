package com.aerochinquihue.model;

import java.util.List;

import com.aerochinquihue.db.DataReader;

public class TotalCost {
    private String Destino;
    private int Peso;
    private int Asiento;
    public TotalCost(String Destino, int Peso) {
        this.Destino = Destino;
        this.Asiento = Peso;
        this.Peso = Peso;
    }
    public int calTotalViajes() {
        switch (this.Destino) {
            case "Cochamo":
                return (20000 * this.Asiento);
            case "Puelo Bajo":
                return (20000 * this.Asiento);
            case "Contao":
                return (20000 * this.Asiento);
            case "Rio Negro":
                return (25000 * this.Asiento);
            case "Pupelde":
                return (25000 * this.Asiento);
            case "Chepu":
                return (30000 * this.Asiento);
            case "Ayacara":
                return (30000 * this.Asiento);
            case "Pillan":
                return 40000 * this.Asiento;
            case "Renihue":
                return 40000 * this.Asiento;
            case "Isla Quenac":
                return 40000 * this.Asiento;
            case "Palqui":
                return 40000 * this.Asiento; 
            case "Chaiten":
                return 50000 * this.Asiento; 
            case "Santa Barbara":
                return 50000 * this.Asiento;
            default:
                throw new IllegalArgumentException("Destino no encontrado: " + this.Destino);
        }
    }
    public int calTotalEncomiendas() {
        switch (this.Destino) {
            case "Cochamo":
                return (5000 * this.Peso);
            case "Puelo Bajo":
                return (5000 * this.Peso);
            case "Contao":
                return (5000 * this.Peso);
            case "Rio Negro":
                return (6000 * this.Peso);
            case "Pupelde":
                return (6000 * this.Peso);
            case "Chepu":
                return (8000 * this.Peso);
            case "Ayacara":
                return 8000 * this.Peso;
            case "Pillan":
                return 12000 * this.Peso;
            case "Renihue":
                return 12000 * this.Peso;
            case "Isla Quenac":
                return 12000 * this.Peso;
            case "Palqui":
                return 12000 * this.Peso; 
            case "Chaiten":
                return 15000 * this.Peso;
            case "Santa Barbara":
                return 15000 * this.Peso;
            default:
                throw new IllegalArgumentException("Destino no encontrado: " + this.Destino);
        }
    }

    public int getTotalViajes() {
        DataReader dataReader = new DataReader();
        List<ViajeData> viajeDataList = dataReader.readDataViaje();
        int totalViajes = 0;

        for (ViajeData viaje : viajeDataList) {
            totalViajes += viaje.getValorFinal();
        }

        return totalViajes;
    }
    public int getTotalEncomiendas() {
        DataReader dataReader = new DataReader();
        List<EncomiendaData> encomiendaDataList = dataReader.readDataEncomienda();
        int totalEncomiendas = 0;

        for (EncomiendaData encomienda : encomiendaDataList) {
            totalEncomiendas += encomienda.getValorFinal();
        }

        return totalEncomiendas;
    }

}
