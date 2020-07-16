package app;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        //Variable para manejo de menú
        int opcion;

        //varibale para almacenar el número al azar que se guardara en la estructura
        int numer;
        
        //Creación de objetos 
        Pila pil = new Pila();
        Cola col = new Cola();
        ArbolBinario arb = new ArbolBinario();

        //Menú principal 
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
            "1. Estructura de Pila o Cola\n" + //Problema 1
            "2. Estructura de Árbol\n" + //Problema 2
            "3. Estructura de Grafos\n" + //Problema 3
            "4. Salir", "Proyecto #2", 3));

            switch (opcion){

                case 1:
                    //Menú de problema 1
                    do{
                        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "1. Crear tipo de Estructura\n"+ //Lleva un submenú para elegir entre Pila o Cola 
                        "2. Recorrer y mostrar Estructura\n" + //Muestra lo que contiene la Pila o Cola
                        "3. Agregar elemento en Estructura\n" + //Permite agregar un elemnento a la estructura
                        "4. Eliminar elemento en Estructura\n" + //Lleva un submenú para elegir entre eliminar o modificar
                        "5. Salir", "Proyecto #2", 3));
                        switch(opcion){

                            case 1:
                                //Sub menú problema 1
                                do{
                                    opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                    "1. Crear Pila\n"+  //Crea la estructrua Pila 
                                    "2. Crear Cola\n" + //Crea la estructura Cola
                                    "3. Salir", "¿Qué estructura deseas crear?", 3));
                                    
                                    switch(opcion){
                                        case 1:
                                        //Se crea una lista de números al azar para llenar la pila

                                            //Ciclo que repite 10 veces la creación y asignación de valores a la Pila
                                            for (int i = 0; i <= 9; i++){

                                                //Funcion que crea el número al azar
                                                numer = 1 + (int) (Math.random()*100);
                                                pil.LlenarP(numer);
                                                
                                                //Imprime la lista por consola para verificar que datos ingreso de antemano
                                                System.out.println("["+i+"] El número aleatorio es: "+numer);
                                            }

                                            //Mensaje de creación exitosa 
                                            JOptionPane.showMessageDialog(null, "Pila creada", "Creación Exitosa", 1);
                                        break;

                                        case 2:
                                        //Se crea una lista de números al azar para llenar la Cola
                                            
                                            //Ciclo que repite 10 veces la creación y asignación de valores a la Pila
                                            for (int i = 0; i <= 9; i++){

                                                //Funcion que crea el número al azar
                                                numer = 1 + (int) (Math.random()*100);
                                                col.InsertarC(numer);

                                                //Imprime la lista por consola para verificar que datos ingreso de antemano
                                                System.out.println("["+i+"] El número aleatorio es: "+numer);
                                            }

                                            //Mensaje de creación exitosa 
                                            JOptionPane.showMessageDialog(null, "Cola creada", "Creación Exitosa", 1);
                                        break;

                                        default :
                                        break;
                                    }

                                }while(opcion !=3); //termina crear pila o cola
                            break; //termina opcion 1

                            case 2:
                            //Muestra lo que contiene la estructura en orden 
                                
                                //Se valida que la pila no este vacia para mostrar los datos
                                if(!pil.estaVacia()){
                                    //Se llama al metodo que muestra los dato almacenados
                                    pil.MostrarP();

                                //Se valida que la pila no este vacia para mostrar los datos
                                }else if(!col.estaVacia()){
                                    //Se llama al metodo que muestra los dato almacenados
                                    col.MostrarP();
                                }else{
                                    JOptionPane.showMessageDialog(null, "La estructura esta vacia", "ADVERTENCIA", 2);
                                }
                            break;

                            case 3:
                            //Agregar elemento dentro de la estructura
                                if (!pil.estaVacia()){
                                    //Se pide el nuevo elemento al usuario
                                    numer = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el nuevo dato a la estructura: "));
                                    
                                    //Se añade el elemento al metodo de ingreso a la Pila 
                                    pil.LlenarP(numer);
                                }else if(!col.estaVacia()){
                                    //Se pide el nuevo elemento al usuario
                                    numer = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el nuevo dato a la estructura: "));
                                    
                                    //Se añade el elemento al metodo de ingreso a la Cola
                                    col.InsertarC(numer);
                                }else{
                                    //Se muestra advertencia en caso de que este vacia la estructura
                                    JOptionPane.showMessageDialog(null, "La estructura esta vacia", "ADVERTENCIA", 2);
                                }
                            break;

                            case 4: 
                            //Sa valida que la pila no este vacia para poder eliminar elementos
                                if (!pil.estaVacia()){ 
                                    JOptionPane.showMessageDialog(null, 
                                    "Siguiendo la regla F.I.L.O\n" +
                                    "Se eliminara el ultimo elemento ingresado a la Pila\n" +
                                    "Hasta llegar al primer elemento ingresado a la Pila\n", 
                                    "Estructura tipo F.I.L.O", 2);
                                    
                                    //metodo que limpia la pila
                                    pil.SacarP();

                            //Sa valida que la cola no este vacia para poder eliminar elementos
                                }else if (!col.estaVacia()){
                                    JOptionPane.showMessageDialog(null, 
                                    "Siguiendo la regla F.I.F.O\n" +
                                    "Se eliminara el primer elemento ingresado a la Cola\n" +
                                    "Hasta llegar al ultimo elemento ingresado a la Cola\n", 
                                    "Estructura tipo F.I.F.O", 2);

                                    //metodo que limpia la cola
                                    col.ExtraerC();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Estructura Vacia", "ADVERTENCIA", 2);
                                }
                            break;

                            default:
                            //Limpian el contenido en las estructuras para ser llenadas nuevamente al ingresas
                                pil.LimpiarP();
                                col.LimpiarC();
                            break;
                        }

                    }while(opcion !=5); //termina acciones del problema 1

                break;

                case 2:
                    //Menú de problema 2
                    do {
                        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "1. Árbol Binario\n" + //Lleva a un submenú
                        "2. Salir", "Menú principal Problema 3: Árboles", 3));

                        switch(opcion){
                            case 1:
                            //Submenú del problema 2: Arboles binarios
                                do{
                                    opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                    "1. Generar Árbol\n" + //Genera un árbol con datos aleatorios
                                    "2. Recorridos\n" +
                                    "3. Buscar y eliminar\n"+
                                    "4. Salir", "Submenú de opciones", 3));

                                    switch(opcion){
                                        case 1:
                                            //Ciclo que repite 10 veces la creación y asignación de valores a la Pila
                                            for (int i = 0; i <= 9; i++){

                                                //Funcion que crea el número al azar
                                                numer = 1 + (int) (Math.random()*100);
                                                arb.agregarNodo(numer);
                                                
                                                //Imprime la lista por consola para verificar que datos ingreso de antemano
                                                System.out.println("["+i+"] El número aleatorio es: "+numer);
                                            }

                                            JOptionPane.showMessageDialog(null, "Se creo el árbol binario", "Creación Exitosa", 2);
                                        break;

                                        case 2:
                                            do {
                                                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                                "1. InOrden\n" + //Genera un árbol con datos aleatorios
                                                "2. PostOrden\n" +
                                                "3. PreOrden\n"+
                                                "4. Salir", "Submenú recorridos", 3));

                                                switch(opcion){
                                                    //Recorrido InOrden
                                                    case 1:
                                                    //Se llama la método de recorrido InOrden
                                                        //Se valida si el árbol esta vacio
                                                        if(!arb.estaVacio()){
                                                            arb.InOrden(arb.raiz);
                                                        }else{
                                                            JOptionPane.showMessageDialog(null, "El árbol Vacio", "ADVERTENCIA", 2);
                                                        }
                                                        System.out.println();
                                                    break;

                                                    //Recorrido PostOrden
                                                    case 2:
                                                    //Se llama la método de recorrido PostOrden
                                                        //Se valida si el árbol esta vacio
                                                        if(!arb.estaVacio()){
                                                            arb.PostOrden(arb.raiz);
                                                        }else{
                                                            JOptionPane.showMessageDialog(null, "El árbol Vacio", "ADVERTENCIA", 2);
                                                        }
                                                        System.out.println();
                                                    break;

                                                    //Recorrido PreOrden
                                                    case 3:
                                                    //Se llama la método de recorrido PreOrden
                                                        //Se valida si el árbol esta vacio
                                                        if(!arb.estaVacio()){
                                                            arb.PreOrden(arb.raiz);
                                                        }else{
                                                            JOptionPane.showMessageDialog(null, "El árbol Vacio", "ADVERTENCIA", 2);
                                                        }
                                                        System.out.println();
                                                    break;
                                                }
                                            }while(opcion !=4); //Fin de las acciones en el submenú recorrido
                                        break;

                                        case 3:
                                        //Submenú de busqueda y eliminación
                                            if(!arb.estaVacio()){
                                                numer = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                                "Ingresa el elemento a buscar: ", "Eliminando elemento", 3));

                                                if (arb.Eliminar(numer) == false){
                                                    JOptionPane.showMessageDialog(null, 
                                                    "El elemento no esta en el árbol", "Elemeno no encontrado", 1);
                                                }else{
                                                    JOptionPane.showMessageDialog(null, 
                                                    "El elemento ha sido eliminado del árbol", "Elemeno eliminado...", 2);
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, 
                                                "El árbol esta vacio", "ADVERTENCIA", 2);
                                            }
                                        break;
                                    }
                                }while(opcion != 4); //termina acciones del submenú problema 2
                            break;
                        }
                    }while(opcion !=2); //Fin de acciones del problema 2
                break;
                
                case 3:
                    //Menú de problema 3
                    do{

                    }while(opcion != 4);
                break;

                default:

                break;
            }

        }while(opcion !=4); //termina menú principal
    }
}

