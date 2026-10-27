package UI;
import BLL.GestionTienda;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // punto decimal en vez de coma
        sc.useLocale(Locale.US);
        GestionTienda tienda = new GestionTienda();
        int opcion = -1;

        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1:
                    int id = leerEntero("ID del cliente: ");
                    String nombre = leerTexto("Nombre: ");
                    String tel = leerTexto("Telefono: ");
                    System.out.println(tienda.registrarCliente(id, nombre, tel));
                    break;
                case 2:
                    String prod = leerTexto("Nombre del producto: ");
                    int cant = leerEntero("Cantidad: ");
                    double precio = leerDecimal("Precio: ");
                    System.out.println(tienda.registrarProducto(prod, cant, precio));
                    break;
                case 3:
                    System.out.println(tienda.mostrarInventario());
                    break;
                case 4:
                    System.out.println(tienda.mostrarClientes());
                    int idCli = leerEntero("ID del cliente: ");
                    String nomProd = leerTexto("Producto a vender: ");
                    int cantVenta = leerEntero("Cantidad: ");
                    System.out.println(tienda.vender(idCli, nomProd, cantVenta));
                    break;
                case 5:
                    System.out.println(tienda.historial());
                    break;
                case 6:
                    System.out.println(tienda.totalInventario());
                    break;
                case 7:
                    System.out.println(tienda.mostrarClientes());
                    break;
                case 0:
                    System.out.println(":) Hasta luego!");
                    break;
                default:
                    System.out.println(":( Opcion invalida");
                    break;
            }
        }
    }

    static void mostrarMenu() {
        System.out.println();
        System.out.println("+1" +
                "------------------------------+");
        System.out.println("|        TIENDA GESTION        |");
        System.out.println("+------------------------------+");
        System.out.println("| 1. Registrar cliente         |");
        System.out.println("| 2. Registrar producto        |");
        System.out.println("| 3. Mostrar inventario        |");
        System.out.println("| 4. Registrar venta           |");
        System.out.println("| 5. Historial de compras      |");
        System.out.println("| 6. Total del inventario      |");
        System.out.println("| 7. Ver clientes         1     |");
        System.out.println("| 0. Salir                     |");
        System.out.println("+------------------------------+");
    }

    // lectores validados con hasNext
    static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print(":( Numero invalido, intente de nuevo: ");
        }
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }

    static double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            sc.next();
            System.out.print(":( Numero invalido, intente de nuevo: ");
        }
        double n = sc.nextDouble();
        sc.nextLine();
        return n;
    }

    static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }
}
