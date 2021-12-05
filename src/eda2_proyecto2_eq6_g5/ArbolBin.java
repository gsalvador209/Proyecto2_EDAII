package eda2_proyecto2_eq6_g5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Edgar
 */
public class ArbolBin {
    //****Atributos***********
    Nodo root;
    
    //****Constructores*********
    public ArbolBin(){                                  //Crea un arbol sin raiz
        root=null;
    }
    
    public ArbolBin(int val){                           //Crea un arbol con un valor específico en su raíz
        root=new Nodo(val);
    }
    
    public ArbolBin(Nodo root){                         //Crea un arbol con un nodo (que puede o no tener hijos) como raíz.
        this.root=root;
    }
    
    //****Atributos****************
    public void add(Nodo padre, Nodo hijo, int lado){  //Añade un hijo a un nodo padre, ese hijo es izquierdo si lado es cero, derecho si no
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    
    protected void visit(Nodo n){                      //Marca un nodo como visitado imprimiendo su valor
        if (n!=null)
            n.print();
    }	
    
    /**
     *  Recorre el arbol a manera de BFS. 
     * @param impresion Si es verdadero, imprime el recorrido, si es falso no li imprime.
     * @return Regresa una lista con el recorrido en forma BFS
     */
    public List<Integer> BFS(boolean impresion){ //Recorrido por BF
        List<Integer> recorrido = new LinkedList();
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                recorrido.add(r.getValue());
                if(impresion)
                    visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
		queue.add(r.der);
            }
	}
        return recorrido;
    }
    
   
    /**
     *  Devuelve el nodo padre del nodo hijo
     * @param candidato La raíz del arbol
     * @param hijo El nodo cuyo padre se busca
     * @return Devuelve el padre del nodo hijo
     */
    public Nodo padreDe(Nodo candidato, Nodo hijo){
        if(candidato==hijo){
            return null;
        }
        Nodo padre = null;
        if(candidato.izq == hijo || candidato.der == hijo){
            return candidato;
        }
        if(candidato.izq!=null&&padre==null){
            padre = padreDe(candidato.izq,hijo);
        }
        if(candidato.der!=null&&padre==null){
            padre = padreDe(candidato.der,hijo);
        }
        return padre;
    }
  
    /** Intercambia un nodo padre con un nodo hijo.
     *
     * @param padre Nodo padre
     * @param hijo Nodo hijo
     * @param lado Posición del nodo hijo. 0 izquierda 1 derecha
     */
    public void swap(Nodo padre, Nodo hijo, int lado){
        Nodo temp = new Nodo(hijo.getValue(),hijo.izq,hijo.der);
        Nodo abuelo = padreDe(root,padre);
        if(lado == 0){
            hijo.der = padre.der;
            padre.der = temp.der;
            hijo.izq = padre;
            padre.izq = temp.izq;
        }else{
            hijo.izq = padre.izq;
            padre.izq = temp.izq;
            hijo.der = padre;
            padre.der = temp.der;
            
        }
        if(abuelo!=null){
            if(abuelo.izq.getValue()==padre.getValue()){
                abuelo.izq = hijo;
            }else{
                abuelo.der = hijo;
            } 
        }else{
            root = hijo;
        }
    }
    
     /**
     *  Intercambia con sus hijos izquierdos hasta que el nodo ingresado sea una hoja y pueda eliminarse. Si no tiene
     * hijo izquierdo, intercambia con el derecho.
     * @param nodo Es el nodo que se busca eliminar
     * 
     */
    public void hacerHoja(Nodo nodo){
        if(nodo.izq!=null){                   //Tiene hijo izquierdo y, quizás, derecho
            swap(nodo,nodo.izq,0);
            hacerHoja(nodo);
        }else if(nodo.der!=null){            //Solo tiene hijo derecho
            swap(nodo,nodo.der,1);
            hacerHoja(nodo);
        }
                                         //No tiene hijos
    }
    
    /**
     *  Elimina un nodo en específico del arbol
     * @param n Nodo que se desea eliminar
     */
    public void delete(Nodo n){
        hacerHoja(n);
        //BFS(true);
        //System.out.println();
        Nodo padre = padreDe(root,n);
        if(padre.izq!=null){
            if(padre.izq.valor==n.valor)
                padre.izq = null;
        }else{
            padre.der = null;
        }
    }
    
    /**
     * Devuelve Verdadero si el nodo ingresado existe dentro del arbol, Falso si no.
     * @param nodo El nodo que se desea comprobar
     * @return El nodo existe dentro del arbol
     */
    public boolean contains(Nodo nodo){
        boolean existe = false;
        List<Integer> busqueda;
        busqueda = this.BFS(false);
        return busqueda.contains(nodo.getValue());
    }
    
    public void preOrden(Nodo nodo){
        nodo.print();
        if(nodo.izq != null)
            preOrden(nodo.izq);
        if(nodo.der != null)
           preOrden(nodo.der);
        
     
    }
    public void inOrden(Nodo nodo){
        
        if(nodo.izq != null)
            inOrden(nodo.izq);
        nodo.print();
        if(nodo.der != null)
           inOrden(nodo.der);
        
    }
    
    public void posOrden(Nodo nodo, List<Character> text){
        try{
            if(nodo.izq != null)
            posOrden(nodo.izq,text);
            if(nodo.der != null)
            posOrden(nodo.der,text);
            if(nodo.c == ' ')
                text.add((char)(nodo.valor + '0'));
            else
                text.add(nodo.c);
        }catch(NullPointerException f){
        
        }
        
        
    }
    
    public void posOrden(Nodo nodo){
        if(nodo.izq != null)
            posOrden(nodo.izq);
        if(nodo.der != null)
           posOrden(nodo.der);
        nodo.print();
     
    }

    
      
}
