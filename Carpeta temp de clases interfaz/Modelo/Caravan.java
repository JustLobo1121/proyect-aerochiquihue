public class Caravan extends Avion {
    public class Caravan extends Avion {

        public Caravan(int asientos[][], int pasajeros, int pos, double precio, int x, int y) {
            super(asientos, pasajeros, pos, precio, x, y);
        }
    
        public Caravan() {
            super(); 
            this.pasajeros = 9; 
            this.precio = 1.315; 
            this.x = 3;  
            this.y = 5;  
            this.asientos = new int[x][y];  
        }
        
        public void organizarAsientos() {
            for (int i = 0; i < asientos.length; i++) {
                for (int j = 0; j < asientos[i].length; j++) {
                    if (i == 1 && j == 4) { // Deshabilitar el asiento en la posición (1, 4)
                        asientos[i][j] = -1; // Asiento deshabilitado
                    } else {
                        asientos[i][j] = 0; // Asientos libres
                    }
                }
            }
        }
        
        public void mostrarAsientos() {
            System.out.println("Estado de los asientos:");
            System.out.println("0 = libre, 1 = ocupado, -1 = deshabilitado");
            for (int i = 0; i < asientos.length; i++) {
                for (int j = 0; j < asientos[i].length; j++) {
                    if (asientos[i][j] == -1) {
                        System.out.print("X ");  // Marca con 'X' los asientos deshabilitados
                    } else {
                        System.out.print(asientos[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
    
}


