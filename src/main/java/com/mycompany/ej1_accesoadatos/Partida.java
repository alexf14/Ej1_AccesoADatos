package com.mycompany.ej1_accesoadatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    Fichero_Facil f=new Fichero_Facil();
    String arrayF;
    int cont=2000;
    Scanner letraIntroducida = new Scanner(System.in);
    
    public Partida() {
    }

    public char[] partida(String letra){
        //Random para la sacar titulo random de arraylist
        int random =(int) Math.floor(Math.random()*(Fichero_Facil.arrayFacil.size()-1)+0); 
        //obtengo la posicion random y la guardo en array
        arrayF = Fichero_Facil.arrayFacil.get(random);
        //Creacion dos array para recorrer y mostrar 
        //con el contenido de la ubicacion de random
        char[] pelicula = arrayF.toCharArray();
        char[] peliculaAdivinar = arrayF.toCharArray();
        //Relleno uno de los arrays con _
        for(int k = 0; k < peliculaAdivinar.length; k++){
            if(pelicula[k]!=' '){
                peliculaAdivinar[k]=('_');
            }
            
            System.out.print( peliculaAdivinar[k]);
        }
        //Introduccion letra
        letra = letraIntroducida.nextLine();
        letra.toUpperCase();        
        letra.charAt(0);
        
        for(int k=0; k<peliculaAdivinar.length-1; k++){
            if(pelicula[k]==letra.charAt(0)){
                peliculaAdivinar[k]=letra.charAt(0);
            }
        }
        
     return pelicula;
    }
}
