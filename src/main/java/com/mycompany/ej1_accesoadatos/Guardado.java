package com.mycompany.ej1_accesoadatos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Guardado implements Serializable{
        public static void guardarPartida (Partida p){

            try { 
            FileOutputStream fichero = null; 
            fichero = new FileOutputStream ("PartidaGuardada.txt"); 
            ObjectOutputStream save = new ObjectOutputStream (fichero);
            save.writeObject(p);
            System.out.println("Se ha guardado la partida");
            } catch (FileNotFoundException ex) {
           System.err.println("El fichero no se encuentra por FileNotFoundException");
        } catch (IOException ex) {
           System.err.println("Existe un error IOException");
        }
    }


    public static void cargarPartida () {
        try ( var cat = new ObjectInputStream( new BufferedInputStream(Files.newInputStream(Path.of("PartidaGuardada.txt"), CREATE)));) {
               var p =  (Partida) cat.readObject();
        } catch (IOException ex) {
             System.err.println("Ha habido un error en IOException del cargado");
        } catch (ClassNotFoundException ex) {
              System.err.println("Ha habido un error en ClassNotFound del cargado");

        }
    }
}

