public class Jugador{
   protected String nombre;
   protected int puntaje;
   
   public Jugador(){
      nombre="";
      puntaje=0;
   }

   public Jugador(String nombre){
      this.nombre=nombre;
      this.puntaje=0;

   }

   public String getNombre(){
      return nombre;
   }

   public void setNombre(String nombre){
      this.nombre=nombre;
   }

   public int getPuntaje(){
      return puntaje;
   }
   public void setPuntaje(int puntaje){
      this.puntaje=puntaje;
   }
   
}
