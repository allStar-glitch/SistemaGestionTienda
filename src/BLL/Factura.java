package BLL;

import java.util.Locale;

public abstract class Factura {

    // para mostrar los datos de cada compra
    public abstract String detalle();

    // Aqui se arma la factura.
    public String generar() {
        return "+--------------------------------+\n"
                + "|            FACTURA             |\n"
                + "+--------------------------------+\n"
                + detalle()
                + "+--------------------------------+\n";
    }

    // Este metodo convierte a dinero.
    public static String dinero(double valor) {
        return String.format(Locale.US, "$%.2f", valor);
    }
}
