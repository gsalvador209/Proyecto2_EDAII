package eda2_proyecto2_eq6_g5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

// Nava Alberto Vanessa 

// en esta clase esta implementado el heap donde:
// se agregauna clave, se elimina una clave y muestra el árbol

public class Heap {

    List list = new ArrayList<Integer>(); 

    public Heap(){

        System.out.println("Heap :)");
        System.out.println("Aquí va el heap");
    
        /*
        *   Aqui va todo el código del heap ;)
        *   Sacatelas
        */ 

        System.out.println("La ultima prueba");

    }

    void ConstruyeHeap(list){
        heapSize= size-1;
        for(i=(size-1)/2;i>=0;i--){
            Heapify(list,size);
        }
    }
    void Heapify(int list, int i){
        int l=2*i+1;
        int r=2*i+2;
        int largest;
        if(l<heapSize&&list[l]>list[i])
            largest=r;
        if(r<=heapSize&&list[r]>list[largest])
            largest=r;
        if(largest!=i){
            swap(list[i],list[largest]);
            Heapify(list, largest,sizes);
        }
    }

}

