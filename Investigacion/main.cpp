#include "simpletools.h"                      // Include simpletools header
#include "ping.h"                             // Include ping header
#include "abdrive.h"

int distance1;                                 
int distance2;
int cont;

#define capacity 100

struct Stack{
	int top;	
	int data[capacity];
} stack;

void push(int value){
	stack.top++;
	stack.data[stack.top] = value;
}

int pop(){
	int value;
	value = stack.data[stack.top];
	stack.top--;
	return (value);
}

int main()                   
{
  while(1)                                    // Repeat indefinitely
  {
    distance1 = ping_cm(8);                    
    distance2 = ping_cm(4);
    
    if(distance2<15){
      if(distance1<10){
        drive_speed(0, 0);
        drive_goto(-25, 26);
        pause(200);
      }
      else{
        drive_speed(64, 64);
        pause(100);
      }                
    }
    
    else{
      drive_speed(0, 0);
      drive_goto(18, 18);
      pause(200);
      drive_goto(26, -25);
      pause(200);
      drive_goto(30, 30);
      pause(200);
    }                      
  } 
}  
