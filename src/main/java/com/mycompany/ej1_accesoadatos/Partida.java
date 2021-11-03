package com.mycompany.ej1_accesoadatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    String array;
    int cont=2000;
     Scanner letraIntroducida = new Scanner(System.in);
    
    public Partida() {
    }

    public char[] partida(String letra){
        //creacion objeto properties
        Fichero_Facil f=new Fichero_Facil();
        //Random para la sacar titulo random de arraylist
        int random = (int) (Math.random()* (f.arrayFacil.size()-1));
        //obtengo la posicion random y la guardo en array
        array = f.arrayFacil.get(random);
        //Creacion dos array para recorrer y mostrar 
        //con el contenido de la ubicacion de random
        char[] pelicula = array.toCharArray();
        char[] peliculaAdivinar = array.toCharArray();
        //Relleno uno de los arrays con _
        for(int k = 0; k < peliculaAdivinar.length; k++){
            peliculaAdivinar[k]=('_');   
        }
        //Introduccion letra
        letra = letraIntroducida.nextLine();
        letra.toUpperCase();        
        letra.charAt(0);
        
     return pelicula;
    }
}
