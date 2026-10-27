package DAL;

public class Cliente {

    private int id;
    private String nombre;
    private String telefono;

    public Cliente(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }

    public String descripcion() {
        return "ID: " + id + " | Nombre: " + nombre + " | Tel: " + telefono;
    }
}