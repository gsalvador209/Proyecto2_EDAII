package eda2_proyecto2_eq6_g5;
import java.net.DatagramSocket;
import java.util.ArrayList;

/**
 *
 * @author Salvador Chavez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Pruebas de heap 
        Heap heap = new Heap();
        ArrayList<Integer> datos = new ArrayList<Integer>();
        int tam;
        
        datos.add(1);
        datos.add(5);
        datos.add(2);
        datos.add(8);
        datos.add(13);
        /*datos.add(4);
        datos.add(9);
        datos.add(3);
        datos.add(6);
        datos.add(20);
        datos.add(15);
        datos.add(18);
        datos.add(12);
        datos.add(7);*/
        datos.add(10);
        datos.add(11);
        datos.add(19);
        datos.add(17);
        datos.add(16);
        datos.add(14);

        System.out.println("Pruebas de Heap: ");

        System.out.println("Heap :)");
        System.out.println("Aquí va el heap");
        
        tam=datos.size();

        System.out.println("Imprimo arreglo antes de construir el heap: ");
        heap.ImprimeArray(datos,tam);

        heap.ConstruyeHeap(datos, tam);
        System.out.println("Imprimo arreglo: ");
        heap.ImprimeArray(datos,tam);

        /*System.out.println("Imprimo sub-arreglo: ");
        heap.ImprimeSubArray(datos, 0, tam-1);*/

        System.out.println("La ultima prueba");

        
    }
    
}
