package integrador1.Entities;

public class ProductoTotalRecaudado {
    private int id;
    private String nombre;
    private Float total;
    private Float cantidad;

    public ProductoTotalRecaudado(int id, String nombre, Float valor, Float cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.total = valor;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getTotal() {
        return total;
    }

    public Float getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return id + " | " + nombre + " | Total recaudado: $" + total;
    }
}
