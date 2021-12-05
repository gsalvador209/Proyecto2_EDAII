package eda2_proyecto2_eq6_g5;

import java.util.Scanner;

/*
 * @author Salvador Chavez
 * @author Vanessa Nava
 * @author Yaxca Quero 
 * Esta clase contiene el menú principal del programa
 * con las opciones necesarias de los submenú
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //**********MENÚS************

        Menu raiz = new Menu("Árbol AVL,Heap,Árbol de Expresión Aritmética,Salir");
        Menu avl = new Menu("Agregar clave,Buscar un valor,Eliminar Clave,Mostrar Árbol,Regresar");
        Menu heap = new Menu("Agregar clave,Eliminar raíz,Mostrar Árbol,Regresar");
        Menu arit = new Menu("Ingresar expresión,Mostrar Árbol,Resolver,Regresar");
        
        //***********ÁRBOLES**********
        ArbolesArit exp = new ArbolesArit();
        ArbolAVL arbolAVL = new ArbolAVL();
        
        //***********AUXILIARES***********
        Scanner scan = new Scanner(System.in);
      
        //**********CÓDIGO PRINCIPAL******
        int opc;
        String expresión = "";
        while(true){
            raiz.imprimirMenu();
            opc = raiz.solicitarOpcion();
            switch (opc) {
                case 1:
                    //AVL
                    while(true){
                        int valorAVL;
                        avl.imprimirMenu();
                        opc = avl.solicitarOpcion("Primero debes crear un árbol", arbolAVL.root!= null, "1,5"); 
                        if(opc== -1)
                            continue;                                                                            
                        if(opc == 1){
                            //Agregar clave
                            System.out.print("Ingresa el valor de la nueva clave:");
                            valorAVL = scan.nextInt();
                            if(arbolAVL.contains(valorAVL)){
                                System.err.println("Este valor ya está en el árbol");
                            }else{
                                Nodo nuevoNodo = new Nodo(valorAVL); 
                                arbolAVL.root= arbolAVL.agrega(arbolAVL.root, nuevoNodo, valorAVL);
                            }
                        }else if(opc==2){
                            //Buscar
                            System.out.print("Ingresa el valor a buscar:");
                            valorAVL = scan.nextInt();
                            Nodo buscaNodo = new Nodo(valorAVL);       
                            boolean existe=arbolAVL.contains(buscaNodo);
                            if(existe==true){
                                System.out.println("La clave "+valorAVL+" se encuentra en el árbol");
                            }else{
                                System.out.println("La clave "+valorAVL+" no existe");
                            }      
                        }else if(opc==3){
                            //Eliminar
                            System.out.print("Ingresa la clave a eliminar:");
                            valorAVL = scan.nextInt();
                            Nodo nodoEliminar = arbolAVL.getNodo(valorAVL);
                            if(nodoEliminar==null)
                                System.out.println("\nLa clave ingresada no existe para eliminarse");
                            else{
                                arbolAVL.delete(nodoEliminar);
                                System.out.println("\nClave eliminada con éxito:)\n");
                            }                     
                        }else if(opc==4){
                            //Mostrar
                            System.out.print("El arbol recorrido en BFS es ");
                            arbolAVL.BFS(true);
                            System.out.println();                                
                        }else{
                            //Regresar al menu principal
                            break;
                        }
                    }
                    break;
                case 2:
                    //HEAP
                    while(true){
                        heap.imprimirMenu();
                        opc = heap.solicitarOpcion("Primero debes crear el arbol", false, "1,4"); //TO-DO INGRESAR CONDICIÓN
                                                                                                   //Por ejemplo root != null; 
                        if(opc== -1)
                            continue;
                        if(opc == 1){
                            //Agregar clave
                            
                        }else if(opc==2){
                            //Eliminar
                            
                        }else if(opc==3){
                            //Mostrar  
                            
                        }else {
                            //Regresar al menu principal
                            break;
                        }
                    }
                    break;
                case 3:
                    //ARIT
                    while(true){
                        arit.imprimirMenu();
                        opc = arit.solicitarOpcion("Primero debes ingresar una expresión", !"".equals(expresión), "1,4");
                        if(opc==-1)
                            continue;
                        if(opc == 1){                                           //Ingresar expresión
                            expresión = arit.getExpresion();
                            exp.generarArbol(expresión);
                        }else if(opc==2){                                       //Mostrar arbol
                            
                            System.out.print("El arbol recorrido en BFS es ");
                            exp.BFS(true);
                            System.out.println();
                            System.out.print("Su notación polaca es: ");
                            exp.posOrden(exp.root);
                            System.out.println();
                        }else if(opc==3){                                       //Resolver
                            System.out.println("El resultado de la expresión es: " + exp.solveTree()+"\n");
                        }else {                                                 //Regresar al menu principal
                            break;
                        }
                    }
                    break;
                default:
                    //Salir
                    return;
            }
        }  
    }
    
}
