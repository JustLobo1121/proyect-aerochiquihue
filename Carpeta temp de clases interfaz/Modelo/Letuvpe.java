

public class Letuvpe extends Avion {

    public Caravan(int asientos[][], int pasajeros, int pos, double precio, int x, int y) {
        super(asientos, pasajeros, pos, precio, x, y);
    }

    public Caravan() {
        super(); 
        this.pasajeros = 19; 
        this.precio = 1.800; 
        this.x = 10; 
        this.y = 10; 
        this.asientos = new int[x][y]; 
        this.asientoIndividual = new int[x][y]; 
    }

    public void organizarAsientos() {
        // Usamos un for para recorrer todos los asientos y organizarlos
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (asientos[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        asientos[i][j] = 2; 
                    } else {
                        asientos[i][j] = 0; 
                    }
                }
            }
        }
    }

    public void mostrarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
    }





    
}
