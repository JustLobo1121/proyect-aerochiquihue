public class Persona {
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected String rut;
    protected String direccion;

    public Persona(String apellidos, String direccion, String nombre, String rut, String telefono) {
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    



}
