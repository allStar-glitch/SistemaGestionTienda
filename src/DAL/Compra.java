package DAL;
import BLL.Factura;

interface Facturable {
    double ITBIS = 0.18;
    double calcularSubtotal();
    double calcularItbis();
    double calcularTotal();
}

// Aqui Compra hereda de Factura e implementa Facturable
public class Compra extends Factura implements Facturable {
    public Cliente cliente;
    public Producto producto;
    public double subtotal;
    public double itbis;
    public double total;
    public int cantidad;

    public Compra(Cliente cliente, Producto producto, int cantidad) {

        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
        this.itbis = calcularItbis();
        this.total = calcularTotal();
    }

    @Override
    public double calcularSubtotal() {
        // El subtotal es el precio por la cantidad comprada
        return producto.getPrecio() * cantidad;
    }

    @Override
    public double calcularItbis() {
        // Calculamos el impuesto usando el subtotal
        return subtotal * ITBIS;
    }

    @Override
    public double calcularTotal() {
        // Sumamos el subtotal y el impuesto para obtener el total
        return subtotal + itbis;
    }

    // Funciona para monstrar factura
    public String detalle() {
        String d = "| Cliente  : " + cliente.getNombre() + "                 |\n";
        d += "| Producto : " + producto.getNombre() + "               |\n";
        d += "| Cantidad : " + cantidad + "                   |\n";
        d += "| Precio U.: " + dinero(producto.getPrecio()) + "             |\n";
        d += "+--------------------------------+\n";
        d += "| Subtotal : " + dinero(subtotal) + "             |\n";
        d += "| ITBIS 18%: " + dinero(itbis) + "             |\n";
        d += "| Total    : " + dinero(total) + "             |\n";
        return d;
    }
}
