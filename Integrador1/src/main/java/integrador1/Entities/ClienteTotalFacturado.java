package integrador1.Entities;

public class ClienteTotalFacturado {
    private int idCliente;
    private String nombre;
    private double totalFacturado;

    public ClienteTotalFacturado(int idCliente, String nombre, double totalFacturado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.totalFacturado = totalFacturado;
    }

    public int getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public double getTotalFacturado() { return totalFacturado; }

    @Override
    public String toString() {
        return idCliente + " | " + nombre + " | Total facturado: " + totalFacturado;
    }
}
