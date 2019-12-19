public class contadorjava {
    
   String name;
   int numeroAtual = 0;
   
   public contadorjava(String name){
       this.name = name;
   }
   public void contar(){
       numeroAtual++;
   }
   public String toString(){
       return name + " = " + numeroAtual;
   }
}
