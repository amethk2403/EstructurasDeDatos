package app;

import javax.swing.JOptionPane;

public class Pila{
    private NodoP cima;
    int capacidad;

    //Constructor 
    public Pila(){
        cima = null;
        capacidad = 0;
    }

    //Metodo para saber si la pila esta vacia
    public boolean estaVacia(){
        return cima == null;
    }

    //Metodo para ingresar un elemento a la pila
    public void LlenarP(int elemento){
        NodoP nuevo = new NodoP (elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
        capacidad ++;
    }

    //Metodo para extraer un elemento de la pila
    public int SacarP(){
        int aux  = cima.dato;
        cima = cima.siguiente;
        capacidad --;
        return aux;
    }

    //Metodo para saber el tamaño de la pila
    public int TamanioP(){
        return capacidad;
    }

    //Metodo para vaciar la pila
    public void LimpiarP(){
        while(!estaVacia()){
            SacarP();
        }
    }

    //Metodo para mostrar todos los elementos de la pila
    public void MostrarP(){
        NodoP aux = cima;
        String acum = "";
        
        while(aux != null){
            acum = acum + "["+aux.dato+"]↑\n";
            aux = aux.siguiente;
        }

        JOptionPane.showMessageDialog(null, acum, "Mostrando datos en la Pila", 1);
    }
}