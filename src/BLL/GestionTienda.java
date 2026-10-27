package BLL;
import DAL.Cliente;
import DAL.Compra;
import DAL.Inventario;
import DAL.Producto;

public class GestionTienda {

    private Inventario inventario = new Inventario();

    public String registrarCliente(int id, String nombre, String telefono) {
        if (id <= 0) {
            return "El id debe ser mayor a 0 :( ";
        } else if (nombre.trim().isEmpty()) {
            return "El nombre no puede estar vacio :( ";
        } else if (inventario.buscarCliente(id) != null) {
            return "Ya existe un cliente con ese id :( ";
        } else {
            inventario.agregarCliente(new Cliente(id, nombre.trim(), telefono.trim()));
            return "Cliente registrado correctamente :) ";
        }
    }

    public String registrarProducto(String nombre, int cantidad, double precio) {
        if (nombre.trim().isEmpty()) {
            return " El nombre no puede estar vacio :(";
        } else if (cantidad < 0) {
            return "La cantidad no puede ser negativa :( ";
        } else if (precio <= 0) {
            return "El precio debe ser mayor a 0 :( ";
        } else if (inventario.buscarProducto(nombre) != null) {
            return "Ese producto ya existe :( ";
        } else {
            inventario.agregarProducto(new Producto(nombre.trim(), cantidad, precio));
            return " Producto registrado correctamente :)";
        }
    }

    public String mostrarInventario() {
        if (inventario.getProductos().isEmpty()) {
            return " El inventario esta vacio :(";
        }
        String texto = "************* Inventario de Productos *************\n";
        for (Producto p : inventario.getProductos().values()) {
            texto += "Producto: " + p.getNombre()
                    + " - Cantidad: " + p.getCantidad()
                    + " - Precio: " + Factura.dinero(p.getPrecio()) + "\n";
        }
        return texto;
    }

    public String mostrarClientes() {
        if (inventario.getClientes().isEmpty()) {
            return " No hay clientes registrados :(";
        }
        String texto = "************* Clientes ************* \n";
        for (Cliente c : inventario.getClientes()) {
            texto += c.descripcion() + "\n";
        }
        return texto;
    }

    public String vender(int idCliente, String nombreProducto, int cantidad) {
        Cliente cliente = inventario.buscarCliente(idCliente);
        Producto producto = inventario.buscarProducto(nombreProducto);

        if (cliente == null) {
            return " Cliente no encontrado :(";
        } else if (producto == null) {
            return "Producto no encontrado :(";
        } else if (cantidad <= 0) {
            return "La cantidad debe ser mayor a 0 :(";
        } else if (producto.getCantidad() < cantidad) {
            return " Stock insuficiente, disponible :( : " + producto.getCantidad();
        } else {
            // baja el stock y guarda la compra
            producto.setCantidad(producto.getCantidad() - cantidad);
            Compra compra = new Compra(cliente, producto, cantidad);
            inventario.agregarCompra(compra);
            //la compra se usa como Factura
            Factura factura = compra;
            return "Venta registrada correctamente :)\n" + factura.generar();
        }
    }

    public String historial() {
        if (inventario.getCompras().isEmpty()) {
            return "No hay compras registradas :( ";
        }
        String texto = "*************  Historial ************* \n";

        for (Cliente c : inventario.getClientes()) {
            for (Compra compra : inventario.getCompras()) {
                if (compra.cliente.getId() == c.getId()) {
                    texto += "Cliente: " + c.getNombre()
                            + " - Producto: " + compra.producto.getNombre()
                            + " - Cantidad: " + compra.cantidad
                            + " - Total: " + Factura.dinero(compra.total) + "\n";
                }
            }
        }
        return texto;
    }

    public String totalInventario() {
        return "Monto total del inventario: " + Factura.dinero(inventario.calcularTotal());
    }
}
