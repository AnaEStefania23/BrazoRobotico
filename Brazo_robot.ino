// Incluímos la librería para poder controlar el servo
#include <Servo.h>

// Iniciamos el servo para que empiece a trabajar con los pines asignados
//declaramos la parte que manejara el hombro
Servo servoHombro;     
//declaramos la parte que manejara el codo
Servo servoCodo;       
//declaramos la parte que manejara la pinza
Servo servoPinza;      

//Inicializamos las variables para controlar el motor a pasos
#define IN1  12
#define IN2  11
#define IN3  10
#define IN4  9

//variable para indicar que el brazo debe ejecutarse
char cr;              
//variable del led que indica que el brazo esta en movimiento
int pausa = 7;        
//variable del led que indica que el brazo no esta en ejecucion 
int inicia = 8;       
//Variable que guardara el valor que se envia si el boton de subir fue ejecutado en la interfaz
char a;               
//Variable que guardara el valor que se envia si el boton de regresar fue ejecutado en la interfaz
char b;               
//Variable que guardara el valor que se envia si el boton de abrir fue ejecutado en la interfaz
char c;               
//Variable que guardara el valor que se envia si el boton de izquierda fue ejecutado en la interfaz
char d;               
//Variable que guardara el valor que se envia si el boton de bajar fue ejecutado en la interfaz
char g;               
//Variable que guardara el valor que se envia si el boton de avanzar fue ejecutado en la interfaz
char h;               
//Variable que guardara el valor que se envia si el boton de cerrar fue ejecutado en la interfaz
char i;               
//Variable que guardara el valor que se envia si el boton de derecha fue ejecutado en la interfaz
char j;               
//Valor de los pasos que ha dado el motor
int numero_pasos = 0; 
//Velocidad del Motor, tiempo de retardo en milisegundos 
int retardo = 5;      

//inicializacion de los pines que se ocuparan en el arduino
void setup() {
   // se inicializa el serial.
  Serial.begin(9600);
  //configuracion de entradas y salidas
  //Iniciamos la variable INI1 para el manejo del motor a pasos como salida
  pinMode(IN1, OUTPUT);      
  //Iniciamos la variable INI2 para el manejo del motor a pasos como salida
  pinMode(IN2, OUTPUT);      
  //Iniciamos la variable INI3 para el manejo del motor a pasos como salida
  pinMode(IN3, OUTPUT);      
  //Iniciamos la variable INI4 para el manejo del motor a pasos como salida
  pinMode(IN4, OUTPUT);      
  //Incializacion del servo que hara el movimiento del hombro en el pin 3
  servoHombro.attach(3);     
  //Incializacion del servo que hara el movimiento del codo en el pin 6
  servoCodo.attach(6);       
  //Incializacion del servo que hara el movimiento de la pinza en el pin 5
  servoPinza.attach(5); 
  //Incializacion del led pausa como salida     
  pinMode(pausa, OUTPUT);    
  //Incializacion del led inica como salida     
  pinMode(inicia, OUTPUT);
  //Inicializacion del pin 2 donde se encuentra el boton como entrada.
  pinMode(2, INPUT);
  }

