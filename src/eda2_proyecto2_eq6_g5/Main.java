package eda2_proyecto2_eq6_g5;

/**
 *
 * @author Salvador Chavez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //ArbolesArit exp = new ArbolesArit();
        int Tam=0;
        int n = 100;
        
        //ArrayList<Integer> list = new ArrayList<>();

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
        
       
        /*exp.generarArbol("((8+3)+(4-3))/(2-5)");
        exp.inOrden(exp.root);
        System.out.println('\n' + exp.getPolish());
        System.out.println("El resultado es: " + exp.solveTree());
        
        
        exp.generarArbol("((2+5)-3/(5+8))*2");
        exp.inOrden(exp.root);
        System.out.println('\n'+exp.getPolish());
        System.out.println("El resultado es: " + exp.solveTree());*/
        
        
    }
    
}
