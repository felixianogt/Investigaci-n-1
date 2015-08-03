/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja3.pkg1;

import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 *
 * @author carlosmartinez
 */
public class modulo implements generador{

       

    @Override
    public boolean guardarRnd(int x) {
        
        SinglyLinkedList lista1; 
        lista1 = new SinglyLinkedList();
        
        
        
        boolean contiene=lista1.isEmpty();
        while(contiene==true){
           
        for(int i=0;i<x;i++){
            Random rand = new Random(); 
            int value; 
            value = rand.nextInt(x);
            String valor= Integer.toString(value);
            lista1.addFirst(valor);
        try{
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo=new File("numerosDesorden.txt");
            
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir=new FileWriter(archivo,true);

            //Escribimos en el archivo con el metodo write 
            escribir.write(valor);

            //Cerramos la conexion
            escribir.close();
            }

            //Si existe un problema al escribir cae aqui
            catch(Exception e)
            {
            System.out.println("Error al escribir");
            }

            }
        }
            return false;
    }

    public void leerArchivo1(){
        String texto="";

        try
        {
        //Creamos un archivo FileReader que obtiene lo que tenga el archivo
        FileReader lector=new FileReader("numerosDesorden.txt");

        //El contenido de lector se guarda en un BufferedReader
        BufferedReader contenido=new BufferedReader(lector);

        //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
        while((texto=contenido.readLine())!=null)
        {
        System.out.println(texto);
        }
        }

        //Si se causa un error al leer cae aqui
        catch(Exception e)
        {
        System.out.println("Error al leer");
        }
    
    
    }
    
    
    
    @Override
    public boolean Ordenar(String lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardarOrd(int x) {
        return false;
    }

    
    
    
    @Override
    public void leerArchivo2() {
        String texto="";

        try
        {
        //Creamos un archivo FileReader que obtiene lo que tenga el archivo
        FileReader lector=new FileReader("numerosOrden.txt");

        //El contenido de lector se guarda en un BufferedReader
        BufferedReader contenido=new BufferedReader(lector);

        //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
        while((texto=contenido.readLine())!=null)
        {
        System.out.println(texto);
        }
        }

        //Si se causa un error al leer cae aqui
        catch(Exception e)
        {
        System.out.println("Error al leer");
        }
    
    
    
    
    }

   
    

    
    
    
}
