package eda2_proyecto2_eq6_g5;

import java.util.Arrays;
import java.util.NoSuchElementException;

// Nava Alberto Vanessa 

// en esta clase esta implementado el heap donde:
// se agregauna clave, se elimina una clave y muestra el árbol

public class Heap{

    //  Atributos   //
    private int[] heap;
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
     
    public boolean isFull(){ 
        return heapSize == heap.length; //Se revisa que no este lleno
    }
     
     
    private int Padre(int i){
        return (i-1)/2;
    }
     
    private int Hijo(int i,int k){
        return 2*i  +k;
    }
     
    public void insert(int x){
        if(isFull())
            throw new NoSuchElementException("No se pueden insertar más datos al heap, esta lleno :(");
        heap[heapSize++] = x;
        HeapifyArriba(heapSize-1);
    }
     
    public int Elimina(int x){
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
     
    public void ImprimeHeap()
        {
            System.out.print("nHeap = ");
            for (int i = 0; i < heapSize; i++)
                System.out.print(heap[i] +" ");
            System.out.println();
        }
    
     public int EncuentraGrandulon(){
         if(isEmpty())
             throw new NoSuchElementException("Heap is empty.");
         return heap[0];
     }
      
     
}

