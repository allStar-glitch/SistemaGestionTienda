package DAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Inventario {

        private HashMap<String, Producto> productos = new HashMap<>();
        private ArrayList<Cliente> clientes = new ArrayList<>();
        private LinkedList<Compra> compras = new LinkedList<>();

        // PRODUCTOS
        public void agregarProducto(Producto p) {
            productos.put(p.getNombre().toLowerCase(), p);
        }

        public Producto buscarProducto(String nombre) {
            return productos.get(nombre.trim().toLowerCase());
        }

        public HashMap<String, Producto> getProductos() {
            return productos;
        }

        public double calcularTotal() {
            double total = 0;
            for (Producto p : productos.values()) {
                total += p.getCantidad() * p.getPrecio();
            }
            return total;
        }

        // CLIENTE
        public void agregarCliente(Cliente c) {
            clientes.add(c);
        }

        public Cliente buscarCliente(int id) {
            for (Cliente c : clientes) {
                if (c.getId() == id) {
                    return c;
                }
            }
            return null;
        }

        public ArrayList<Cliente> getClientes() {
            return clientes;
        }

        // COMPRA
        public void agregarCompra(Compra c) {
            compras.add(c);
        }

        public LinkedList<Compra> getCompras() {
            return compras;
        }
    }

