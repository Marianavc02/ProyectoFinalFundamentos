import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
public class Juego{
  private String[][]matrizExterna;
  private String[][]matrizInterna;
  private int pareja;
  private Jugador jugador1;
  private Jugador jugador2;
  private int tam;
  
   
  public Juego(int tam, Jugador jugador1, Jugador jugador2) {
    this.matrizInterna=listaAmatriz(tam);
    this.matrizExterna=matNumeros(tam);
    this.pareja=((tam*tam)-1)/2;
    this.jugador1=jugador1;
    this.jugador2=jugador2;
    this.tam=tam;
   }
   
   public String generarletra(){
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


  public ArrayList<String> generarLetras(int num){
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
  public ArrayList<String> desordenar(ArrayList<String> listaordenada){
    ArrayList<String> listaDesordenada= new ArrayList<>(listaordenada);
    
    Collections.shuffle(listaDesordenada);
    return listaDesordenada;
  }
  public String[][]listaAmatriz(int tamanio){
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
  public String[][] matNumeros(int tamanio){
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
  public void imprimirTableroNum(){
    int tam = this.matrizExterna.length;
    for(int fila=0;fila < tam ; fila++){
      for (int columna=0;columna < tam ;columna++){
        System.out.print(this.matrizExterna[fila][columna]+",");
      } 
      System.out.println("");
    }
  }
  public void imprimirTablero(){
    int tam = this.matrizInterna.length;
    for(int fila=0;fila < tam ; fila++){
      for (int columna=0;columna < tam ;columna++){
        System.out.print(this.matrizInterna[fila][columna]+",");
      } 
      System.out.println("");
    }
  }
  public int[] buscarCoordenadas(int numero){
    int[] coordenadas= new int[2];
    for (int i =0;i<this.tam;i++){
      for(int j =0;j< this.tam;j++){
        if((this.tam*i)+j+1==numero){
          coordenadas[0]=i;
          coordenadas[1]=j;
        }
      }
    }
    return coordenadas;
  }

  public void ejecutarJuego(){
    int turno=1;
    boolean acierto;
    while (this.pareja>0 && calcularPuntaje()) {
     if(turno%2==0){
      System.out.println("es el turno de: "+this.jugador1.getNombre());
      acierto = seleccionYverifica();
      if(acierto){
        this.jugador1.setPuntaje(this.jugador1.getPuntaje()+1);
      }
     }else{
      System.out.println("es el turno de: "+this.jugador2.getNombre());
      acierto = seleccionYverifica();
      if(acierto){
        this.jugador2.setPuntaje(this.jugador2.getPuntaje()+1);
      }
     }
     turno++;
      System.out.println("el puntaje es:"+"jugador1:"+this.jugador1.getPuntaje()+"jugador2:"+this.jugador2.getPuntaje());
    }
  }

  public boolean seleccionYverifica(){
    Scanner teclado= new Scanner(System.in);
    System.out.println("ingrese el número que desea girar ");
     int cartaNum= teclado.nextInt();
     int[] coordenada1=buscarCoordenadas(cartaNum);
     System.out.println("ingrese el número que desea girar ");
     cartaNum= teclado.nextInt();
     int[] coordenada2=buscarCoordenadas(cartaNum);
     return girarCartas(coordenada1, coordenada2);

  }

  public boolean girarCartas(int[]cor1,int[]cor2){
    int fila1 = cor1[0];
    int columna1 = cor1[1];
    String valor1=this.matrizInterna[fila1][columna1];
    int fila2 = cor2[0];
    int columna2 = cor2[1];
    String valor2=this.matrizInterna[fila2][columna2];

    String aux1=this.matrizExterna[fila1][columna1];
    String aux2=this.matrizExterna[fila2][columna2];
    this.matrizExterna[fila1][columna1]=valor1;
    this.matrizExterna[fila2][columna2]=valor2;
    imprimirTableroNum();
    if(valor1=="*"){
        this.matrizExterna[fila2][columna2]=aux2;
        return true;
    }else{
       if(valor2=="*"){
        this.matrizExterna[fila1][columna1]=aux1;
        return true;
      }else{
       if(valor1==valor2){
        return true;
        }else{
        this.matrizExterna[fila1][columna1]=aux1;
        this.matrizExterna[fila2][columna2]=aux2;
        return false;
        }
      }
    }

  }

  public boolean calcularPuntaje(){
    if(this.jugador1.getPuntaje()==(this.pareja/2)+1||this.jugador2.getPuntaje()==(this.pareja/2)+1){
      return false;
    }
    return true;
  }
   
}