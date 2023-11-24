import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables para el juego
        String[][] matriz = null;
        int tamano = 0;
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        boolean generarNuevaMatriz = false;

        // Menú principal
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Elegir tamaño de la matriz");
            System.out.println("2. Generar matriz aleatoria");
            System.out.println("3. Cargar matriz de archivo");
            System.out.println("4. Jugar con una persona");
            System.out.println("5. Jugar con maquina");
            System.out.println("6. Salir");
            System.out.print("Ingrese el número de la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tamaño que sea 5, 7 u 9:");
                    tamano = scanner.nextInt();
                     while (tamano != 5 && tamano != 7 && tamano != 9) {
                        System.out.println("Por favor, ingrese un tamaño válido (5, 7 u 9):");
                        tamano = scanner.nextInt();
                    }
                    break;
                case 2:
                    matriz=Micelaneo.listaAmatriz(tamano);
                    Micelaneo.escribirMatrizArchivo(matriz, tamano);
                    break;
                case 3:
                    matriz=Micelaneo.leerMatrizDeArchivo(tamano);           
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de jugador 1:");
                    jugador1.setNombre(scanner.next());
                    System.out.println("Ingrese el nombre de jugador 2:");
                    jugador2.setNombre(scanner.next());
                    Juego juego = new Juego(tamano,jugador1,jugador2,matriz); 
                    juego.imprimirTablero();
                    juego.imprimirTableroNum();
                    juego.ejecutarJuego();
                    break;
                case 5:
                    System.out.println("Ingrese el nombre de jugador 1:");
                    jugador1.setNombre(scanner.next());

                    Juego juegoMaquina = new Juego(tamano,jugador1,matriz);
                    juegoMaquina.imprimirTablero();
                    juegoMaquina.imprimirTableroNum();
                    juegoMaquina.ejecutarJuegoMaquina();
                    break;
                case 6:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }

            System.out.println();

        } while (opcion != 6);

        scanner.close();
    }
}
