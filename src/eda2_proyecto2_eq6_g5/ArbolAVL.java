/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eda2_proyecto2_eq6_g5;

/**
 * Esta clase contiene los métodos necesarios para 
 * crear y realizar ciertas operaciones con árboles AVL
 * @author Yaxca
 */
public class ArbolAVL {
    
    public Nodo raiz;
    
    public ArbolAVL(){
        raiz=null;
    }
    public ArbolAVL(Nodo root){
        raiz=root;
    }
    
    /**
     * Obtiene la altura del nodo
     * Puede ser 1, 0 o -1
     * @param elNodo objeto del tipo Nodo
     * @return altura del nodo
     */
    public int getAltura(Nodo elNodo){
        if( elNodo == null ){
            return 0;
        }
        return elNodo.altura;
    }
    
    public int getDiferencia(int alturaUno, int alturaDos){
        int altura;    
        //obtener altura máxima
        
        return 1; //devolver esa altura
    }
    
    /**
     * Obtiene la función equilibrio del Nodo
     * @param padre objeto del tipo Nodo
     * @return valor entero con la nueva altura para padre
     */
    public int equilibrio(Nodo padre){
        int equilibrio;
        if(padre==null)
            return 0;
        else
            equilibrio = getAltura(padre.izq) - getAltura(padre.der); 
        return equilibrio;
    }
 
    /**
     * Insertar nodos en un árbol binario de búsqueda
     * @param padre Nodo padre del árbol, regularmente la raíz
     * @param hijo Nodo agregado por el usuario
     * @param valorHijo valor del nuevo nodo
     */
    public void add(Nodo padre, Nodo hijo , int valorHijo){       
        Nodo nodoNuevo;  
        
            //inserción normal
        if(padre.valor>valorHijo){
            if(padre.izq == null){
                padre.izq = new Nodo(hijo.valor);
                nodoNuevo= padre.izq;
            }
            else{
                add(padre.izq,hijo,valorHijo);
            }
        }
        if(padre.valor<valorHijo){
            if(padre.der == null){
                padre.der = new Nodo(hijo.valor);
                nodoNuevo = padre.der;
            } 
            else{
                add(padre.der,hijo,valorHijo);
            } 
        }
        else{
            System.out.println("No se permiten claves duplicadas");
            return;
        }
            //actualizar altura del nodo Padre
        padre.altura = 1 ;//+ equilibrio; 
            
            //equilibrio del padre
        int equilibrio = equilibrio(padre);
        //balancea(padre,
            //balanceando árbol
        if(equilibrio >1 && valorHijo < padre.izq.valor)
            /*padre = rotaDerecha(padre);*/
            
        if(equilibrio < -1 && valorHijo > padre.der.valor)
            /*padre = rotaIzquierda(padre)*/;
        
        if(equilibrio > 1 && valorHijo > padre.izq.valor)
            /*padre.izq = rotaIzquierda(padre)
            raiz = rotaDerecha(padre)*/
            
        if(equilibrio < -1 && valorHijo<padre.der.valor)
            /*padre.der = rotaDerecha(padre);
            raiz=rotaIzquierda(padre)*/valorHijo=1;
         
    }
    
    //funcion balancea
    public void balancea(Nodo padre, int valorHijo){
        int equilibrio = equilibrio(padre);
        if(equilibrio >1 && valorHijo < padre.izq.valor)
            /*raiz = rotaDerecha(padre);*/
            
        if(equilibrio < -1 && valorHijo > padre.der.valor)
            /*raiz = rotaIzquierda(padre)*/;
        
        if(equilibrio < -1 && valorHijo<padre.der.valor)
            /*padre.der = rotaIzquierda(padre);*/valorHijo=1;
        
        if(equilibrio > 1 && valorHijo > padre.izq.valor)
            /*padre.izq = rotaDerecha(padre)*/
            
        if(equilibrio < -1 && valorHijo<padre.der.valor)
            /*padre.der = rotaIzquierda(padre);*/valorHijo=1;
    }
    
    //funcion rota izquierda
    public Nodo rotaIzquierda(Nodo unNodo){
        Nodo nuevaRaiz = unNodo.der;
        Nodo izquierda = unNodo.izq;
        
        nuevaRaiz.izq = unNodo;
        unNodo.der = izquierda;
        
        //actualiza alturas
        
        return nuevaRaiz;
    }
    
    //funcion rota derecha
    public Nodo rotaDerecha(Nodo unNodo){
        Nodo nuevaRaiz = unNodo.izq;
        Nodo izquierda = unNodo.der;
        
        nuevaRaiz.der = unNodo;
        unNodo.izq = izquierda;
        
        //actualiza alturas
        
        return nuevaRaiz;
    }
  
}
