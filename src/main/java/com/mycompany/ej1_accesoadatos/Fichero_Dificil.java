package com.mycompany.ej1_accesoadatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

public class Fichero_Dificil {
    public ArrayList<String> arrayDificil;

    public void palabras(){
        Properties dificultad = new Properties();
        try { 
            dificultad.load(Files.newInputStream(Path.of("palabras.properties"))) ;
            String fileproperties2 = dificultad.getProperty("filepropertiesD");
            Charset charset = StandardCharsets.UTF_8;
            arrayDificil = (ArrayList<String>) Files.readAllLines(Paths.get(fileproperties2), charset);
            }catch(IOException ex){
                System.err.println("error 404");
            }
    }
}
