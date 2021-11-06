package com.mycompany.ej1_accesoadatos;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Scanner;

public class Main  implements Serializable{
    static Partida p=new Partida();
    Guardado c = new Guardado();

public static void main(String [] arg){

        System.out.println("-------------------------------------------");
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
            cargarPartida();
            p.partida("c");
            //Llamar al metodo para cargar partida
            //Si selecciona cargar ua partida se cargara el guardar de guardado con la partida en curso
            //Ir a la clase de juego
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
                contador = 1;
            }
        } 
    }

    public void guardarPartida(Partida p){
        try {
                FileOutputStream guardar = null;
                guardar = new FileOutputStream ("c.guardar");
                ObjectOutputStream guardado = new ObjectOutputStream (guardar);
                guardado.writeObject(p);
                System.out.println("sisi, se ha guardado");

        } catch (FileNotFoundException ex) {
           System.err.println("Ha habido un error en FileNotFound del guardado");
        } catch (IOException ex) {
           System.err.println("Ha habido un error en IOException del guardado");

        }
        
    }
    
     public static void cargarPartida () {
        try ( var cPartida = new ObjectInputStream( new BufferedInputStream(Files.newInputStream(Path.of("c.guardar"), CREATE)));) {
               p =  (Partida) cPartida.readObject();
        } catch (IOException ex) {
             System.err.println("Ha habido un error en IOException del cargado");
        } catch (ClassNotFoundException ex) {
              System.err.println("Ha habido un error en ClassNotFound del cargado");

        }

    }
}