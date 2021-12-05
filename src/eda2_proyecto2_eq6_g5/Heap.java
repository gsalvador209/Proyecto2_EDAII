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
     
     
    private int Padre(int i){
        return (i-1)/2;
    }
     
    private int Hijo(int i,int k){
        return 2*i  +k;
    }
     
    public void InsertarElem(int x){
        if(isFull())
            throw new NoSuchElementException("No se pueden insertar más datos al heap, esta lleno :(");
        heap[heapSize++] = x;
        HeapifyArriba(heapSize-1);
    }
     
    private int Eliminar(int x){
        if(isEmpty())
            throw new NoSuchElementException("No puedes eliminar ningún elemento porque esta vacío :0");
        int key = heap[x];
        heap[x] = heap[heapSize -1];
        heapSize--;
        HeapifyAbajo(x);
        return key;
    }
 
    private void HeapifyArriba(int i) {
        int temp = heap[i];
        while(i>0 && temp > heap[Padre(i)]){
            heap[i] = heap[Padre(i)];
            i = Padre(i);
        }
        heap[i] = temp;
    }
     
    private void HeapifyAbajo(int i){
        int child;
        int temp = heap[i];
        while(Hijo(i, 1) < heapSize){
            child = maxChild(i);
            if(temp < heap[child]){ heap[i] = heap[child]; }else break; i = child; } heap[i] = temp; } private int maxChild(int i) { int leftChild = Hijo(i, 1); int rightChild = Hijo(i, 2);
                return heap[leftChild]>heap[rightChild]?leftChild:rightChild;
    }
     
    public void ImprimeHeap(){ //Imprime el heap
            System.out.print("nHeap = ");
            for (int i = 0; i < heapSize; i++)
                System.out.print(heap[i] +" ");
            System.out.println();
        }
    
    /*private int EncuentraGrandulon(){ //Encuentra el valor máxímo del heap, en este caso es el primer elemento
        if(isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return heap[0];
    }*/

    private int BusquedaClav(int VBuscado){
        int i;
        for (i=0;i<heap.length;i++){
            if(VBuscado==heap[i]){
           return i;
           }
       }
       return -1;
    }
      
    public void FunEliminar(){
        int clave,res;
        System.out.println("Ingresa la clave que deseas eliminar\n");
        System.out.print(">>> ");
        clave=scan.nextInt();

        res=BusquedaClav(clave);

        if (res==-1){
            System.out.println("Lo siento, la clave ingresada no existe o.o ");
        }else{
            
        System.out.println("Heap anterior: ");
        ImprimeHeap();

        Eliminar(res);
        
        System.out.println("Heap actualizado: ");
        ImprimeHeap();

        System.out.println(" - -La clave ha sido eliminada con éxito ;) - -");
        }
    }
     
}

