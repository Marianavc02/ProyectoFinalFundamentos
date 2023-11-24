import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class Micelaneo {
    static void escribirMatrizArchivo(String[][] mat, int tamanio) {
        FileWriter archivo = null;
        BufferedWriter flujo = null;
        PrintWriter salida = null;
        String filename="";
        try {
            switch (tamanio) {
                case 5:
                    filename = "tablero1.txt";
                    break;
                case 7:
                    filename= "tablero2.txt";
                    break;
                case 9:
                 filename= "tablero3.txt";
                    break;
            }
            archivo = new FileWriter(filename,false); // false para sobreescribir el archivo.
            flujo = new BufferedWriter(archivo);
            salida = new PrintWriter(flujo);
          for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){    
                salida.print(mat[i][j]+",");
            }
            salida.println();
          }
            salida.flush();    
        } catch (Exception e) {
            System.err.println("error escribiendo el archivo: "+e.getMessage());
        }
    }
    static String[][] leerMatrizDeArchivo(int opcion) {
    String[][] mat = null; // todavía no sé de qué tamaño la voy a crear
    FileReader archivo = null;
    BufferedReader flujo = null;
    String linea = null;
    String[] elementos = null;
    String filename = "";

    try {
        switch (opcion) {
            case 5:
                filename = "tablero1.txt";
                break;
            case 7:
                filename = "tablero2.txt";
                break;
            case 9:
                filename = "tablero3.txt";
                break;
        }

        archivo = new FileReader(filename);
        flujo = new BufferedReader(archivo);
        int fila = 0; // contador de filas

        // Lee cada línea del archivo
        while ((linea = flujo.readLine()) != null) {
            elementos = linea.split(",");
            
            // Si la matriz aún no ha sido creada, inicialízala
            if (mat == null) {
                mat = new String[elementos.length][elementos.length];
            }

            // Llena la matriz con los elementos de la línea actual
            for (int i = 0; i < elementos.length; i++) {
                mat[fila][i] = elementos[i];
            }

            fila++; // Incrementa el contador de filas
        }
    } catch (Exception e) {
        System.err.println("Error leyendo archivo: " + e.getMessage());
    } finally {
        try {
            if (flujo != null) {
                flujo.close();
            }
            if (archivo != null) {
                archivo.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    return mat;
    }
 private static String generarletra(){
    Random random= new Random();
    char letra;
    //unicode A (65) Z(90) y a (97) a z (122)
      if(random.nextBoolean()){
      letra=(char)(random.nextInt(26)+'A');
    
      }else{
      letra=(char)(random.nextInt(26)+'a');
    }
    return String.valueOf(letra);
  }


  private static ArrayList<String> generarLetras(int num){
    ArrayList<String> resultado= new ArrayList<>();
    Set<String> letrasGeneradas= new HashSet<>();
    Random random = new Random();

    while (resultado.size()<num){
      String letraAleatoria = generarletra();
      if(letrasGeneradas.add(letraAleatoria)){
        resultado.add(letraAleatoria);
      }
    }
    ArrayList<String> resultadoDuplicado= new ArrayList<>();
    resultadoDuplicado.addAll(resultado);
    resultadoDuplicado.add("*");
    resultadoDuplicado.addAll(resultado);
    return resultadoDuplicado;
  }
  private static ArrayList<String> desordenar(ArrayList<String> listaordenada){
    ArrayList<String> listaDesordenada= new ArrayList<>(listaordenada);
    
    Collections.shuffle(listaDesordenada);
    return listaDesordenada;
  }
  static String[][]listaAmatriz(int tamanio){
    ArrayList<String> lista=generarLetras(tamanio*tamanio/2);
    lista=desordenar(lista);
    String[][] matriz= new String[tamanio][tamanio];
    int indice=0;
    for(int fila=0;fila < tamanio ; fila++){
       for (int columna=0;columna < tamanio ;columna++){
         matriz[fila][columna]=lista.get(indice);
         indice++;
      }
    }
    return matriz;
  }
  static String[][] matNumeros(int tamanio){
      String [][]tablero=new String[tamanio][tamanio];
      int i=1;
      for(int fila=0; fila<tablero[0].length;fila++){
          for(int columna=0; columna<tablero.length;columna++){
              tablero[fila][columna]=String.valueOf(i);
              i++;
          }
      }
      return tablero;
  }
}