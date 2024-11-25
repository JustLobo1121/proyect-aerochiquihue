public class Avion {

    protected double precio;
    protected int pasajeros;
    private int[][] asientos; 
    private int x, y, pos;

    public Avion(int[][] asientos, int pasajeros, double precio, int x, int y) {
        this.asientos = asientos;
        this.pasajeros = pasajeros;
        this.precio = precio;
        this.x = x;
        this.y = y;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getPasajeros() {
        return pasajeros;
    }
    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }
    public int[][] getAsientos() {
        return asientos;
    }
    public void setAsientos(int[][] asientos) {
        this.asientos = asientos;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }

    public boolean asignarAsiento(int x, int y) {
        if (asientos[x][y] == 0) {
            asientos[x][y] = 1;
            return true; 
        }
        return false; 
    }

    
    public boolean verificarAsiento(int x, int y) {
        return asientos[x][y] == 1; 
    }

   
    public boolean asignarAsientoIndividual(int x, int y) {
        if (asientos[x][y] == 0) { 
            asientos[x][y] = 2; 
            return true;
        }
        return false; 
    }

   
    public boolean esAsientoIndividual(int x, int y) {
        return asientos[x][y] == 2; 
    }

   
    public void mostrarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " "); 
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Precio: " + precio + ", Pasajeros: " + pasajeros;
    }
}
