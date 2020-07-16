package app;

import javax.swing.JOptionPane;

public class Cola {
    NodoC inicio;
    NodoC fin;
    int capacidad; 
    
    public Cola (){
        inicio = null;
        fin = null;
        capacidad = 0;
    }

    public boolean estaVacia(){
        return inicio == null;
    }

    public void InsertarC (int elemento){
        NodoC nuevo = new NodoC(elemento);
        if (estaVacia()){
            inicio = nuevo;
        }else{
            fin.siguiente = nuevo;
        }

        fin = nuevo;
        capacidad ++;
    }

    public int ExtraerC (){
        int aux = inicio.dato;
        inicio = inicio.siguiente;
        capacidad --;
        return aux;
    }

    public int inicioCola(){
        return inicio.dato;
    }

    public int TamanioC(){
        return capacidad;
    }

    public void LimpiarC(){
        while(!estaVacia()){
            ExtraerC();
        }
    }

    public void MostrarP(){
        NodoC recorrido = inicio;
        String acum = "";
        
        while(recorrido != null){
            acum = acum + "["+recorrido.dato+"]←";
            recorrido = recorrido.siguiente;
        }

        JOptionPane.showMessageDialog(null, acum, "Mostrando datos en la Cola", 1);
    }
}