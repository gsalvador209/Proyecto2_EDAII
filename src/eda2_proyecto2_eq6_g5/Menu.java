package eda2_proyecto2_eq6_g5;

import java.util.EmptyStackException;
import java.util.Scanner;


/**
 *
 * @author Salvador Chavez
 */
public class Menu {
    String[] opciones;
    
    
    Menu(String opcs){
        opciones = opcs.split(",");
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
     * Este método verica que la entrada ingresada por el usuario sea un número 
     * y que además cumpla con una condición. Si no la cumple y la opción ingre-
     * sada no se encuentra dentro de las excepciones, entonces imprime un
     * mensaje que no se está cumpliendo la condición
     * @param bloqueo Mensaje de qué condición se debe cumplir
     * @param condición Condición necesaria para que no hya un bloqueo
     * @param excepciones Excepciones a la condición, números separados por ","
     * @return
     */
    public int solicitarOpcion(String bloqueo, boolean condición, String excepciones){
        int opc;
        boolean salida = false;
        Scanner scan = new Scanner(System.in);
        String [] ex = excepciones.split(",");
        do{
          System.out.println("Ingrese la opción deseada."); 
          opc = scan.nextInt();
          scan.nextLine();
          if(!condición){
              for(String e : ex){
                  //System.out.println("Excepcion: "+ e);
                  if(e.equals(Integer.toString(opc))){
                      salida = true;
                  }
              }
              if(salida){
                  break;
              }else{
                  System.err.println(bloqueo);
                  return -1;
              } 
          }
          if(0 < opc && opc <= opciones.length)
              break;
          else
              System.out.println("Esa opcion no existe en el menú.");
        }while(true);
        return opc; 
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
    
    public String getExpresion(){
        ArbolesArit test = new ArbolesArit();
        Scanner sc = new Scanner(System.in);
        String exp = "";
        while (true) {
            System.out.println("Ingresa la expresión matemática.");
            exp = sc.nextLine();
            if (!"".equals(exp)) {
                break;
            }
        }
        exp =  exp.replace(' ','\0');
        
        
        try{
            test.generarArbol(exp);
            System.out.println("Árbol generado correctamente");
            //test.BFS(false);
        }catch(EmptyStackException e){
            System.err.println("Error de sintaxis.");
            exp = "";
        }
        
        //System.out.println(exp);
       return exp;
    }
    
}
