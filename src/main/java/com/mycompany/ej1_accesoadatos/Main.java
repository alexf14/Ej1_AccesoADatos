package com.mycompany.ej1_accesoadatos;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

public class Main {

public static void main(String [] arg){
        Partida p=new Partida();
        Fichero_Facil a = new Fichero_Facil();

        System.out.println("¡Bienvenido al juego de adivinar películas!");
        System.out.println("¿Que quieres hacer?");
        System.out.println("Pulsa C para cargar partida");
        System.out.println("Pulsa N para crear una nueva partida");
        

        Scanner src = new Scanner(System.in);
        String  lPartida= src.nextLine();

        //Control errores
        while(!("c".equals(lPartida) || "C".equals(lPartida)) && !("n".equals(lPartida) || "N".equals(lPartida))){
            System.out.println("Introduce una letra valida");
            lPartida= src.nextLine();
        }
        
        if("c".equals(lPartida) || "C".equals(lPartida)){
            //Llamar al metodo para cargar partida
            //Si selecciona cargar ua partida se cargara el fichero de guardado con la partida en curso
            //Ir a la clase de juego
        if("c".equals(lPartida) || "C".equals(lPartida)){
            //Llamar al metodo para cargar partida
        }else if("n".equals(lPartida) || "N".equals(lPartida)){
            System.out.println("Pulsa F para facil (de 1 a 15 carácteres)");
            System.out.println("Pulsa D para dificil (más de 15 carácteres)");
            
            Scanner dificultad = new Scanner(System.in);
            String  dPartida= dificultad.nextLine();
            //Control errores
            while(!("f".equals(dPartida) || "F".equals(dPartida)) && !("d".equals(dPartida) || "D".equals(dPartida))){
                System.out.println("Introduce una letra valida");
                dPartida= dificultad.nextLine();
            }
            //Creacion partida segun la dificultad
            dPartida= dificultad.nextLine();
            
            while(!("f".equals(dPartida) || "F".equals(dPartida)) && !("d".equals(dPartida) || "D".equals(dPartida))){
                System.out.println("Introduce una letra valida");
                dPartida= dificultad.nextLine();
            }    
            
            if("f".equals(dPartida)|| "F".equals(dPartida)){
                p.partida(dPartida);
            }else if("d".equals(dPartida)|| "D".equals(dPartida)){
                p.partida(dPartida);
            }
        }
        
        // esta parte es para ver si quieres seguir jugando despues de acertar
        int contador = 0;
        while(contador != 1){
        
            System.out.println("Quieres volver a jugar?? S/N");
            Scanner npartida = new Scanner(System.in);
            String snpartida = npartida.nextLine();

            if("s".equals(snpartida)|| "S".equals(snpartida)){
                System.out.println("Pulsa F para facil (de 1 a 15 carácteres)");
                System.out.println("Pulsa D para dificil (más de 15 carácteres)");
                
                Scanner dificultad = new Scanner(System.in);
                String  dPartida= dificultad.nextLine();
                
                while(!("f".equals(dPartida) || "F".equals(dPartida)) && !("d".equals(dPartida) || "D".equals(dPartida))){
                    System.out.println("Introduce una letra valida");
                    dPartida= dificultad.nextLine();
                }    
                if("f".equals(dPartida)|| "F".equals(dPartida)){
                    p.partida(dPartida);
                }else if("d".equals(dPartida)|| "D".equals(dPartida)){
                    p.partida(dPartida);
                }
            }
            if("n".equals(snpartida)|| "N".equals(snpartida)){
                 p.cargarPartida();
                contador = 1;
            }
        } 
            }         
        }
    }