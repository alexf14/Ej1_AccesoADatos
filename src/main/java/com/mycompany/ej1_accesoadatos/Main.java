package com.mycompany.ej1_accesoadatos;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

public class Main {
    
    
    public static void main(String [] arg){
        Partida p=new Partida();
        Scanner src = new Scanner(System.in);
        Scanner dificultad = new Scanner(System.in);
        
        System.out.println("¡Bienvenido al juego de adivinar películas!");
        System.out.println("¿Que quieres hacer?");
        System.out.println("Pulsa 1 para cargar partida");
        System.out.println("Pulsa 2 para crear una nueva partida");
        
       String  lPartida= src.nextLine();
       int vInicio=parseInt(lPartida, 10);
        
        //Si selecciona cargar ua partida se cargara el fichero de guardado con la partida en curso
            //Ir a la clase de juego
        if(vInicio==1){
            //Llamar al metodo para cargar partida
        }else if(vInicio==2){
            System.out.println("Pulsa F para facil (de 1 a 15 carácteres)");
            System.out.println("Pulsa D para dificil (más de 15 carácteres)");
            
            String  vDificultad= dificultad.nextLine();
            
            //Llamar al metodo para crear una partida nueva
        }
        
        p.partida("d");
        //Si selecciona crear una nueva partida borramos el fichero de guardado y creamos uno nuevo
            //Escoger dificultad
                //Ir a la clase de juego
    }
}
