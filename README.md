TiendaGestion

Sistema de gestion de tienda en Java con arquitectura de 3 capas.

Capas
dal: Producto, Cliente, Compra, Inventario (datos y colecciones)
bll: GestionTienda, Factura (reglas y validaciones)
ui: Main (menu con switch)
Requerimientos
Registrar clientes (ArrayList)
Registrar productos con nombre, cantidad y precio (HashMap)
Mostrar inventario con cantidad y precio
Registrar ventas: baja el stock y guarda la compra (LinkedList)
Historial de compras por cliente
Monto total del inventario
Factura detallada por cada venta
POO
Clase abstracta: Persona (dal)
Herencia: Cliente extends Persona
Interfaz: Facturable (ITBIS 18%), implementada por Compra
Polimorfismo: descripcion() sobrescrito en Cliente y usado desde Persona
