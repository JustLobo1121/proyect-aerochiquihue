

public class Encomienda extends Viajes {

    private int peso; 
    private int id;   

    public Encomienda(String destino, double precioBase, int peso, int id) {
        super(destino, precioBase);
        this.peso = peso;
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int calcularPrecios() {
        int precioPorKg;

        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a 0.");
        }

        switch (getDestino().toLowerCase()) {
            case "cochamo":
            case "puelo bajo":
            case "contao":
                precioPorKg = 5000;
                break;

            case "rio negro":
            case "pupelde":
                precioPorKg = 6000;
                break;

            case "chepu":
            case "ayacara":
                precioPorKg = 8000;
                break;

            case "pillan":
            case "renigue":
            case "isla quenac":
            case "palqui":
                precioPorKg = 12000;
                break;

            case "chaiten":
            case "santa barbara":
                precioPorKg = 15000;
                break;

            default:
                throw new IllegalArgumentException("Destino desconocido.");
        }

        return peso * precioPorKg;
    }

    public void destinatario(String nombre, String direccion) {
        System.out.println("Destinatario: " + nombre);
        System.out.println("Dirección: " + direccion);
    }

    public void registrarPeso(int peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a 0.");
        }
        this.peso = peso;
        System.out.println("Peso registrado: " + peso + " kg");
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
        return super.toString() + " | Peso: " + peso + " kg | ID: " + id;
    }
}

