public class Avion {

    protected double precio;
    protected int pasajeros;
    private int asientos[][];
    private int asientoIndividual[][];
    private int numeroAsiento[]={};
    private int x, y, pos;


    public Avion(int[][] asientoIndividual, int[][] asientos, int pasajeros, int pos, double precio, int x, int y) {
        this.asientoIndividual = asientoIndividual;
        this.asientos = asientos;
        this.pasajeros = pasajeros;
        this.pos = pos;
        this.precio = precio;
        this.x = x;
        this.y = y;
    }
    
    public Avion(){
        this.pasajeros = 0;
        this.precio = 0;
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
    public int[][] getAsientoIndividual() {
        return asientoIndividual;
    }
    public void setAsientoIndividual(int[][] asientoIndividual) {
        this.asientoIndividual = asientoIndividual;
    }
    public int[] getNumeroAsiento() {
        return numeroAsiento;
    }
    public void setNumeroAsiento(int[] numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
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
    


    public void asignarAsiento(int x, int y, int asientoIndividual[][], int asiento[][]){
        boolean verificar;
        if(asiento[x][y]==0){
            asiento[x][y]=1;
            verificar = true;
        } else if(asiento[x][y] == 1){
            verificar = false;
        }
        if(asientoIndividual[x][y]==0){
            asientoIndividual[x][y]=1;
            verificar = true;
        } else if(asientoIndividual[x][y] == 1){
            verificar = false;
        }
    }
    public boolean verificarAsiento(int x, int y, int asientoIndividual[][], int asiento[][]){
        boolean verificar;
        if(asiento[x][y]==1){
            verificar = false;
        }
        if(asientoIndividual[x][y]==1){
            verificar = false;
        }
        return verificar;
    }
    //Revisar verificacion
    
    
    public void seleccionarAvionDisponibilidad(){
        asignarAsiento(x, y, asientoIndividual, asientos);

        switch (pos) {
            case 1:
                this.asientos=asientos.clone(); 
                break;
            case 2:
                this.asientoIndividual=asientoIndividual.clone();
                break;
        }
        
    }

    //Revisar asientos
    @Override
    public String toString() {
        return "Precio: " + precio + "Pasajeros: " + pasajeros + "Asientos: " + asientos + "Asientos individuales" + asientoIndividual + "N: " + numeroAsiento; } 
    }