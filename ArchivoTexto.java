import java.io.*;
public class ArchivoTexto {
    public void escribirMatrizArchivo(String[][] mat, String filename) {
        FileWriter archivo = null;
        BufferedWriter flujo = null;
        PrintWriter salida = null;
        try {
            //archivo = new FileWriter(filename,true); // true para adicionar al final del archivo
            archivo = new FileWriter(filename,false); // false para sobreescribir el archivo.
            flujo = new BufferedWriter(archivo);
            salida = new PrintWriter(flujo);
          for(int j=0;j<mat[0].length;j++){
            for(int i=0;i<mat.length;i++){    
                salida.print(mat[i][j]+",");
            }
            salida.println();
          }
            salida.flush();    
        } catch (Exception e) {
            System.err.println("error escribiendo el archivo: "+e.getMessage());
        }
    }
    public char[][] leerMatrizDeArchivo(String filename) {
        char[][] mat = null; // todavia no se de que tamaño la voy a crear
        FileReader archivo = null;
        BufferedReader flujo = null;
        String linea = null;
        String[] elementos = null;

        try {
            archivo = new FileReader(filename);
            flujo = new BufferedReader(archivo);
            linea = flujo.readLine();
            while (linea!=null) {
                elementos = linea.split(",");
                if(mat==null)
                    mat =new char[elementos.length][elementos.length];
                linea = flujo.readLine();
                    for (String elem : elementos) {
                    System.out.print(elem+" ");
                }
                System.out.println("");
            }
        } catch (Exception e) {
            System.err.println("error leyendo archivo: "+e.getMessage());
        }
        return mat;
    }
    
}