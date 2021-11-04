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
        
        String  lPartida= src.nextLine();
        lPartida.toUpperCase();

        //Si selecciona cargar ua partida se cargara el fichero de guardado con la partida en curso
            //Ir a la clase de juego
            
        if(lPartida == "C"){
            //Llamar al metodo para cargar partida
        }else if(lPartida == "N"){
            System.out.println("Pulsa F para facil (de 1 a 15 carácteres)");
            System.out.println("Pulsa D para dificil (más de 15 carácteres)");
            
            String  dPartida= src.nextLine();
            dPartida.toUpperCase();
            
            if(dPartida == "F"){
                p.elegirPalabra();
                p.rellenarBarras();
            
            }
        }
    }
}
