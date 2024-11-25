public class Vuelo extends Viajes{
    
    protected int id;
    protected int pasajeros;

    


    
    
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

    
    


    


}
