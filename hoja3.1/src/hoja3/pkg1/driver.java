/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja3.pkg1;
import javax.swing.*;
/**
 *
 * @author carlosmartinez
 */
public class driver{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList lista1; 
        lista1 = new SinglyLinkedList();
        
        int a=Integer.parseInt(JOptionPane.showInputDialog("ingrese cantidad"));
        modulo prueba=new modulo();
        prueba.guardarRnd(lista1,a);
        prueba.leerArchivo1();
        
        prueba.selectionSort(lista1);
        //prueba.bubbleSort(lista1);
        prueba.guardarOrd(lista1);
        prueba.leerArchivo2();
        
        
        
    }
    
}
