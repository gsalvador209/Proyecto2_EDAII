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
    
    public int getAltura(Nodo elNodo){
        if( elNodo == null ){
            return 0;
        }
        return elNodo.altura;
    }
}
