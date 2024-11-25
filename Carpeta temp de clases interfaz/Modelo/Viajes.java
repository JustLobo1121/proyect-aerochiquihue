public abstract class Viajes {

    private String destino; 
    private double precioBase; 

    public Viajes(String destino, double precioBase) {
        this.destino = destino;
        this.precioBase = precioBase;
    }

    public String getDestino() {
        return destino;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecio();

    public abstract boolean estaOcupado(int fila, int columna);

    public abstract boolean reservar(int fila, int columna);

    public abstract boolean registroPago();

    @Override
    public String toString() {
        return "Viaje a " + destino + " con precio " + precioBase;
    }
}
