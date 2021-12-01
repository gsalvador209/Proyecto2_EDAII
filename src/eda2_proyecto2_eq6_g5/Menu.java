package eda2_proyecto2_eq6_g5;

import java.util.Scanner;

/**
 *
 * @author Salvador Chavez
 */
public class Menu {
    String[] opciones;
    
    
    Menu(String[] options){
        opciones = options;
    }
    
    /**
     *Imprime el menú
     */
    public void imprimirMenu(){
        for(int i =0; i < opciones.length; i++){
            System.out.format("%d.- %s\n",i+1,opciones[i]);
        }
    }
    
    /**
     * Solicita al usuario ingresar una opción hasta que el usuario ingrese una 
     * disponible dentro del menú
     * @return El número de opcion
     */
    public int solicitarOpcion(){
        int opc;
        Scanner scan = new Scanner(System.in);
        do{
          System.out.println("Ingrese la opción deseada."); 
          opc = scan.nextInt();
          scan.nextLine();
          if(0 < opc && opc <= opciones.length)
              break;
          else
              System.out.println("Esa opcion no existe en el menú.");
        }while(true);
        return opc;  
    }
    
    /**
     * Suspende el programa hasta que el usuario presione Enter
     */
    public void pause(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
