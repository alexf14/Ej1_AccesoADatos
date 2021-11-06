package com.mycompany.ej1_accesoadatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Partida {
    
    String fraseRandom;//Palabra para adivinar del random
    int cont;// Puntos  
    char[] peliculaAdivinar ;//array _ para desbloquear letras
    
    
    Fichero_Facil f = new Fichero_Facil();
    Fichero_Dificil d =new Fichero_Dificil();    
    
    public void elegirPalabra (String diff){//Elige palabra random del array list 
        int dificultad;
        if(diff.equals("f")){
            f.palabras();
            int random =(int) Math.floor(Math.random()*(f.arrayFacil.size()-1)+0);
            fraseRandom = f.arrayFacil.get(random);
        }else if(diff.equals("d")){
             d.palabras();
            int random =(int) Math.floor(Math.random()*(d.arrayDificil.size()-1)+0);
            fraseRandom = d.arrayDificil.get(random);
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
        Scanner opciones = new Scanner(System.in);
        
        cont = 2000;
        this.elegirPalabra(diff);
        this.rellenarBarras();
        int contadorD = 0;
        // bucle para saber cuando la partida esta terminada
        for (boolean descubierto = false; !descubierto;) {
            System.out.println(cont);
            for(int k = 0; k < peliculaAdivinar.length; k++ ){
                System.out.print(peliculaAdivinar[k]);
            }
            System.out.println(" ");
            System.out.println(fraseRandom);
            System.out.println("Si quieres introducir una letra pulsa L, si quieres una pista pulsa P, si quieres adivinar la frase pulsa F");
            String  Sopciones= opciones.next();
            //Control errores
            while(!("l".equals(Sopciones) || "L".equals(Sopciones))
                && !("p".equals(Sopciones) || "P".equals(Sopciones))
                && !("f".equals(Sopciones) || "F".equals(Sopciones)))
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
            }
            //me cuenta los asteriscos que quedan para saber cuando tengo q salir del bucle
            for(int x = 0; x < peliculaAdivinar.length; x++){
                if(peliculaAdivinar[x]=='*'){
                   contadorD++; 
                }
            }
            //aqui sale del bucle si se cumple la condicion
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
            System.out.println("Al parecer la letra que has introducido es incorrecta :,-(");
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
    
    public void guardarPartida(){
        try {
            FileWriter save=new FileWriter("PartdiaGuardada.txt");
            save.write(fraseRandom +'\n'+ cont +'\n'+ Arrays.toString(peliculaAdivinar) +'\n'+ f.arrayFacil +'\n'+ d.arrayDificil);
            
            save.close();
        } catch (IOException ex) {
            Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cargarPartida(){
        try {
            FileReader entrada=new FileReader ("PartdiaGuardada.txt");
            BufferedReader lectura=new BufferedReader(entrada);
            String linea="";
            int x=0;
            while(linea!=null){
                linea=lectura.readLine();
                
                /*if(x==0)
                    fraseRandom=linea;
                else if(x==1)
                    cont=linea;
                else if(x==2)
                    peliculaAdivinar=linea;
                else if(x==4)
                    f.arrayFacil=linea;
                else if(x==5)
                    d.arrayDificil=linea;
                x++;*/
            }
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Partida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}