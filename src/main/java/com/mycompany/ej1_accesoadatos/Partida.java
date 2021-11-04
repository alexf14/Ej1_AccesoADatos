package com.mycompany.ej1_accesoadatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    
    String fraseRandom;//Palabra para adivinar del random
    int cont;// Puntos  
    char[] peliculaAdivinar ;//array _ par desbloquear letras
    
    public void elegirPalabra (){//Elige palabra random del array list
        Fichero_Facil a = new Fichero_Facil();
        a.palabras();
        int random =(int) Math.floor(Math.random()*(a.arrayFacil.size()-1)+0);
        fraseRandom = a.arrayFacil.get(random);
                
        //falta el que no se repitan las frases
        //Manejar los errores estilo borrar la frase para q no se repita
        //si el arraylist esta vacio volver a llenarlo
        
    }
    
    public void rellenarBarras(){//Relleno el array de char con _ y paso de los espacios
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
        /*
        aqui juego la partida, inicializo los puntos para si despues tengo q guardar la partida
        hago llamadas a los otros metodos para establecer la palabra random y demas
        todo esto es lo q despues si guardo tengo q cargar por lo q no tiene valores por defecto.
            
        */       
    }
    
    public void letraDescubrir(){//Va desvelando el array de char si las letras q yo introduzco estan en el
        Scanner letraIntroducida = new Scanner(System.in);
        String letra;
        letra = letraIntroducida.nextLine();
        letra.toUpperCase();        
        letra.charAt(0);
        
        for(int k=0; k<peliculaAdivinar.length-1; k++){
            if(fraseRandom.charAt(k)== letra.charAt(0)){
                peliculaAdivinar[k]=letra.charAt(0);
            }
        }
    }
}
