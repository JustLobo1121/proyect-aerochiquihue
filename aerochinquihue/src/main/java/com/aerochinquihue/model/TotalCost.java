package com.aerochinquihue.model;

public class TotalCost {
    private String Destino;
    private int Peso;
    private String Tipo;
    private int Asiento;
    public TotalCost(String Destino, int Peso, String Tipo) {
        this.Tipo = Tipo;
        if (this.Tipo.equalsIgnoreCase("Viaje")) {
            this.Destino = Destino;
            this.Asiento = Peso;
        } else {
            this.Destino = Destino;
            this.Peso = Peso;
        }
    }
    /*
     * Destino         - Precio Pasaje (por persona) - Precio Encomienda (cada kg)
     * Cochamo         - 20.000                      - 5.000 -
     * Puelo Bajo      - 20.000                      - 5.000 -
     * Contao          - 20.000                      - 5.000 -
     * Rio Negro       - 25.000                      - 6.000 -2
     * Pupelde         - 25.000                      - 6.000 -2 v
     * Chepu           - 30.000                      - 8.000 -3
     * Ayacara         - 30.000                      - 8.000 -3 v
     * Pillan          - 40.000                      - 12.000 -4
     * Renihue         - 40.000                      - 12.000 -4 
     * Isla Quenac     - 40.000                      - 12.000 -4
     * Palqui          - 40.000                      - 12.000 -4
     * Chaiten         - 50.000                      - 15.000 -5
     * Santa Barbara   - 50.000                      - 15.000 -5
     *
     */
    public int getTotal() {
        switch (this.Destino) {
            case "Cochamo":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return (20000 * this.Asiento);
                } else {
                    return (5000 * this.Peso);
                }
            case "Puelo Bajo":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return (20000 * this.Asiento);
                } else {
                    return (5000 * this.Peso);
                }
            case "Contao":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return (20000 * this.Asiento);
                } else {
                    return (5000 * this.Peso);
                }
            case "Rio Negro":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return (25000 * this.Asiento);
                } else {
                    return (6000 * this.Peso);
                }
            case "Pupelde":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return (25000 * this.Asiento);
                } else {
                    return (6000 * this.Peso);
                }
            case "Chepu":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return (30000 * this.Asiento);
                } else {
                    return (8000 * this.Peso);
                }
            case "Ayacara":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return (30000 * this.Asiento);
                } else {
                    return 8000 * this.Peso;
                }
            case "Pillan":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return 40000 * this.Asiento;
                } else {
                    return 12000 * this.Peso;
                }
            case "Renihue":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return 40000 * this.Asiento;
                } else {
                    return 12000 * this.Peso;
                }
            case "Isla Quenac":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return 40000 * this.Asiento;
                } else {
                    return 12000 * this.Peso;
                }
            case "Palqui":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return 40000 * this.Asiento;
                } else {
                    return 12000 * this.Peso;
                } 
            case "Chaiten":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return 50000 * this.Asiento;
                } else {
                    return 15000 * this.Peso;
                } 
            case "Santa Barbara":
                if (this.Tipo.equalsIgnoreCase("viaje")) {
                    return 50000 * this.Asiento;
                } else {
                    return 15000 * this.Peso;
                }
            default:
                throw new IllegalArgumentException("Destino no encontrado: " + this.Destino);
        }
    }
}
