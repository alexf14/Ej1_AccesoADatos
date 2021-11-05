package com.mycompany.ej1_accesoadatos;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

public class Main {

    public static void main(String [] arg){
        Partida p=new Partida();
        Fichero_Facil a = new Fichero_Facil();
        Scanner src = new Scanner(System.in);
        Scanner dificultad = new Scanner(System.in);
        
        System.out.println("¡Bienvenido al juego de adivinar películas!");
        System.out.println("¿Que quieres hacer?");
        System.out.println("Pulsa C para cargar partida");
        System.out.println("Pulsa N para crear una nueva partida");
        
        String  lPartida= src.next();
        

        //Si selecciona cargar ua partida se cargara el fichero de guardado con la partida en curso
            //Ir a la clase de juego
        while(!("c".equals(lPartida) || "C".equals(lPartida)) && !("n".equals(lPartida) || "N".equals(lPartida))){
            System.out.println("Introduce una letra valida");
            lPartida= src.next();
            
            if("c".equals(lPartida) || "C".equals(lPartida)){
            //Llamar al metodo para cargar partida
            }else if("n".equals(lPartida) || "N".equals(lPartida)){
                System.out.println("Pulsa F para facil (de 1 a 15 carácteres)");
                System.out.println("Pulsa D para dificil (más de 15 carácteres)");
            
                String  dPartida= dificultad.next();
                while(!("f".equals(lPartida) || "F".equals(lPartida)) && !("d".equals(lPartida) || "D".equals(lPartida))){
                    System.out.println("Introduce una letra valida");
                    dPartida= dificultad.next();
                    
                    if("f".equals(dPartida)|| "F".equals(dPartida)){
                        p.partida();
                        break;
                    }else if("d".equals(dPartida)|| "D".equals(dPartida)){
                        System.out.println("Estos no hace una puta mierda");
                    }
                }
            }
        }    

    }
}
