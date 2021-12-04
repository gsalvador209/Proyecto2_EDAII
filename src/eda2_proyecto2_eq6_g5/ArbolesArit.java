
package eda2_proyecto2_eq6_g5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Clase creada para el manejo de Arboles Binarios de 
 * expresion arirmética. Herencia de la Clase ArbolBin
 * @author Salvador Chavez
 */
public class ArbolesArit extends ArbolBin{
    
    //******ATRIBUTOS*****      
    Stack<Character> operadores = new Stack();
    Stack<Nodo> numeros = new Stack();
    Nodo n;
    //root form ArbolBin
    
    //****CONSTRUCTOR******
    public ArbolesArit(){
        
    }
    
    //****MÉTODOS*******
    
    /** Genera el arbol de expresión aritmetica a partir de su parámetro dado
     *
     * @param expresion Se permiten numeros, +, -, *, /, (,). Lo demás será ignorado.
     */
    public void generarArbol(String expresion){
        char next;
        int i=0;
        int b;
        //List<Character> temp = new ArrayList();
        while(i<expresion.length()){
            
            next = expresion.charAt(i);
            //System.out.println(next);
            if(isNumber(next)){
                //getHoleNumber(expresion,i,temp);                              //Inutilizable por la notación polaca
                //b = toNumber(temp);
                //temp.clear();
                b = Integer.valueOf(String.valueOf(next));
                n = new Nodo(b);
                numeros.push(n);
                //i += Integer.toString(b).length() - 1;                        //Se salta los dígitos ya ocupados
            }else if(!isOperator(next)){
                i++;
                break;
            }else if(next == '('||operadores.isEmpty())
                operadores.push(next);
            else if(next == ')'){
                while (true) {
                    AssembleNode(operadores.pop());
                    if (operadores.peek() == '(') {
                        operadores.pop();
                       break;
                   }
                } 
            }else if(firstIsLess(operadores.peek(),next)) //firstIsHigherOrEquals(next,operadores.peek())
                operadores.push(next);
            else {
                while(!operadores.isEmpty()){
                    if(firstIsHigherOrEquals(operadores.peek(),next)){
                        //System.out.println(operadores.peek() + " es msyor que " + next);
                        AssembleNode(operadores.pop());
                    }else
                        break;
                }
                operadores.add(next);
            }
            i++;
        }
        while(!operadores.isEmpty()){
            AssembleNode(operadores.pop());
        }
       
        root = numeros.pop();
    }
    
    private boolean firstIsHigherOrEquals(char m, char n){                      //Compara dos operadores y devuelve el resultado de m>=b
        int a, b;
        a = hierarchy(m);
        b = hierarchy(n);
        return a>=b;
    }
    
    private boolean firstIsLess(char m, char n){
        int a,b;
        a = hierarchy (m);
        b = hierarchy(n);
        return a<b; 
    }
    
    private boolean isNumber(char m){                                           //Devuelve verdadero si m es un número y falso de lo contrario
        return Character.isDigit(m);
    }
    
    private boolean isOperator(char m){                                         //Devuelve verdadero si m es operador y falso de lo contrario.
        return (hierarchy(m)>=0);
    }
    
    private int hierarchy(char x){                                              //Asigna jerarquias a los operadores, si no están definidos son -1
        int r;
        switch(x){
            case '(':
            case ')':
                r = 0;
                break;
            case '*':
            case '/':
                r = 2;
                break;
            case '+':
            case '-':
                r = 1;
                break;
            default:
                r=-1;
                break; 
        }
        return r;
    }
    
    private void AssembleNode(char m){                                          //Genera un nodo con caracter m, después retira dos numeros del stack y los
        Nodo c = new Nodo(m);                                                   //Convierte en sus hijos para hacer push a este nodo al stack
        c.setDer(numeros.pop());
        c.setIzq(numeros.pop());
        numeros.add(c);
        //c.printConHijos();
    }
    
    /**
     *  Genera un texto que contiene la expresión arimetica en notación
     *  polaca.
     * @return La expresión aritmética en Polish
     */
    public String getPolish(){
        List<Character> notacion = new ArrayList();
        String l = "";
        /*
        System.out.print("La operación en notación polaca es: ");
        this.posOrden(root);
        */
        
        this.posOrden(root, notacion);
        for(Character c: notacion){
            l += c;
        }
        return l;
    }
    
    private void getHoleNumber(String ex, int at, List<Character> hole){        //Obtiene el número completo una cadena de texto
        if(isNumber(ex.charAt(at))&&at<ex.length()){                            //Es decir, toma enteros hasta que encunetre otro simbolo difernte
            hole.add(ex.charAt(at));                                           
            if(at+1<ex.length()){
              getHoleNumber(ex,at+1,hole);  
            }
        }
    }
    
    private int toNumber(List<Character> h){                                    //Convierte la lista llenada por getHoleNumber y la convierte a un entero
        String numero = "";
        for(Character digito: h){
            numero = numero + digito;
        }
        return Integer.valueOf(numero);
    }
    
    private int binaryOperation(int a, int b, char o){
        int result;
        switch(o){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result= a/b;
                break;
            default:
                result = -1000000000;
                break;
        }
        return result;
    }
    
    public int solveTree(){
        Stack<Integer> nums = new Stack();
        int i = 0,t,a,b,r;
        char next;
        String expresion = this.getPolish();
        while(i<expresion.length()){
            next = expresion.charAt(i);
            if(isNumber(next)){
                t = Integer.valueOf(String.valueOf(next));
                nums.push(t);
            }else{
                b = nums.pop();
                a = nums.pop();
                r = binaryOperation(a,b,next);
                nums.push(r);
            }
            if(i==expresion.length()-1){
                r = nums.pop();
                return r;
            }
            i++;
        }
        return -10000000;
    }

    public void clean(){
        root = null;
    }
    
    
}
