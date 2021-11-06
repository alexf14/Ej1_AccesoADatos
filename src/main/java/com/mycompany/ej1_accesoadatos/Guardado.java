/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ej1_accesoadatos;

import static com.mycompany.ej1_accesoadatos.Fichero_Dificil.arrayDificil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author alexf
 */
public class Guardado {

    String guardar;
    public void palabras(){
        Properties dificultad = new Properties();
        try { 
            dificultad.load(Files.newInputStream(Path.of("palabras.properties"))) ;
            String fileproperties2 = dificultad.getProperty("filepropertiesC");
            Charset charset = StandardCharsets.UTF_8;
            var guardar = Files.readAllLines(Paths.get(fileproperties2), charset);
        }catch(IOException ex){
            System.err.println("error 404");
        }
    }
}
