/*
Práctica Brazo robotico, este archivo muestra el código de la programación de el brazo, donde se pod4rá distinguir los 
servo motores, el motor a pasos controlados por medio de esta interfaz, teniendo en cuenta una conexión Java-Arduino.
hecho por: Ana Estefania Mejia Rocha,   Crhistian josue
 */
package brazo;
//importación de libreiras, estas librerias las puedes encontrar en la caja de archivos de este proyecto
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortException;

public class Brazo extends JFrame {
//Secrean los elementos de la interfaz, botones, panel, y label
    JButton Izquierda; //boton que girará al motor a pasos a la izquierda
    JButton Derecha; //boton que girará al motor a pasos a la derecha
    JButton Arriba; 
    JButton Abajo;
    JButton Abrir;
    JButton Cerrar;
    JButton Avanzar;
    JButton Regresar;
    JButton Ejecutar;
    Container contenedor;
    JPanel panel1, panel2, panel3;
    JLabel f;
    ImageIcon image;
    
    //se crea los datos para la conexión a el programa Arduino
    private final String PORT_NAME = "/dev/ttyACM0"; //puerto linux, aquí cambiar a tu puerto de entrada al arduino.
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    //inicialización en ceros de los movimientos, esto para que empiece de una forma limpia
    String a = "0";
    String b = "0";
    String c = "0";
    String d = "0";
    String i = "0";
    String j = "0";
    String g = "0";
    String h = "0";
   
    //Creamos una instancia de la clase PanamaHitek_Arduino para iniciar la conexion
    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();

    
   
    public Brazo() {
        super("Brazo Robotico");
        //setVisible(true);
        setSize(9000,450);//tamaño de la venta(tamaño y altura)
        setLayout(null);//propiedades para ubicar en posicion
       
      image = new ImageIcon(getClass().getResource("/imagen/fondo4.jpg")); //imnagen de fondo de la intefaz
        f = new JLabel(image);
         
       //crear los elementos
        Izquierda = new JButton();
        Derecha = new JButton();
        Arriba = new JButton();
        Abajo = new JButton();
        Avanzar = new JButton();
        Regresar = new JButton();
        Abrir = new JButton();
        Cerrar = new JButton();
        Ejecutar = new JButton();
            //añadir los elemntos 
        f.setBounds(0, 0, 000, 350);
        add(f);
        f.add(Izquierda);
        f.add(Derecha);
        f.add(Arriba);
        f.add(Abajo);
        f.add(Avanzar);
        f.add(Regresar);
        f.add(Abrir);
        f.add(Cerrar);
        f.add(Ejecutar);
        //Le asignamos un laytout al frame
        setLayout(new FlowLayout());

        Izquierda.setText("Izquierda");
        Izquierda.setBounds(190, 120, 90, 30);
        //Posición de los elemntos en la intefaz
        Derecha.setText("Derecha");
        //30, 70, 90, 30
        Derecha.setBounds(340, 120, 90, 30);

        Arriba.setText("Subir");
        Arriba.setBounds(150, 50, 90, 30);

        Abajo.setText("Bajar");
        Abajo.setBounds(150, 200, 90, 30);

        Avanzar.setText("Avanzar");
        Avanzar.setBounds(400, 50, 90, 30);

        Regresar.setText("Regresar");
        Regresar.setBounds(400, 200, 90, 30);

        Abrir.setText("Abrir");
        Abrir.setBounds(100, 250, 90, 30);

        Ejecutar.setText("Ejecutar");
        Ejecutar.setBounds(250, 250, 90, 30);

        Cerrar.setText("Cerrar");
        Cerrar.setBounds(400, 250, 90, 30);

        try {
            //Iniciamos la conexion a arduino por medio del puerto 
            ino.arduinoTX(PORT_NAME, DATA_RATE);
        } catch (ArduinoException ex) {
            Logger.getLogger(Brazo.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     
          Registro_m manejador = new Registro_m();
       
         Ejecutar.addActionListener(manejador);
         Arriba.addActionListener(manejador);
         Regresar.addActionListener(manejador);
         Abrir.addActionListener(manejador);
         Izquierda.addActionListener(manejador);
         Abajo.addActionListener(manejador);
         Avanzar.addActionListener(manejador);
         Cerrar.addActionListener(manejador);
         Derecha.addActionListener(manejador);
    }
        //eventos
     private class Registro_m  implements ActionListener{
         @Override
        public void actionPerformed(ActionEvent e) {
           //si se presiona 1, se manda al boton arriba
        
        if (e.getSource() == Arriba) {
            a = "1";
        }
              //si se presiona 2se manda al boton regresar
        if (e.getSource() == Regresar) {
            b = "2";
        }  //si se presiona 3 se manda al boton abrir
        if (e.getSource() == Abrir) {
            c = "3";
        }  //si se presiona 4 se manda al boton Izquierda
        if (e.getSource() == Izquierda) {
            d = "4";
        }  //si se presiona 5 se manda al boton abajo
        if (e.getSource() == Abajo) {
            g = "5";
        }  //si se presiona 6 se manda al boton avanzar
        if (e.getSource() == Avanzar) {
            h = "6";
        }  //si se presiona 7 se manda al boton cerrar
        if (e.getSource() == Cerrar) {
            i = "7";
        }  //si se presiona 8 se manda al boton derecha
        if (e.getSource() == Derecha) {
            j = "8";
        }  //si se presiona ejecutar, guarda y envia los datos para el modo automatico
        if (e.getSource() == Ejecutar) {
            EnviarDatos("9");
            EnviarDatos(a);
            EnviarDatos(b);
            EnviarDatos(c);
            EnviarDatos(d);
            EnviarDatos(g);           
            EnviarDatos(h);
            EnviarDatos(i);
            EnviarDatos(j);
            
            
        }
        }
        
    }

    private void EnviarDatos(String data) {
        //por medio de la instancia ino llamamos al metodo sendData 
        //y enviamos el dato que recibe el metodo hacia al arduino 
        try {
            ino.sendData(data);
        } catch (ArduinoException ex) {
            Logger.getLogger(Brazo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(Brazo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//MAIN
    public static void main(String[] args) {
        Brazo a = new Brazo();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(480, 350);
        a.setLocationRelativeTo(null);
        
        a.setVisible(true);
        a.setResizable(false);
    }
}
