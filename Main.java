import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

public class Main {
  public static void main(String[] args) {
    Scanner teclado= new Scanner (System.in);
    System.out.println("ingrese el tamaño");
    int tam =teclado.nextInt();
    Jugador j1=new Jugador("juan");
    Jugador j2=new Jugador("alexa");
    Juego juego = new Juego(tam,j1,j2);
    juego.imprimirTablero();
    juego.imprimirTableroNum();
    juego.ejecutarJuego();
    

    // ArchivoTexto ppal = new ArchivoTexto();
    // ppal.escribirMatrizArchivo(tablero,"tablero1.txt");
    //mat = ppal.leerMatrizDeArchivo("tablero2.txt");
    //mat = ppal.leerMatrizDeArchivo("tablero1.txt");
  }
}