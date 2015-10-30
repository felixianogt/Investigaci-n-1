#include "simpletools.h"                      // Include simpletools header
#include "ping.h"                             // Include ping header
#include "abdrive.h"

int distance1;                    //distancia 1 mide la distancia del sensor frontal con obstaculo.              
int distance2;                    //distancia 2 mide la distancia del sensor lateral con obstaculo. 
int cont;

#define capacity 100

struct Stack{                      //se crea el stack
	int top;	
	int data[capacity];
} stack;

void push(int value){               //ingresa una posicion al stack
	stack.top++;
	stack.data[stack.top] = value;
}

int pop(){
	int value;                          //retorna la ubicacion guardada. 
	value = stack.data[stack.top];
	stack.top--;
	return (value);
}

int main()                                  
{
  while(1)                                    // se crea un ciclo infinito
  {
    distance1 = ping_cm(8);                    //el sensor frontal va conectado al P8 de la placa
    distance2 = ping_cm(4);                   //el sensor lateral va conectado al P4 de la placa
    
    if(distance2<15){                       //declara que la distancia, reconocida por el sensor lateral, sera de 15 cm
      if(distance1<10){                     //declara que la distancia, reconocida por el sensor frontal, sera de 10 cm
        drive_speed(0, 0);                  //si se encuentra un obstaculo, el robot para
        drive_goto(-25, 26);                //luego girara hacia la izquierda de acuerdo al algoritmo wall follower
        pause(200);
      }
      else{
        drive_speed(64, 64);                //de no encontrar obstaculo, el robot sigue avanzando
        pause(100);
      }                
    }
    
    else{
      drive_speed(0, 0);        
      drive_goto(18, 18);
      pause(200);
      drive_goto(26, -25);          //en caso que exista un camino sin salida, gira hacia la derecha. 
      pause(200);
      drive_goto(30, 30);
      pause(200);
    }                      
  } 
}  
