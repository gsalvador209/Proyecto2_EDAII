package eda2_proyecto2_eq6_g5;

/**
 *
 * @author Edgar
 */
public class Nodo {
    ///******Atributos******
    int valor, altura;
    Nodo izq = null;
    Nodo der = null;
    
    /***Constructores*****/
    public Nodo(){                          //Inicializa un nodo sin hijos
        izq=der=null;
    }

    /**
     * Crea un nodo con un valor particular y sin hijos
     * @param data valor del nuevo nodo
     */
    public Nodo(int data){                  //Crea un nodo con un valor particular y sin hijos
        this(data,null,null);
    }
    
    /**
     * Crea un nodo con un valor y dos hijos en específico
     * @param data valor del nodo
     * @param lt hijo izquierdo del nodo
     * @param rt hijo derecho del nodo
     */
    public Nodo(int data, Nodo lt, Nodo rt){ //Crea un nodo con un valor y dos hijos en especifico
        valor=data;
        izq = lt;
        der = rt;
        altura = 0;
    }
    
    /**
     * Reescribe el nodo
     * @param cpy un objeto de tipo Nodo
     */
    public Nodo(Nodo cpy){
        valor = cpy.getValue();
        this.setIzq(cpy.izq);
        this.setDer(cpy.der);
    }
    
    //****Setters*****

    /**
     * Asigna al Nodo un nodo como hijo izquierdo
     * @param izq objeto de tipo Nodo
     */
    public void setIzq(Nodo izq) {          //Asigna el valor izq al nodo izquierdo
        this.izq = izq;
    }
    
    /**
     * Asigna al Nodo un nodo como hijo derecho
     * @param der objeto de tipo Nodo
     */
    public void setDer(Nodo der) {           // Asigna der al nodo derecho
        this.der = der;
    }
    
    //***Getters***

    /**
     * Obtener valor del nodo
     * @return el valor del nodo
     */
    public int getValue(){
        return valor;
    }
    
    /**
     * Imprime el valor del nodo
     */
    public void print(){
        if(this != null){
            System.out.println("El nodo es " + valor);
            
        }else{
            System.out.println("El nodo no está definido.");
        }
        
    }
   
}
