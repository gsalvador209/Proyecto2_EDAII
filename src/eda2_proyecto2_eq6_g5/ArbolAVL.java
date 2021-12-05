package eda2_proyecto2_eq6_g5;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Esta clase contiene los métodos necesarios para 
 * crear y realizar ciertas operaciones con árboles AVL
 * Hereda a la clase ArbolBin
 * @author Yaxca Alexa Quero Bautista
*/
public class ArbolAVL extends ArbolBin{
    
    /**
     * Busca el nodo con el valor que busca el usuario
     * @param value Valor del nodo a buscar
     * @return objeto de tipo Nodo del valor buscado
     */
    public Nodo getNodo(int value){
        if (!this.contains(value)) {
            System.err.println("Ese nodo no existe.");
            return null;
        } else {
            Nodo r = root;
            if (r.getValue() == value) {
                return r;
            }
            Queue<Nodo> queue = new LinkedList();
            if (r != null) {
                queue.add(r);
                while (!queue.isEmpty()) {
                    r = (Nodo) queue.poll();
                    if(r.getValue()==value)
                        return r;
                    if (r.izq != null) {
                        queue.add(r.izq);
                    }
                    if (r.der != null) {
                        queue.add(r.der);
                    }
                }
            }
            return null;
        }    
    }
    
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
                    
        //balanceo del árbol
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
     * @param hijo Nodo que se va a eliminar
     */
    @Override
    public void delete(Nodo hijo){
        hijo = swapMenorMasCercano(hijo);
        hacerHoja(hijo);
        Nodo padre = padreDe(root,hijo);
        if(padre.izq!=null){
            if(padre.izq.getValue()==hijo.getValue()){
                padre.izq = null;
                return ;
            }
        }
        padre.der = null;
        balancea(padre,hijo.valor);
    }
    
    /**
     * Busca si el valor se encuentra en el valor
     * @param n Valor entero que se busca
     * @return varbiable booleana que dice si se encuentra
     *         o no el valor buscado
     */
    public boolean contains(int n){
        List<Integer> busqueda;
        busqueda = this.BFS(false);
        return busqueda.contains(n);
    }
    
    private Nodo swapMenorMasCercano(Nodo n){
        Nodo menorMasCercano = null;
        int temp;
        
        if(n.izq != null){
            menorMasCercano = encontrarMasDer(n.izq);
        }else if(n.der != null){
            menorMasCercano = encontrarMasIzq(n.der);
        }else{
            //El nodo n ya es hoja
            return n;
        }
        temp = n.getValue();
        
        Nodo padreMenor = padreDe(root,menorMasCercano);
        
        if(padreMenor == n){
            if (padreMenor.izq == menorMasCercano) {
                swap(n, menorMasCercano, 0);
            } else {
                swap(n, menorMasCercano, 1);
            }
            return n;
        }
        
        n.valor = menorMasCercano.getValue();
        menorMasCercano.valor = temp;
        return menorMasCercano;
    }
    
    private Nodo encontrarMasDer(Nodo n){
        if(n.der!=null)
            n = encontrarMasDer(n.der);
        else
            return n;
        return n;
    }
    
    private Nodo encontrarMasIzq(Nodo n){
        if(n.izq!=null)
            n = encontrarMasIzq(n.izq);
        else
            return n;
        return n;
    }
}
