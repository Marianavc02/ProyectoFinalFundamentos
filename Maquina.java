import java.util.ArrayList;
import java.util.Random;

public class Maquina extends Jugador{
    private String nombre; 
    private ArrayList<Integer> numerosUsados;

    
    
    public Maquina(){
        super("Pixelito");
        this.numerosUsados=new ArrayList<>();
    }
    
    
    public int[] generarDosNumerosAleatorios(int tamanio) {
        Random random = new Random();
        int[] numerosAleatorios = new int[2];
        do{
        numerosAleatorios[0] = random.nextInt(tamanio*tamanio); // Puedes ajustar el rango según tus necesidades
        numerosAleatorios[1] = random.nextInt(tamanio*tamanio);
        }while(this.numerosUsados.contains(numerosAleatorios[0])||this.numerosUsados.contains(numerosAleatorios[1])); 
        return numerosAleatorios;
    }

    public void numerosJ1 (int num1){
        numerosUsados.add(num1);
    }
}
