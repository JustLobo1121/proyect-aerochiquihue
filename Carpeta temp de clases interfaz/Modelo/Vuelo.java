public class Vuelo extends Viajes{
    
    protected int id;
    protected int pasajeros;

    public Vuelo(int id, int pasajeros) {
        this.id = id;
        this.pasajeros = pasajeros;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPasajeros() {
        return pasajeros;
    }
    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }



    public int calcularPrecios() {
        int precioPorDestino;

        if (pasajeros <= 0) {
            throw new IllegalArgumentException("Los pasajeros deben ser mayores a 0.");
        }

        switch (getDestino().toLowerCase()) {
            case "cochamo":
            case "puelo bajo":
            case "contao":
                precioPorDestino = 20000;
                break;

            case "rio negro":
            case "pupelde":
                precioPorDestino = 25000;
                break;

            case "chepu":
            case "ayacara":
                precioPorDestino = 30000;
                break;

            case "pillan":
            case "renigue":
            case "isla quenac":
            case "palqui":
                precioPorDestino = 40000;
                break;

            case "chaiten":
            case "santa barbara":
                precioPorDestino = 50000;
                break;

            default:
                throw new IllegalArgumentException("Destino desconocido.");
        }

        return pasajeros * precioPorKg;
    }

    @Override
    public double calcularPrecio() {
        return calcularPrecios(); 
    }

    @Override
    public boolean estaOcupado(int fila, int columna) {
        return false;
    }
    
    @Override
    public boolean reservar(int fila, int columna) {
        return false;
    }

    @Override
    public boolean registroPago() {
        System.out.println("Procesando pago...");
        return true; 
    }

    @Override
    public String toString() {
        return super.toString() + " | Pasajero(s): " + pasajeros + " | ID: " + id;
    }


    


}
