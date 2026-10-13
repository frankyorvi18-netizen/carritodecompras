import java.util.Scanner;

void main() {
    Scanner fran = new Scanner(System.in);

    String[] catalogoNombres = {"Manzana", "Leche", "Arroz", "Galletas", "Café"};
    double[] catalogoPrecios = {2.50, 4.20, 3.80, 1.50, 7.00};

    String[] carritoNombres = new String[5];
    int[] carritoCantidades = new int[5];
    double[] carritoSubtotales = new double[5];

    int cantidadProductosEnCarrito = 0;
    int opcion;

    System.out.println("=== BIENVENIDO A LA TIENDA ===");

    do {
        System.out.println("--- MENÚ PRINCIPAL ---");
        System.out.println("1.- Mostrar catálogo de productos");
        System.out.println("2.- Agregar producto al carrito");
        System.out.println("3.- Mostrar carrito de compras");
        System.out.println("4.- Obtener factura y salir");
        System.out.println("5.- Salir");
        System.out.print("Seleccione una opción: ");

        opcion = fran.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("--- CATÁLOGO DE PRODUCTOS ---");
                for (int i = 0; i < catalogoNombres.length; i++) {
                    System.out.println((i + 1) + ". " + catalogoNombres[i] + " - S/ " + catalogoPrecios[i]);
                }
                break;

            case 2:
                if (cantidadProductosEnCarrito >= 5) {
                    System.out.println("El carrito está lleno (máximo 5 productos diferentes).");
                    break;
                }

                System.out.println("--- CATALOGO ---");
                for (int i = 0; i < catalogoNombres.length; i++) {
                    System.out.println((i + 1) + ". " + catalogoNombres[i] + " - S/ " + catalogoPrecios[i]);
                }

                System.out.print("Elija el número del producto que desea agregar: ");
                int seleccion = fran.nextInt();

                if (seleccion >= 1 && seleccion <= catalogoNombres.length) {
                    int index = seleccion - 1;
                    System.out.print("Ingrese la cantidad que desea llevar de " + catalogoNombres[index] + ": ");
                    int cantComprada = fran.nextInt();

                    carritoNombres[cantidadProductosEnCarrito] = catalogoNombres[index];
                    carritoCantidades[cantidadProductosEnCarrito] = cantComprada;
                    carritoSubtotales[cantidadProductosEnCarrito] = catalogoPrecios[index] * cantComprada;

                    cantidadProductosEnCarrito++;
                    System.out.println("Producto agregado con éxito al carrito!");
                } else {
                    System.out.println("Opción de producto inválida.");
                }
                break;

            case 3:
                System.out.println("--- CONTENIDO DEL CARRITO ---");
                if (cantidadProductosEnCarrito == 0) {
                    System.out.println("El carrito está vacío.");
                } else {
                    double totalParcial = 0;
                    for (int i = 0; i < cantidadProductosEnCarrito; i++) {
                        System.out.println("- " + carritoNombres[i] + " | Cantidad: " + carritoCantidades[i] + " | Subtotal: S/ " + carritoSubtotales[i]);
                        totalParcial += carritoSubtotales[i];
                    }
                    System.out.println("Total parcial acumulado: S/ " + totalParcial);
                }
                break;

            case 4:
                System.out.println("=================================");
                System.out.println("          FACTURA DE VENTA       ");
                System.out.println("=================================");
                if (cantidadProductosEnCarrito == 0) {
                    System.out.println("No se realizaron compras.");
                } else {
                    double totalFinal = 0;
                    System.out.println("Cant. \tProducto \tSubtotal");
                    System.out.println("---------------------------------");
                    for (int i = 0; i < cantidadProductosEnCarrito; i++) {
                        System.out.println(carritoCantidades[i] + ":" + carritoNombres[i] + ".S/ " + carritoSubtotales[i]);
                        totalFinal += carritoSubtotales[i];
                    }
                    System.out.println("---------------------------------");
                    System.out.println("TOTAL A PAGAR: S/ " + totalFinal);
                    System.out.println("=================================");
                    System.out.println("¡Gracias por su compra!");
                }
                break;

            case 5:
                System.out.println("Gracias por visitar la tienda. ¡Hasta luego!");
                break;

            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }

    } while (opcion != 4 && opcion != 5);


}
