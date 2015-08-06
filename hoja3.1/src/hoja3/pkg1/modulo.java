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
    public boolean guardarRnd(SinglyLinkedList lista1,int x) {
        int cont=0;
        
        
        
        boolean contiene=lista1.isEmpty();
        //while(contiene==true){
           
        for(int i=0;i<x;i++){
            Random rand = new Random(); 
            int value; 
            value = rand.nextInt(10);
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
        cont++;
        System.out.println(cont);
        //}
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
    
    /**
     *
     * @param lista1
     * @return
     */
     /*public void selectionSort(SinglyLinkedList lista1) {
        if(lista1.isEmpty())
            System.out.println("List is currently empty.");
        else if (lista1.size() == 1)
            System.out.println("List is already sorted.");
        else{}
    }*/
    
     /*public void bubbleSort(SinglyLinkedList lista1) {
        if(lista1.isEmpty())
            System.out.println("List is currently empty.");
        else if (lista1.size() == 1)
            System.out.println("List is already sorted.");
        else {
            Node current = (Node) lista1.getFirst();
            Node counter = current;
            while(counter.next().next() != null) {
                current = counter;
                while(current.next() != null) {
                    if(current.value() > current.next().value()) {
                        int temp = (int) current.value();
                        current.setValue(current.next().value());
                        current.next().setValue(temp);
                    }
                    current = current.next();
                }
                counter = counter.next();
            }
        }
    }*/
    
    public void selectionSort(SinglyLinkedList list) {
        int iterationsINNER = 1, iterationsOUTER = 1, swaps = 0, comparisons = 1;
        if(list.isEmpty())
            System.out.println("List is currently empty.");
        else if (list.size() == 1)
            System.out.println("List is already sorted.");
        else {
            Node pointer = (Node) list.getFirst();
            Node current;
            boolean exchangeMade;
            while (pointer.next().next() != null) {
                current = pointer;
                exchangeMade = false;
                iterationsOUTER++;
                while (current.next() != null && !exchangeMade) {
                    if(current.next().value() < pointer.value()) {
                        int temp = (int) pointer.value();
                        pointer.setValue(current.next().value());
                        current.next().setValue(temp);
                        exchangeMade = true;
                        iterationsINNER++;
                        swaps++;
                        comparisons++;
                    } else {
                    }
                    current = current.next();
                }
                pointer = pointer.next();
            }
          //  System.out.println("Comparisons: " + comparisons + " \nSwaps: " + swaps + " \nIterations: " + iterationsINNER+iterationsOUTER);
        }
    }
    
    
    
    @Override
    public boolean guardarOrd(SinglyLinkedList lista1) {
       int cont=0;
        
        
        
        boolean contiene=lista1.isEmpty();
        //while(contiene==true){
            String valor=(String) lista1.getFirst();
            lista1.addFirst(valor);
        try{
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo=new File("numerosOrden.txt");
            
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

            
        cont++;
        System.out.println(cont);
        //}
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
