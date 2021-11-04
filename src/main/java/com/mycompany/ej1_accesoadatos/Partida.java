package com.mycompany.ej1_accesoadatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    
    String fraseRandom;//Palabra para adivinar del random
    int cont;// Puntos
    
    //char[] pelicula;//Array sin _ para comprobar despues
    char[] peliculaAdivinar ;//array _ par desbloquear letras
    
    public void elegirPalabra (){
        Fichero_Facil a = new Fichero_Facil();
        a.palabras();
        int random =(int) Math.floor(Math.random()*(a.arrayFacil.size()-1)+0);
        fraseRandom = a.arrayFacil.get(random);
        //falta el que no se repitan las palabras
    }
    
    public void rellenarAsteriscos(){
        char espacios = ' ';
        peliculaAdivinar= new char [fraseRandom.length()]; 
        for(int k = 0; k < peliculaAdivinar.length; k++){
             peliculaAdivinar[k]=('_');    
        }
        for(int x = 0; x < peliculaAdivinar.length; x++){
            if(fraseRandom.charAt(x)== espacios){
                peliculaAdivinar[x]=' ';
            }
        }      
    }
    
    public void partida(){
        
        
        
        //Random para la sacar titulo random de arraylist
         
        //obtengo la posicion random y la guardo en array
        
        //Relleno uno de los arrays con _
        
    }
    
    public char [] frase(){
        Scanner letraIntroducida = new Scanner(System.in);
        String letra;
        letra = letraIntroducida.nextLine();
        letra.toUpperCase();        
        letra.charAt(0);
        
        for(int k=0; k<peliculaAdivinar.length-1; k++){
            if(pelicula[k]==letra.charAt(0)){
                peliculaAdivinar[k]=letra.charAt(0);
            }
        }
        return peliculaAdivinar;
    }
}
