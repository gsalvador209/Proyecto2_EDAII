package eda2_proyecto2_eq6_g5;

/**
 * Esta clase contiene los métodos necesarios para 
 * crear y realizar ciertas operaciones con árboles AVL
 * Hereda a la clase ArbolBin
 * @author Yaxca Alexa Quero Bautista
*/
public class ArbolAVL extends ArbolBin{
    
    /**
     * Obtiene la altura del nodo, incluso
     * si este es nulo
     * @param unNodo el nodo del que se va a obtener la altura
     * @return altura del nodo
     */
    public int getAltura(Nodo unNodo){
        if(unNodo==null)
            return 0;
        return unNodo.altura;
    }
    
    /**
     * Obtiene la altura maxima entre 
     * dos nodos diferentes
     * @param Izq altura del Nodo hijo izquierdo
     * @param Der altura del Nodo hijo derecho
     * @return la altura maxima entre d
     */
    public int getMaximo(int Izq, int Der){
        int maximo;
        
        if (Izq > Der) {
            maximo = Izq;
        }
        else {
            maximo = Der;
        }
        return maximo; //devolver esa altura
    }
    
    /**
     * Obtiene el factor de equilibrio
     * @param unNodo
     * @param izq
     * @param der
     * @return
     */
    public int getEquilibrio(Nodo unNodo, int izq,int der){
        int equilibrio;
        if(unNodo==null)
            equilibrio = 0;
        else
            equilibrio = izq-der;
        return equilibrio;
    }
 
    /**
     * Insertar nodos en un árbol binario de búsqueda
     * @param padre Nodo padre del árbol, regularmente la raíz
     * @param hijo Nodo agregado por el usuario
     * @param valorHijo valor del nuevo nodo
     * @return nodo que será la nueva raíz del árbol
     */
    public Nodo agrega(Nodo padre, Nodo hijo , int valorHijo){       
        
        //inserción normal
        if(padre == null)
            return hijo;
        if(valorHijo < padre.valor)
            padre.izq = agrega(padre.izq,hijo,valorHijo);
        if(valorHijo > padre.valor)
            padre.der = agrega(padre.der,hijo,valorHijo);
                    

        //equilibrio del padre y balanceo del árbol
        Nodo nodoFinal = balancea(padre,valorHijo);
        return nodoFinal;
    }
    
    /**
     * Rebalancea el árbol para mantener el balance del mismo
     * @param padre nodo Padre del hijo a intercambiar
     * @param valorHijo valor del nodo Hijo
     * @return Nodo padre modificado
     */
    public Nodo balancea(Nodo padre, int valorHijo){
        int equilibrio;
        int alturaIzq, alturaDer;
        
        alturaIzq= getAltura(padre.izq);
        alturaDer = getAltura(padre.der);   
                
        //actualiza altura del Nodo padre
        padre.altura= 1 + getMaximo(alturaIzq,alturaDer);      
        
        equilibrio = getEquilibrio(padre,alturaIzq,alturaDer);  
        
        if(equilibrio > 1 && valorHijo < padre.izq.valor)
            return rotaDerecha(padre);
            
        if(equilibrio < -1 && valorHijo > padre.der.valor)
            return rotaIzquierda(padre);
        
        if(equilibrio > 1 && valorHijo > padre.izq.valor){
            padre.izq = rotaIzquierda(padre.izq);
            return rotaDerecha(padre);
        }
            
        if(equilibrio < -1 && valorHijo<padre.der.valor){
            padre.der = rotaDerecha(padre.der);
            return rotaIzquierda(padre);
        }
        
        return padre;
        
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
        unNodo.altura= 1+ getMaximo(getAltura(unNodo.izq), getAltura(unNodo.der));
        nuevaRaiz.altura = 1+ getMaximo(getAltura(nuevaRaiz.izq), getAltura(nuevaRaiz.der));
        
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
        
        //cambia hijos
        nuevaRaiz.der = unNodo;
        unNodo.izq = otroNodo;
        
        //actualiza alturas
        unNodo.altura = 1+ getMaximo(getAltura(unNodo.izq), getAltura(unNodo.der));
        nuevaRaiz.altura = 1+ getMaximo(getAltura(nuevaRaiz.izq), getAltura(nuevaRaiz.der));
        
        return nuevaRaiz;
    }
    
    /**
     * Sirve para eliminar una clave del árbol
     * Si no existe, regresa al mismo padre
     * @param padre nodo padre del hijo a eliminar
     * @param valorHijo
     * @return
     */
    public Nodo elimina(Nodo padre,int valorHijo){
        Nodo buscaNodo = new Nodo(valorHijo);       
        boolean existe=contains(buscaNodo);
        //condición para saber si la clave a eliminar existe o no
        if(existe==false){
            System.out.println("La clave no se encuentra en el árbol");
            return root;
        }
        
        if(padre==null)
            return padre;
        if(valorHijo < padre.valor)
            padre.izq = elimina(padre.izq, valorHijo);
        if(padre.izq!=null){
            if(padre.izq.valor==valorHijo)
                padre.izq = null;
        }else{
            padre.der = null;
        }
        //eliminacion de hojas y nodos intermedios
        
        //balanceo final del árbol
        Nodo nodoFinal = balancea(padre,valorHijo);
        return nodoFinal; 
    }
  
}
