import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class GestionFiguras {
    private static Figura figuraActual;
    private static boolean figuraValida;
    private static Scanner leer;

    public static void main(String[] args) throws Exception {
        try {
         System.setOut(new PrintStream(System.out, true, "UTF-8"));
         leer = new Scanner(System.in, "UTF-8");
        } catch (UnsupportedEncodingException ex) {}

        int opcion;
        
        do {
            mostrarMenu();
            opcion = leer.nextInt();
            switch (opcion) {
                case 1 -> determinarFigura();
                case 2 -> calcularArea();
                case 3 -> System.out.println("**Saliendo...");
                default -> System.out.println("**Opción inválida\n");
            }
        } while (opcion != 3);

        leer.close();
    }

    public static void determinarFigura() {
        figuraActual = new Figura();

        System.out.print("Ingrese el valor del numero A: ");
        figuraActual.setNumeroA(leer.nextInt());
        System.out.print("Ingrese el valor del numero B: ");
        figuraActual.setNumeroB(leer.nextInt());
        System.out.print("Ingrese el valor del numero C: ");
        figuraActual.setNumeroC(leer.nextInt());

        System.out.println(figuraActual.detectarFigura());
        if (figuraActual.getTipoFigura() != null) {
            figuraValida = true;
        }
    }

    public static void calcularArea() {
        if (figuraActual == null) {
            System.out.println("Primero ingrese los datos de una figura:");
            determinarFigura();
        }

        if (figuraActual.getTipoFigura() == null) {
            if (figuraValida) {
                System.out.println("No se conservan los datos de la figura anterior. Se solicita determinar una figura");
            } else {
                System.out.println("Ingrese una figura válida");
            }
            return;
        }

        System.out.println("El área del " + figuraActual.getTipoFigura() + " es: " + figuraActual.calcularArea());
    }

    public static void mostrarMenu() {
        String menu = """
                ---PSP 2---

                1.- Determinar figura
                2.- Calcular Area
                3.- Salir

                Seleccione una opción:
                """;
        System.out.println(menu);
    }
}
