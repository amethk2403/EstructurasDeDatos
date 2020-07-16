package app;

public class ArbolBinario{
    NodoA raiz;

    public ArbolBinario (){
        raiz = null;
    }

    //metodo para insertar un nodo en el árbol
    public void agregarNodo(int d){
        //Se crea el nodo nuevo
        NodoA nuevo = new NodoA(d);

        //Se verifica que la raiz no tenga contenido
        if( raiz == null){
            //Se asigna el nuevo nodo a la raiz
            raiz = nuevo;
        }else{
            //Se crea nodo para hacer recorrido y inserción de nuevo nodo
            NodoA aux = raiz;

            //Variable tipo nodo que sera el padre de las siguiente ramas o hijos
            NodoA padre;

            //Ciclo para recorrido de inserción de nuevos nodos padre e hijos
            while (true){

                //se asigna el valor del nodo auxiliar al padre 
                padre = aux;

                //Condicional para saber si se debe insertar a la izquierda
                if(d < aux.dato){
                    //se agrera el dato al nodo auxiliar
                    aux = aux.hizq;
                        //Se verifica si se ha llegado al final del recorrdio
                        if(aux==null){
                            
                            padre.hizq = nuevo;
                            return;
                    }
                //Recorrido para el lado derecho
                }else{
                    aux = aux.hder;
                    if(aux == null){
                        padre.hder = nuevo;
                        return;
                    }
                }
            }
        }
    }

    //Método para saber si el árbol esta vacio 
    public boolean estaVacio(){
        return raiz == null;
    }

    //Método para recorrer el árbol InOrden
    public void InOrden(NodoA r){
        //System.out.print("→");
        //Verificar que no este vacia para iniciar el recorrido
        if (r != null){
            //Recorrido desde el lado izquierdo
            InOrden(r.hizq);
            //La raiz 
            System.out.print(r.dato+", ");
            //Recorrido desde el lado derecho
            InOrden(r.hder);
        }
    }

    //Método para recorrer árbol PostOrden
    public void PostOrden(NodoA r){
        //System.out.print("");
        //Verificar que no este vacia para iniciar el recorrido
        if (r != null){
            //Recorrido desde el lado izquierdo
            PreOrden(r.hizq);
            //Recorrido desde el lado derecho
            PreOrden(r.hder);
            //La raiz 
            System.out.print(r.dato+", ");
        }
    }

    //Método para recorrer árbol PreOrden
    public void PreOrden(NodoA r){
        //System.out.print("→");
        //Verificar que no este vacia para iniciar el recorrido
        if (r != null){
            //La raiz
            System.out.print(r.dato+", ");
            //Recorrido desde el lado izquierdo
            PreOrden(r.hizq);
            //Recorrido desde el lado derecho
            PreOrden(r.hder);
        }
    }

    //Método para buscar un Nodo en el árbol
    public NodoA BuscarNodo(int d){
        //Se crea variable tipo nodo para almacenar la raiz 
        NodoA temp = raiz;

        //Ciclo para hacer recorrido mietras sea diferente 
        while (temp.dato != d){
            //Verificación para buscar del lado izquierdo
            if(d < temp.dato){
                temp = temp.hizq;
            //Verificación para buscar del lado derecho
            }else{
                temp = temp.hder;
            }
            //Condicionante para saber si se llego al final 
            if (temp == null){
                return null;
            }
        }

        return temp;
    }

    //Método para eliminar un Nodo del árbol 
    public boolean Eliminar (int d){
        NodoA aux = raiz;
        NodoA padre = raiz;
        boolean eshizq = true;
        
        //Recorrido para buscar el nodo a eliminar y saber si existe
        while(aux.dato != d){
            padre = aux;

            //busqueda por la izquierda
            if(d<aux.dato){
                eshizq = true;
                aux = aux.hizq;
            }else{
                eshizq = false;
                aux = aux.hder;
            }

            //Condicionante para saber si se llego al final 
            if(aux == null){
            return false;
            }
        }//fin del while

        //Validación para saber si es el nodo hijo u hoja
        if(aux.hizq == null && aux.hder==null){
            //verificación de que el nodo sobre el cual estamos es raiz
            if(aux==raiz){
                //Se hace nula la raiz
                raiz = null;
            }else if(eshizq){
                //se hace el padre izquierdo nulo
                padre.hizq = null;
            }else{
                //se hace el padre derecho nulo
                padre.hder = null;
            }

        }else if(aux.hder == null){
            //verificación de que el nodo sobre el cual estamos es raiz
            if(aux==raiz){
                //Se hace raiz el hijo izquierdo
                raiz = aux.hizq;
            }else if(eshizq){
                //se hace padre izquierdo el hijo izquierdo
                padre.hizq = aux.hizq;
            }else{
                //se hace padre derecho el hijo izquierdo
                padre.hder = aux.hizq;
            }
        }else if(aux.hizq == null){
            //verificación de que el nodo sobre el cual estamos es raiz
            if(aux==raiz){
                //Se hace raiz el hijo derecho
                raiz = aux.hder;
            }else if(eshizq){
                //se hace padre izquierdo el hijo derecho
                padre.hizq = aux.hder;
            }else{
                //se hace padre derecho el hijo derecho
                padre.hder = aux.hder;
            }
        }else{
            //Se hacer el cambio nodos
            NodoA reemplazo = ObtenerNodoRemplazo(aux);

            //Validación para hacer el cambio de nodo
            if(aux == raiz){
                //se cambia la raiz por nuevo nodo
                raiz = reemplazo;
            }else if(eshizq){
                //Se cambia el padre izquierdo por el nuevo nodo
                padre.hizq = reemplazo;
            }else{
                //Se cambia el padre derecho por el nuevo nodo
                padre.hder = reemplazo;
            }
            
            //Se asigna el nodo auxiliar al nodo remplazo
            reemplazo.hizq = aux.hizq;
        }

        //retorna que si encontro el nodo a reemplazar y lo reemplaza
        return true;
    }

    //Método para devolver el nodo remplazado
    public NodoA ObtenerNodoRemplazo(NodoA nodRe){
        NodoA reemplazarPadre = nodRe;
        NodoA reemplazo = nodRe;
        NodoA au = nodRe.hder;

        //Seleccion de nodo que tomara el lugar
        while(au != null){
            reemplazarPadre = reemplazo;
            reemplazo = au;
            au = au.hizq;
        }

        //Validación para reacomodar los enlaces
        if (reemplazo != nodRe.hder){
            reemplazarPadre.hizq = reemplazo.hder;
            reemplazo.hder = nodRe.hder;
        }

        System.out.println("El nodo se cambiara por: " + reemplazo);
        return reemplazo;
    }
}