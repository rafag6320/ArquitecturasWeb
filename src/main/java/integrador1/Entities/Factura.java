package integrador1.Entities;

import java.util.List;

public class Factura {
    private int idFactura;
    private Cliente cliente;
    private int idCliente;
    private List<Producto> productos;

    public Factura() {}
    public Factura(int idFactura, Cliente cliente, List<Producto> productos) {
        this.idFactura = idFactura;
        this.cliente = cliente;
        this.productos = productos;
    }
    public Factura(int idFactura, int idCliente) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
    }

    public int getIdFactura() { return idFactura; }
    public void setIdFactura(int idFactura) { this.idFactura = idFactura; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }

    public int getIdCliente() {return idCliente;}
    @Override
    public String toString() {
        return "Factura [id=" + idFactura + ", cliente=" + cliente + ", productos=" + productos + "]";
    }
}