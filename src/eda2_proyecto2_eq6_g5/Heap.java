package eda2_proyecto2_eq6_g5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * @author Vanessa Nava
 */

// En esta clase esta implementado el heap donde:
// se agregauna clave, se elimina una clave y muestra el árbol binario Heap:) 

public class Heap{
    

//  Atributos   //

    private int[] heap;
    Scanner scan = new Scanner(System.in);
    private int heapSize;
     
//  Constructor //

    public Heap(int tam){
        heapSize = 0;
        heap = new int[ tam+1];
        Arrays.fill(heap, -1);
    }
     
//  Métodos   //

    public boolean isEmpty(){
        return heapSize==0; // Se revisa que no este vacío
    }
     
    private boolean isFull(){ 
        return heapSize == heap.length; //Se revisa que no este lleno
    }
     
     
    private int Padre(int i){  // Se establecen las condiciones que debe de cumplir el nodo padre 
        return (i-1)/2;
    }
     
    private int Hijo(int i,int k){ // Se establecen las condiciones que deben de cumplir los nodos hijos 
        return 2*i  +k;
    }
     
    public void InsertarElem(int x){ // Función en la que se debe insertar los elementos
        if(isFull())
            throw new NoSuchElementException("No se pueden insertar más datos al heap, esta lleno :("); // En caso de que se exceda el límite
        heap[heapSize++] = x;
        HeapifyArriba(heapSize-1); //Se utiliza el heapify para hacer la magia del heap 
    }
     
    private int Eliminar(int x){ // Función en la que se eliminan los elementos 
        if(isEmpty())
            throw new NoSuchElementException("No puedes eliminar ningún elemento porque esta vacío :0"); // En caso de que este vacío el arreglo de datos
        int key = heap[x];
        heap[x] = heap[heapSize -1];
        heapSize--;
        HeapifyAbajo(x); // Se utiliza para mantener el orden del heap y se revisa hacia abajo del heap 
        return key;
    }
 
    private void HeapifyArriba(int i) { // Funcion que hace la magia del heap (mantiene las condiciones del heap en forma up)
        int temp = heap[i];
        while(i>0 && temp > heap[Padre(i)]){
            heap[i] = heap[Padre(i)];
            i = Padre(i);
        }
        heap[i] = temp;
    }
     
    private void HeapifyAbajo(int i){ // Funcion que hace la magia del heap (mantiene las condiciones del heap en froma down)
        int child;
        int temp = heap[i];
        while(Hijo(i, 1) < heapSize){
            child = maxChild(i);
            if(temp < heap[child]){ heap[i] = heap[child]; }else break; i = child; } heap[i] = temp; } private int maxChild(int i) { int leftChild = Hijo(i, 1); int rightChild = Hijo(i, 2); return heap[leftChild]>heap[rightChild]?leftChild:rightChild;
    }

    public void ImprimeHeap(){ //Imprime el heap
            System.out.print("nHeap = ");
            for (int i = 0; i < heapSize; i++)
                System.out.print(heap[i] +" ");
            System.out.println();
        }
    
    private int BusquedaClav(int VBuscado){ // Busco la clave proporcionada por el usuario para buscarlo en el arreglo de datos del heap (se utilizó Búsqueda Binaria y es un método auxiliar para el método Eliminar)
        int i;
        for (i=0;i<heap.length;i++){
            if(VBuscado==heap[i]){
           return i;
           }
       }
       return -1;
    }
      
    public void FunEliminar(){ // Es la función que se llamará en el main para poder eliminar la clave, 
        int clave,res;
        System.out.println("Ingresa la clave que deseas eliminar\n");
        System.out.print(">>> ");
        clave=scan.nextInt();

        res=BusquedaClav(clave);

        if (res==-1){ // Si el resultado del método auxiliar regresa un -1 es que no se encuentra el elemento buscado en el arreglo
            System.out.println("Lo siento, la clave ingresada no existe o.o ");
        }else{
            
        System.out.println("Heap anterior: ");
        ImprimeHeap();

        Eliminar(res); //En caso de que sí se encuentre se elimina y se imprime el heap anterior y el actualizado al usuario para que revise los cambios correctamente 
        
        System.out.println("Heap actualizado: ");
        ImprimeHeap();

        System.out.println(" - -La clave ha sido eliminada con éxito ;) - -");
        }
    }

    public void FunBuscar(){ // Se agregó un método extra para hacer la búsqueda de una clave en el heap
        int temp;
        int clave,res;
        System.out.println("Ingresa la clave que deseas buscar\n");
        System.out.print(">>> ");
        clave=scan.nextInt();

        res=BusquedaClav(clave);

        if (res==-1){ 
            System.out.println("Lo siento, la clave ingresada no existe o.o ");
        }else{ 
            //Se imprime la ubicación del nodo y el contenido del nodo 
            System.out.println("La clave ingresada se encontró exitosamente :) ");
            temp=heap[res];
            System.out.println("la clave es : "+temp);
            System.out.println("encontrada en el nodo : "+res);
        }
    }
     
}

