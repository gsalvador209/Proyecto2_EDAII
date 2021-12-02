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
    public Nodo(int data){                  //Crea un nodo con un valor particular y sin hijos
        this(data,null,null);
    }
    public Nodo(int data, Nodo lt, Nodo rt){ //Crea un nodo con un valor y dos hijos en especifico
        valor=data;
        izq = lt;
        der = rt;
        altura = 1;
    }
    
    public Nodo(Nodo cpy){
        valor = cpy.getValue();
        this.setIzq(cpy.izq);
        this.setDer(cpy.der);
    }
    
    //****Setters*****
    public void setIzq(Nodo izq) {          //Asigna el valor izq al nodo izquierdo
        this.izq = izq;
    }
    
    public void setDer(Nodo der) {           // Asigna der al nodo derecho
        this.der = der;
    }
    
    //***Getters***
    public int getValue(){
        return valor;
    }
    
    public void print(){
        if(this != null){
            System.out.println("El nodo es " + valor);
            
        }else{
            System.out.println("El nodo no está definido.");
        }
        
    }
   
}
