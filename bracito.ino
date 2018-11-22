// Incluímos la librería para poder controlar el servo
#include <Servo.h>
 
// Declaramos la variable para controlar el servo
Servo hombro;
Servo codo;
Servo pinza;

//Inicia la declaracion de las variables y constantes
//Variable que recibe los datos de java a Arduino
char variable;
//Variable que junta todos los caracteres en una sola instruccion
String cadena;
//Declaracion del arreglo que guardara los movimientos del brazo
String arreglo[30];
//Declaracion de contador para el movimiento del arreglo
int cont = 0;
//Variable que recibe el numero de movimientos que se recibieron en Java
int tamArr = 0;
//Declaracion del boton de paro total
boolean btnparo = true;
//Variable que contiene los grados para mover los servo y motor a pasos
int anguH = 10, anguC = 180 , anguP = 20;

//Declara Pin LED Rojo
int ledRojo = 1;
//Declara Pin LED Verde
int ledVerde=2; 
//Declara Pin LED Azul
int ledAzul=3;
 
//Declaracion de pines para el motor a pasos
const int motorPin1 = 8;    // 28BYJ48 In1
const int motorPin2 = 9;    // 28BYJ48 In2
const int motorPin3 = 10;   // 28BYJ48 In3
const int motorPin4 = 11;   // 28BYJ48 In4

//Declaracion de variables para el control del motor a pasos
//Variable para fijar la velocidad
int motorSpeed = 1200;
//Contador para los pasos
int stepCounter = 0;
//Pasos para una vuelta completa
int stepsPerRev = 4076;
//Variable que contiene el numero de pasos para dar media vuelta
const int numSteps = 8;
//Declaracion de la variable para el controlador del motor a pasos
const int stepsLookup[8] = { B1000, B1100, B0100, B0110, B0010, B0011, B0001, B1001 };

//Inicio del metodo setup
void setup() {
  //Iniciamos la comunicacion con el puerto serial.
  Serial.begin(9600);
  //Asignacion de pines para cada servo
  hombro.attach(2);
  codo.attach(3);
  pinza.attach(4);

   //Declaracion de variable para los colores del Led RGB
  //El LED Rojo como una salida
  pinMode(ledRojo,OUTPUT);
  //El LED Verde como una salida
  pinMode(ledVerde,OUTPUT); 
  //El LED Azul como una salida
  pinMode(ledAzul,OUTPUT); 
   
  //declarar pines del motor a pasos como salida
  pinMode(motorPin1, OUTPUT);
  pinMode(motorPin2, OUTPUT);
  pinMode(motorPin3, OUTPUT);
  pinMode(motorPin4, OUTPUT);
}
//Finalizacion de la declaracion de las variables y constantes

void loop() {

  variable = Serial.read();
  
  switch(variable)
  {
    case 'A':
      hombros(anguH);
      anguH += 10;
      break;
    case 'B':
      anguH -= 10;
      hom(anguH);
      break;   
    case 'C':
      brazo(anguC);
      anguC += 10;
      break;
    case 'D':
      anguC -= 10;
      antebrazo(anguC);
      break;
    case 'E':
      pinzas(anguP);
      anguP += 10;
      break;
    case 'F':
      anguP -= 10;
      pinzas2(anguP);
      break;
    case '1':
    for (int i = 0; i < stepsPerRev; i++) {
            anticlockwise();
            delayMicroseconds(motorSpeed);
          }
    break;
    case '2':
    for (int i = 0; i < stepsPerRev; i++) {
            clockwise();
            delayMicroseconds(motorSpeed);
           }
    break;

     break;
    case 'R':
      color(0,255,0);
      delay(1000);
      break;
    case 'P':
      color(0,0,255);
      delay(1000);
      break;
  }
}
//hombro
void hombros(int an)
{
  if (an <= 180)
  {
    // Desplazamos al ángulo correspondiente
    hombro.write(an);
  }
}

void hom(int bro)
{
  if (bro >= 10 && bro <= 180)
  {
    // Desplazamos al ángulo correspondiente
    hombro.write(bro);
  }
}
//antebrazo/codo
void antebrazo(int lo)
{
  if (lo >= 8 && lo <= 180)
  {
    // Desplazamos al ángulo correspondiente
    codo.write(lo);
  }
}

void brazo(int lol)
{
  if (lol <= 180 && lol >= 8)
  {
    // Desplazamos al ángulo correspondiente
    codo.write(lol);
  }
}

//pinzas
void pinzas(int pinz)
{
  if(pinz >= 20 && pinz <= 110)
  {
    //Desplazamos al angulo correspondiente
    pinza.write(pinz);
  }
}

void pinzas2(int pinz2)
{
  if(pinz2 <= 110 && pinz2 >= 20)
  {
    //Desplazamos al angulo correspondiente
    pinza.write(pinz2);
  }
}

void color(int rojo, int verde, int azul){
//Escritura de PWM del color Rojo
analogWrite(ledRojo, 255-rojo);
//Escritura de PWM del color Verde
analogWrite(ledVerde, 255-verde);
//Escritura de PWM del color Azul
analogWrite(ledAzul, 255-azul);
}




//BASE DEL BRAZO
//Movimiento del motor a pasos hacia la derecha
void clockwise() {
  stepCounter++;
  if (stepCounter >= numSteps) stepCounter = 0;
  setOutput(stepCounter);
}

//Movimiento del motor a pasos hacia la izquierda
void anticlockwise() {
  stepCounter--;
  if (stepCounter < 0) stepCounter = numSteps - 1;
  setOutput(stepCounter);
}

void setOutput(int step) {
  digitalWrite(motorPin1, bitRead(stepsLookup[step], 0));
  digitalWrite(motorPin2, bitRead(stepsLookup[step], 1));
  digitalWrite(motorPin3, bitRead(stepsLookup[step], 2));
  digitalWrite(motorPin4, bitRead(stepsLookup[step], 3));
}