//Esta funcion se ejecutara mientras se este eneergizndo el arduino
void loop() {
  //prende el led inicia;
  digitalWrite(inicia, HIGH);
  //enciende el dedl pausa
  digitalWrite(pausa, LOW);
  //Se guardaran en las variables asignadas los valores que se envien desde la interfaz por medio del puerto serial 
  cr = Serial.read();
  a = Serial.read();
  b = Serial.read();
  c = Serial.read();
  d = Serial.read();
  g = Serial.read();
  h = Serial.read();
  i = Serial.read();
  j = Serial.read();
 
//Si el valor que se envio fue un 9 se ejecutara los movimientos del brazo 
  if (cr == '9') {
    //inicia la variable pulsador para leer el estado del boton 
    int  pulsador = digitalRead(2);
    //Mientras el boton no sea presionado  se repetira la secuencia de pasos
    while (pulsador == 0) {
      //enciende el led inicia
      digitalWrite(inicia, LOW);
      //apaga el led pausa
      digitalWrite(pausa, HIGH);
      //Espera un tiempo de 200 milisegundos 
      delay(2000);
      //Acontinuacion verificara los valores que fueron almacenados en las variables
      //Si el valor en la variable a es igual a 1
      if (a == '1') {
        //Ejecuta le metodo arriba
        arriba(); 
        //Espera un tiempo de 200 milisegundos 
        delay(2000);
      }//Fin del primer if

      //Si el valor en la variable es iguala 2
      if (b == '2') {
        //Ejecuta el metodo reegresa
        regresa();
        //Espera un tiempo de 200 milisegundos 
        delay(2000);
      }

      //Si el vlor en la variable c es igual a 3
      if (c == '3') {
        //Ejecuta el metodo abre
        abre();
        //Espera un tiempo de 200 milisegundos 
        delay(2000);
      }

      //Si el valor en la variable d es igual a 4
      if (d == '4') {
        //Giro hacia la iquierda 
        while (200 > numero_pasos) {
          paso_izq();
          numero_pasos = numero_pasos + 1;
        }
        //Espera un tiempo de 100 milisegundos 
        delay(1000);
        //Apaga el motor a pasos
        apagado();
      }

      //Si el valor en la variable g es igual a 5
      if (g == '5') {
        //Ejecuta le metodo abajo
        abajo(); 
        //Espera un tiempo de 200 milisegundos 
        delay(2000);
      }

      //Si el valor en la variable h es igual a 6
      if (h == '6') {
        //Ejecuta le metodo avanza
        avanza();
        //Espera un tiempo de 200 milisegundos 
        delay(2000);
      }

      //Si el valor en la variable i es iguak a 7
      if (i == '7') {
        //Ejecuta le metodo cierra
        cierra(); 
        //Espera un tiempo de 200 milisegundos 
        delay(2000);
      }
      
      //Si el valor en la variable j es igual a 8
      if (j == '8') {
        //Giro hacia la derecha
          while (100 < numero_pasos) {
          paso_der();
          numero_pasos = numero_pasos - 1;
        }
        //Espera un tiempo de 100 milisegundos 
        delay(1000);
        //Apaga el motor a passo 
        apagado();
      }
      //Lee el estado del boton, si fue presionado o no 
      pulsador = digitalRead(2); 
    }//Fin del while
  } //Fin del if 
  
  //Las variables toman el valor de nulo para la nueva lectura de los datos
  a = '\0';
  b = '\0' ;
  c = '\0';
  d = '\0';
  g = '\0';
  h = '\0';
  i = '\0';
  j = '\0';
  cr = '\0';
  //Espera un tiempo de 200 milisegundos 
  delay(2000);

}

//Movimiento del hombro hacia arriba
void arriba() {
   //angulacion
  servoHombro.write(10);
}

//  Movimiento del hombro hacia abajo
void abajo() {
//angulacion
  servoHombro.write(60);

}

//Movimiento del codo hacia adelante
void avanza() { 
  //angulacion
  servoCodo.write(50);

}

//Movimiento del codo hacia atras
void regresa() {
//angulacion 
  servoCodo.write(20);
}

//Movimiento  que  abre la pinza
void abre() {
  servoPinza.write(0);// angulacion y separacion

}

//Movimiento que cierra la pinza
void cierra() {
  //angulacion de  cierre
  servoPinza.write(90);

}

// Pasos a la derecha
void paso_der() {
  digitalWrite(12, LOW);
  digitalWrite(11, LOW);
  digitalWrite(10, HIGH);
  digitalWrite(9, HIGH);
  delay(retardo);
  digitalWrite(12, LOW);
  digitalWrite(11, HIGH);
  digitalWrite(10, HIGH);
  digitalWrite(9, LOW);
  delay(retardo);
  digitalWrite(12, HIGH);
  digitalWrite(11, HIGH);
  digitalWrite(10, LOW);
  digitalWrite(9, LOW);
  delay(retardo);
  digitalWrite(12, HIGH);
  digitalWrite(11, LOW);
  digitalWrite(10, LOW);
  digitalWrite(9, HIGH);
  delay(retardo);
}

// Pasos a la izquierda
void paso_izq() {
  digitalWrite(12, HIGH);
  digitalWrite(11, HIGH);
  digitalWrite(10, LOW);
  digitalWrite(9, LOW);
  delay(retardo);
  digitalWrite(12, LOW);
  digitalWrite(11, HIGH);
  digitalWrite(10, HIGH);
  digitalWrite(9, LOW);
  delay(retardo);
  digitalWrite(12, LOW);
  digitalWrite(11, LOW);
  digitalWrite(10, HIGH);
  digitalWrite(9, HIGH);
  delay(retardo);
  digitalWrite(12, HIGH);
  digitalWrite(11, LOW);
  digitalWrite(10, LOW);
  digitalWrite(9, HIGH);
  delay(retardo);
}

// Apagado del Motor
void apagado() {
  digitalWrite(12, LOW);
  digitalWrite(11, LOW);
  digitalWrite(10, LOW);
  digitalWrite(9, LOW);
}
