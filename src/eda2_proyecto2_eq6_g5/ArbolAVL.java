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
public class ArbolAVL extends ArbolBin{
    
    /**
     * Obtiene la altura maxima entre 
     * dos nodos diferentes
     * @param Izq altura del Nodo hijo izquierdo
     * @param Der altura del Nodo hijo derecho
     * @return la altura maxima entre d
     */
    public int getMaximo(int Izq, int Der){
        int maximo;
        //obtener altura máxima
        if (Izq > Der) {
            maximo = Izq;
        } else {
            maximo = Der;
        }
        return maximo; //devolver esa altura
    }
    
    //TO-DO
    @Override
    public void delete(Nodo unNodo){
        Nodo padre = padreDe(root,unNodo);
        if(padre.izq!=null){
            if(padre.izq.valor==unNodo.valor)
                padre.izq = null;
        }else{
            padre.der = null;
        }
    }
 
    /**
     * Insertar nodos en un árbol binario de búsqueda
     * @param padre Nodo padre del árbol, regularmente la raíz
     * @param hijo Nodo agregado por el usuario
     * @param valorHijo valor del nuevo nodo
     */
    @Override
    public void add(Nodo padre, Nodo hijo , int valorHijo){       
            //inserción normal
        if(padre.valor>valorHijo){
            if(padre.izq == null){
                padre.izq = new Nodo(hijo.valor);
            }
            else{
                add(padre.izq,hijo,valorHijo);
            }
        }
        if(padre.valor<valorHijo){
            if(padre.der == null){
                padre.der = new Nodo(hijo.valor);
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
        balancea(padre,valorHijo); 
    }
    
    //funcion balancea
    public void balancea(Nodo padre, int valorHijo){
        int equilibrio = padre.izq.altura - padre.der.altura;
        
        if(equilibrio >1 && valorHijo < padre.izq.valor)
            padre = rotaDerecha(padre);
            
        if(equilibrio < -1 && valorHijo > padre.der.valor)
            padre = rotaIzquierda(padre);
        
        //TO DO
        if(equilibrio > 1 && valorHijo > padre.izq.valor)
            /*padre.izq = rotaDerecha(padre)*/
            
        if(equilibrio < -1 && valorHijo<padre.der.valor)
            /*padre.der = rotaIzquierda(padre);*/valorHijo=1;
    }
    
    /**
     * Sirve para rotar a la izquierda un árbol
     * @param unNodo el Nodo padre a balancear
     * @return un objeto de tipo Nodo que será el nuevo padre
     */
    public Nodo rotaIzquierda(Nodo unNodo){
        Nodo nuevaRaiz = unNodo.der;
        Nodo otroNodo = nuevaRaiz.izq;
        
        nuevaRaiz.izq = unNodo;
        unNodo.der = otroNodo;
        
        //actualiza alturas
        unNodo.altura= 1+ getMaximo(unNodo.izq.altura, unNodo.der.altura);
        nuevaRaiz.altura = 1+ getMaximo(nuevaRaiz.izq.altura, nuevaRaiz.der.altura);
        
        return nuevaRaiz;
    }

    /**
     * Sirve para rotar a la derecha un árbol
     * @param unNodo el Nodo padre a balancear
     * @return un objeto de tipo Nodo que será el nuevo padre
     */
    public Nodo rotaDerecha(Nodo unNodo){
        Nodo nuevaRaiz = unNodo.izq;
        Nodo otroNodo = nuevaRaiz.der;
        
        nuevaRaiz.der = unNodo;
        unNodo.izq = otroNodo;
        
        //actualiza alturas
        unNodo.altura = getMaximo(unNodo.izq.altura, unNodo.der.altura);
        nuevaRaiz.altura = getMaximo(nuevaRaiz.izq.altura, nuevaRaiz.der.altura);
        
        return nuevaRaiz;
    }
  
}
