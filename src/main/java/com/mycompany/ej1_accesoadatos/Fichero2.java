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

public class Fichero2 {
    public ArrayList<String> nombres;

    public void palabras(){
        Properties a = new Properties();
        try { 
            a.load(Files.newInputStream(Path.of("palabras.properties"))) ;
            String fileproperties2 = a.getProperty("fileproperties2");
            Charset charset = StandardCharsets.UTF_8;
            nombres = (ArrayList<String>) Files.readAllLines(Paths.get(fileproperties2), charset);
            }catch(IOException ex){
                System.err.println("error 404");
            }
    }
}
