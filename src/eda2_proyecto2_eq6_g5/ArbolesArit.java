
package eda2_proyecto2_eq6_g5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Salvador Chavez
 */
public class ArbolesArit extends ArbolBin{
    
    //******ATRINBUTOS*****
    Stack<Character> operadores = new Stack();
    Stack<Nodo> numeros = new Stack();
    //ArbolBin arbol;
    Nodo n;
    //String expresion;
    
    //****CONSTRUCTOR******
    public ArbolesArit(){
        
    }
    
    
    //****MÉTODOS*******
    public void generarArbol(String expresion){
        char next;
        int i=0;
        int b;
        List<Character> temp = new ArrayList();
        while(i<expresion.length()){
            next = expresion.charAt(i);
            if(isNumber(next)){
                getHoleNumber(expresion,i,temp);
                b = toNumber(temp);
                temp.clear();
                //System.out.println("Número: " + b);
                n = new Nodo(b);
                numeros.push(n);
                i += Integer.toString(b).length() - 1; //Se salta los dígitos ya ocupados
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
            }else if(firstIsHigherOrEquals(next,operadores.peek()))
                operadores.push(next);
            else {
                while(!operadores.isEmpty()){
                    if(firstIsHigherOrEquals(operadores.peek(),next)){
                        AssembleNode(operadores.pop());
                    }
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
    
    private boolean firstIsHigherOrEquals(char m, char n){
        int a, b;
        a = hierarchy(m);
        b = hierarchy(n);
        return a>=b;
    }
    
    private boolean isNumber(char m){
        return Character.isDigit(m);
    }
    
    private int hierarchy(char x){
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
    
    private void AssembleNode(char m){
        Nodo c = new Nodo(m);
        c.setDer(numeros.pop());
        c.setIzq(numeros.pop());
        numeros.add(c);
        //c.printConHijos();
    }
    
    public void printPolix(){
        System.out.print("La operación en notación polaca es: ");
        this.posOrden(root);
        System.out.println();
    }
    
    private void getHoleNumber(String ex, int at, List<Character> hole){
        if(isNumber(ex.charAt(at))&&at<ex.length()){
            hole.add(ex.charAt(at));
            if(at+1<ex.length()){
              getHoleNumber(ex,at+1,hole);  
            }
        }
    }
    
    private int toNumber(List<Character> h){
        String numero = "";
        for(Character digito: h){
            numero = numero + digito;
        }
        return Integer.valueOf(numero);
    }
    
    public void clean(){
        root = null;
    }
}
