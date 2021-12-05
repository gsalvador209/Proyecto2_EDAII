package eda2_proyecto2_eq6_g5;

/**
 *Vane-)
 * @author Salvador Chavez
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
                        avl.imprimirMenu();
                        opc = avl.solicitarOpcion("Primero debes crear un árbol",false, "1,5"); //TO-DO INGRESAR CONDICIÓN
                        if(opc== -1)
                            continue;                                                                         //Por ejemplo root != null;   
                       
                        if(opc == 1){
                            //Agregar clave
                        }else if(opc==2){
                            //Buscar
                        }else if(opc==3){
                            //Eliminar
                        }else if(opc==4){
                            //Mostrar
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
/*
        //Pruebas de heap 
        Heap heap = new Heap(n);
        
        Nodo n1 = new Nodo(3);
        Tam++;
        heap.insert(n1.valor);

        Nodo n2 = new Nodo(8);
        Tam++;
        heap.insert(n2.valor);

        Nodo n3 = new Nodo(10);
        Tam++;
        heap.insert(n3.valor);
        
        
        heap.insert(8);
        Tam++;
        heap.insert(13);
        Tam++;
        heap.insert(10);
        Tam++;
        heap.insert(11);
        Tam++;
        heap.insert(19);
        Tam++;
        heap.insert(17);
        Tam++;
        heap.insert(16);
        Tam++;
        heap.insert(14);
        Tam++;
        

        System.out.println(Tam);
        

        heap.ImprimeHeap();
        heap.Elimina(1);
        heap.ImprimeHeap();
        heap.Elimina(8);
        heap.ImprimeHeap();
    
               
        System.out.println("La ultima prueba");
