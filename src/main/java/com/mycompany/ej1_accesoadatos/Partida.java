package com.mycompany.ej1_accesoadatos;

import java.io.*;
import java.util.ArrayList;

public class Partida {
    char[] pelicula;
    
    int cont=2000;
    
    public Partida() {
    }

    public String partida(String letra){
        Fichero_Facil f=new Fichero_Facil();
        
        ArrayList<String> arrayFacil = f.arrayFacil;
        int random = (int) (Math.random()* (f.arrayFacil.size()-1));
        
        
        
        letra.toUpperCase();        
        letra.charAt(0);
        
        return null;
    }
}
