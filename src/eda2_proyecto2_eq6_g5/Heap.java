package eda2_proyecto2_eq6_g5;

import java.util.ArrayList;

// Nava Alberto Vanessa 

// en esta clase esta implementado el heap donde:
// se agregauna clave, se elimina una clave y muestra el árbol

public class Heap {

    ArrayList<Integer> list = new ArrayList<Integer>();
    int heapSize;

    public Heap(){

    }

    void swap(int a,int b){
        int t;
        t=a;
        b=t;
    }

    void Heapify(ArrayList<Integer> list, int i,int size){
        int l = 2 * (i+1);
        int r = 2 * (i+2);
        int largest;
        if( l <= heapSize && list.get(l) > list.get(i))
            largest = l;
        else 
            largest = i;
        if( r <= heapSize && list.get(r) > list.get(largest))
            largest = r;
        if(largest != i){
            swap(list.get(i) , list.get(largest));
            ImprimeArray(list, size);
            Heapify(list, largest,size);
        }
    }

    void ConstruyeHeap(ArrayList<Integer> list, int tam){
        int i; 
        heapSize= tam-1;
        for(i=((tam-1)/2) ; i>=0 ;i--){
            Heapify(list,i,tam);
        }
        System.out.println("El heap esta construido ;)");
    }

    void ImprimeArray(ArrayList<Integer> list,int size){
        int i;
        for ( i=0 ; i < size; i++){
            System.out.println(" "+list.get(i));
        }
    }

    void ImprimeSubArray(ArrayList<Integer> list, int low, int high){
        int i;
        
        for (i=low; i<=high; i++){
            System.out.println(" "+ list.get(i));
        }
    }


}

