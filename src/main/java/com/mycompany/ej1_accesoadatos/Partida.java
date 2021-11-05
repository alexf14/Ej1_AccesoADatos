package com.mycompany.ej1_accesoadatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
    
    String fraseRandom;//Palabra para adivinar del random
    int cont;// Puntos  
    char[] peliculaAdivinar ;//array _ par desbloquear letras
    
    
    Fichero_Facil a = new Fichero_Facil();
    public void elegirPalabra (){//Elige palabra random del array list 
        a.palabras();
        int random =(int) Math.floor(Math.random()*(a.arrayFacil.size()-1)+0);
        fraseRandom = a.arrayFacil.get(random);
        //Manejar los errores estilo borrar la frase para q no se repita
        //si el arraylist esta vacio volver a llenarlo
        
    }
    
    public void rellenarBarras(){//Relleno el array de char con _ y paso de los espacios
        char espacios = ' ';
        peliculaAdivinar= new char [fraseRandom.length()]; 
        for(int k = 0; k < peliculaAdivinar.length; k++){
             peliculaAdivinar[k]=('*');    
        }
        for(int x = 0; x < peliculaAdivinar.length; x++){
            if(fraseRandom.charAt(x)== espacios){
                peliculaAdivinar[x]=' ';
            }
        }    
    }
    
    public void partida(){
        Scanner opciones = new Scanner(System.in);
        
        cont = 2000;
        this.elegirPalabra();
        this.rellenarBarras();
        int contadorD = 0;
        
        for (boolean descubierto = false; !descubierto;) {
            System.out.println(cont);
            for(int k = 0; k < peliculaAdivinar.length; k++ ){
                System.out.print(peliculaAdivinar[k]);
            }
            System.out.println(" ");
            System.out.println(fraseRandom);
            System.out.println("Si quieres introducir una letra pulsa L, si quieres una pista pulsa P");
            String  Sopciones= opciones.next();
            if("l".equals(Sopciones) || "L".equals(Sopciones)){
            this.letraDescubrir();
            }else if("p".equals(Sopciones) || "P".equals(Sopciones)){
                this.pista();
            }
            
            for(int x = 0; x < peliculaAdivinar.length; x++){
                if(peliculaAdivinar[x]=='*'){
                   contadorD++; 
                }
            }
            if(contadorD==0){
                System.out.println(fraseRandom);
                System.out.println("FELICIDADES TE HAS QUEDADO CON "+ cont +" PUNTOS");
                descubierto = true;
            }
            contadorD = 0;
        }
        
        /*
        aqui juego la partida, inicializo los puntos para si despues tengo q guardar la partida
        hago llamadas a los otros metodos para establecer la palabra random y demas
        todo esto es lo q despues si guardo tengo q cargar por lo q no tiene valores por defecto.      
        */       
    }
    
    public void letraDescubrir(){//Va desvelando el array de char si las letras q yo introduzco estan en el
        Scanner letraIntroducida = new Scanner(System.in);
        char letra = letraIntroducida.next().charAt(0);
        char fUpper =Character.toUpperCase(letra);
        letra = fUpper;
        
        boolean acierto=false;
        
        for(int k=0; k < peliculaAdivinar.length; k++){
            if(fraseRandom.charAt(k)== letra){
                peliculaAdivinar[k]=letra;
                acierto=true;
            }
        }
        
        if(!acierto){
            System.out.println("Al parecer la letra que has introducido es incorrecta :,-(");
            cont=cont-50;
        }
    }
    public void pista(){
        int posPista=(int) (Math.random()*(peliculaAdivinar.length-1)+0);
        while((peliculaAdivinar[posPista]==' ') || (peliculaAdivinar[posPista]!='*')){
            posPista=(int) (Math.random()*(peliculaAdivinar.length-1)+0);
        }
        
        char letraPista=fraseRandom.charAt(posPista);
        
        for(int k=0; k<peliculaAdivinar.length-1; k++){
            if(fraseRandom.charAt(k)==letraPista){
                peliculaAdivinar[k]=letraPista;
            }
        }
        cont=cont-200;
    }
}
