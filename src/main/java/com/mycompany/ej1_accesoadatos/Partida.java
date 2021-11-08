package com.mycompany.ej1_accesoadatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida implements Serializable{
    
    String fraseRandom;//Palabra para adivinar del random
    int cont;// Puntos  
    char[] peliculaAdivinar ;//array _ para desbloquear letras    
    ArrayList<String> arrFacil = new ArrayList<>();
    ArrayList<String> arrDificil = new ArrayList<>();
    
    public void elegirPalabra (String diff){//Elige palabra random del array list segun la dificultad
        int dificultad;

        
        if(diff.equals("f")){
            if(arrFacil.size()==0){
                rellenarArray();
            }
            int random =(int) Math.floor(Math.random()*(arrFacil.size()-1)+0);
            fraseRandom = arrFacil.get(random);

            arrFacil.remove(random);
        }else if(diff.equals("d")){
            if(arrDificil.size() == 0){
               rellenarArray();
            }
            int random =(int) Math.floor(Math.random()*(arrDificil.size()-1)+0);
            fraseRandom = arrDificil.get(random);

            arrDificil.remove(random);
        }
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
    
    public void partida(String diff){
        Guardado g=new Guardado();
        Scanner opciones = new Scanner(System.in);
                
 
            this.elegirPalabra(diff);
            this.rellenarBarras();
            asignarPuntos();

        int contadorD = 0;
            
            // bucle para saber cuando la partida esta terminada
            
            for (boolean descubierto = false; !descubierto;) {
                System.out.println("---------------------------------------------------------");
                System.out.println("Puntuación: " + cont);
                for(int k = 0; k < peliculaAdivinar.length; k++ ){
                    System.out.print(peliculaAdivinar[k]);
                }
                
            System.out.println(" ");
            System.out.println("Si quieres introducir una letra pulsa L,\n" + 
                    "si quieres una pista pulsa P,\n" + 
                    "si quieres adivinar la frase pulsa F,\n" + 
                    "y si quieres guardar partida pulsa G");
            
            String  Sopciones= opciones.next();
            //Control errores
            while(!("l".equals(Sopciones) || "L".equals(Sopciones))
                && !("p".equals(Sopciones) || "P".equals(Sopciones))
                && !("f".equals(Sopciones) || "F".equals(Sopciones))
                && !("g".equals(Sopciones) || "G".equals(Sopciones)))
            {    
                System.out.println("Introduce una letra valida");
                Sopciones= opciones.next();
            }
            //opciones a la hora de jugar
            if("l".equals(Sopciones) || "L".equals(Sopciones)){
            this.letraDescubrir();
            }else if("p".equals(Sopciones) || "P".equals(Sopciones)){
                this.pista();
            }else if("f".equals(Sopciones) || "F".equals(Sopciones)){
                this.adivinarFrase();
            }else if("g".equals(Sopciones) || "G".equals(Sopciones)){
                g.guardarPartida(this);
            }
            //me cuenta los asteriscos que quedan para saber cuando tengo q salir del bucle
            for(int x = 0; x < peliculaAdivinar.length; x++){
                if(peliculaAdivinar[x]=='*'){
                   contadorD++; 
                }
            }
            //aqui sale del bucle si se cumple la condicion
            if(cont <= 0){
                System.out.println("Lo siento te has quedado sin puntos");
                break;
            }
            
            if(contadorD==0){
                System.out.println(fraseRandom);
                System.out.println("FELICIDADES TE HAS QUEDADO CON "+ cont +" PUNTOS");
                descubierto = true;
            }
            contadorD = 0;
        }       
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
            System.out.println("Al parecer la letra que has introducido es incorrecta");
            cont=cont-50;
        }
    }
    
    public void pista(){//aqui desbloqueo letra random para dar una pista
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
    
    public void adivinarFrase() {//aqui doy la posibilidad de descubrir la frase si la se
        Scanner introducida = new Scanner(System.in);
        String intentoFrase = introducida.nextLine();
        String  mayus = intentoFrase.toUpperCase();
            if (!fraseRandom.equals(mayus)) {
                System.out.println("Lo siento, al parecer la frase es incorrecta");
                cont = cont - 500;
            } else {
                for (int k = 0; k < peliculaAdivinar.length; k++) {
                    peliculaAdivinar[k] = mayus.charAt(k);
                }
            }
    }
    
    public void asignarPuntos(){
        this.cont = 2000;        
    }
    
    public void rellenarArray(){
        Fichero_Facil f=new Fichero_Facil();
        f.palabras();
        this.arrFacil= (ArrayList<String>) f.arrayFacil.clone(); 
        
        Fichero_Dificil d=new Fichero_Dificil();
        d.palabras();
        this.arrDificil= (ArrayList<String>) d.arrayDificil.clone();
    }
}