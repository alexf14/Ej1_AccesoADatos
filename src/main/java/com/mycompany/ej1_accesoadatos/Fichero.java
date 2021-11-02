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

public class Fichero implements Serializable{
    public ArrayList<String> nombres;

    public void palabras(){
        Properties a = new Properties();
        try { 
            a.load(Files.newInputStream(Path.of("palabras.properties"))) ;
            String fileproperties = a.getProperty("fileproperties");
            Charset charset = StandardCharsets.UTF_8;
            nombres = (ArrayList<String>) Files.readAllLines(Paths.get(fileproperties), charset);
            }catch(IOException ex){
                System.err.println("error 404");
            }
    }
}

