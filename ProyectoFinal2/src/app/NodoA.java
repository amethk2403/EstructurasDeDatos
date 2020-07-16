package app;

public class NodoA{
    //variable que ingresara datos al árbol
    int dato;

    //Variables tipo puntero 
    NodoA hizq;
    NodoA hder;

    public NodoA(int d){
        this.dato = d;
        this.hizq = null;
        this.hder = null;
    }

    /*metodo que retorna el nombre del nodo
    public String toString(){
        return nombre + "Su dato es: " + dato;
    }*/
}