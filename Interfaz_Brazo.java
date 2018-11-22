

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class Interfaz_Brazo extends javax.swing.JFrame {
//Declaracion de variables
    //Declaracion de la variable que contendra el modo del brazo
    String modo1 = "R";
    String modo2 = "P";
    //Declaracion de la variable que contendra los comandos
    String cadena = "";
    //Declaracion de arreglo de longitud 10, que almancenara todos los comandos
    String[] datos = new String[10];
    //Declaracion de arreglo que guardara el valor que enviara arduino a java
    String[] valorARD = new String[1];
    //Declaracion de un contador, servira para indicar la posicion del arreglo
    int cont = 0;
    //Declaracion de variable de tipo Panama-Hiteck que llamara a los metodos de Arduino
    private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    //Declaracion de variable listener que enviara los datos al puerto serial
    private final SerialPortEventListener listener = new SerialPortEventListener() {
//Fin de declaracion de variables
        //Sobrecarga de metodos
        @Override
//Inicio de declaracion de metodos y constructores
        //Creacion de metodo que activara la comunicacion al puerto serial
        public void serialEvent(SerialPortEvent spe) {
            //Declaracion de try-catch para obtener valores y errores
            try {
                //Si existe algun mensaje disponible
                if (ino.isMessageAvailable()) {
                    //Arduino envia un 0 y java imprime ese mensaje
                    valorARD[0] = ino.printMessage();
                    //Recepcion del valor de arduino a java
                    System.out.println(valorARD[0]);
                    //Enviamos el valor recibido en java a Arduino
                    ino.sendData(datos[Integer.parseInt(valorARD[0]) - 1]);
                }
            //Atrapamos errores en caso de no lograr la conexion serial
            } catch (SerialPortException | ArduinoException ex) {
                //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
                Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    
    public Interfaz_Brazo() {
        //Indica el titulo que llevara la ventana de la interfaz
        super("BRAZO MECANICO");
        //Iniciamos componentes de la interfaz
        initComponents();
        //Declaracion de try-catch para obtener valores y errores
        try {
            //Esto indica que nuestro programa enviara y recibira datos de Java a Arduino
            //Y viceversa. Es decir, una comunicacion constante entre los dos
            //Declaramos el puerto por donde se iniciara la comunicacion serial    /dev/ttyACM0
            ino.arduinoRXTX("/dev/ttyACM0", 9600, listener);
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion    
        } catch (ArduinoException ex) {
            //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
            Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Generacion de codigo que contiene la interfaz grafica
    //Generado por el IDE NetBeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Pestaña = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        Hombro = new javax.swing.JLabel();
        Antebrazo = new javax.swing.JLabel();
        Codo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Pinza = new javax.swing.JLabel();
        Button180 = new javax.swing.JButton();
        Buttton360 = new javax.swing.JButton();
        Ante_arriba = new javax.swing.JButton();
        Ante_abajo = new javax.swing.JButton();
        Codo_arriba = new javax.swing.JButton();
        Codo_abajo = new javax.swing.JButton();
       // Muñe_arriba = new javax.swing.JButton();//quitar
       // Muñe_abajo = new javax.swing.JButton();//quitar
        Abrir_pinza = new javax.swing.JButton();
        cerrar_pinza = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TFIngresa = new javax.swing.JTextField();
        Btnejecutar = new javax.swing.JButton();
        ALTO = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("tab1", jPanel4);

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pestaña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PestañaMouseClicked(evt);
            }
        });

        Hombro.setText("Hombro");

        Antebrazo.setText("Antebrazo");

        Codo.setText("Codo");

        //jLabel6.setText("Muñeca");//borrar

        Pinza.setText("Pinza");

        Button180.setText("180");
        Button180.setPreferredSize(new java.awt.Dimension(40, 40));
        Button180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button180ActionPerformed(evt);
            }
        });

        Buttton360.setText("360");
        Buttton360.setPreferredSize(new java.awt.Dimension(40, 40));
        Buttton360.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buttton360ActionPerformed(evt);
            }
        });

        Ante_arriba.setText("Arriba");
        Ante_arriba.setPreferredSize(new java.awt.Dimension(100, 31));
        Ante_arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ante_arribaActionPerformed(evt);
            }
        });

        Ante_abajo.setText("Abajo");
        Ante_abajo.setPreferredSize(new java.awt.Dimension(100, 31));
        Ante_abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ante_abajoActionPerformed(evt);
            }
        });

        Codo_arriba.setText("Arriba");
        Codo_arriba.setPreferredSize(new java.awt.Dimension(100, 31));
        Codo_arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Codo_arribaActionPerformed(evt);
            }
        });

        Codo_abajo.setText("Abajo");
        Codo_abajo.setPreferredSize(new java.awt.Dimension(100, 31));
        Codo_abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Codo_abajoActionPerformed(evt);
            }
        });

       // Muñe_arriba.setText("Anajo");
       // Muñe_arriba.setPreferredSize(new java.awt.Dimension(40, 40));//borrar
        //Muñe_arriba.addActionListener(new java.awt.event.ActionListener() {
          //  public void actionPerformed(java.awt.event.ActionEvent evt) {
            //    Muñe_arribaActionPerformed(evt);
            //}
        //});

        //Muñe_abajo.setText("Arriba");//borrar
       // Muñe_abajo.setPreferredSize(new java.awt.Dimension(40, 40));
        //Muñe_abajo.addActionListener(new java.awt.event.ActionListener() {
          //  public void actionPerformed(java.awt.event.ActionEvent evt) {
            //    Muñe_abajoActionPerformed(evt);
            //}
        //});

        Abrir_pinza.setText("Abrir");
        Abrir_pinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Abrir_pinzaActionPerformed(evt);
            }
        });

        cerrar_pinza.setText("Cerrar");
        cerrar_pinza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_pinzaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Antebrazo)
                    .addComponent(Ante_arriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ante_abajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hombro)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Buttton360, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Button180, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(Codo))
                            .addComponent(Codo_abajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Codo_arriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   // .addComponent(Muñe_arriba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    //.addComponent(Muñe_abajo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                )))
                        .addGap(114, 114, 114))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cerrar_pinza, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(Pinza, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Abrir_pinza, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                       // .addComponent(Muñe_arriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        //.addComponent(Muñe_abajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Hombro)
                            .addComponent(Codo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Codo_arriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Button180, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Buttton360, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Codo_abajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Antebrazo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ante_arriba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ante_abajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Pinza)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Abrir_pinza)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cerrar_pinza)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        Pestaña.addTab("Remoto", jPanel3);

        jLabel1.setText("Introduzca la cadena de comandos a ejecutar");

        Btnejecutar.setText("Ejecutar");
        Btnejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnejecutarActionPerformed(evt);
            }
        });

        ALTO.setText("PARO TOTAL");

        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFIngresa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Btnejecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ALTO, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(btnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TFIngresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btnejecutar)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(ALTO, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        Pestaña.addTab("Programacion", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pestaña, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pestaña)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Pestañas de modos del brazo
    private void PestañaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PestañaMouseClicked
        //Se selecciona la pestaña de remoto
        if (Pestaña.getSelectedIndex() == 0) {
            //Se manda llamar a consola, solo para pruebas
            System.out.println("REMOTO");
            //Declaracion de try-catch para obtener valores y errores
            try{
              //Enviamos el modo que ejecutara el brazo a Arduino  
              ino.sendData(modo1);
            //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
            }catch(ArduinoException | SerialPortException ex){
                //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
                Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);
            }
        //En caso de no seleccionar la pestaña de REMOTO   
        } else {
                //Se manda llamar a consola, solo para pruebas
                System.out.println("PROGRAMACION");
                //Declaracion de try-catch para obtener valores y errores
                try{
                   //Enviamos el modo que ejecutara el brazo a Arduino
                   ino.sendData(modo2);
                //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
                }catch(ArduinoException | SerialPortException ex){
                  //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
                  Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);   
            }
        }
    }//GEN-LAST:event_PestañaMouseClicked

    //Eventos de la seccion de modo programacion
    private void BtnejecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnejecutarActionPerformed
        System.out.println(TFIngresa.getText());
    //Declaracion de try-catch para obtener valores y errores
    try{
        
       //Enviamos el modo que ejecutara el brazo a Arduino
       ino.sendData(TFIngresa.getText());
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
        }catch(ArduinoException | SerialPortException ex){
          //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
          Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }//GEN-LAST:event_BtnejecutarActionPerformed
    //Eventos de la seccion de modo remoto
    //Evento que permite el movimiento hacia arriba del antebrazo
    private void Ante_arribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ante_arribaActionPerformed
    System.out.println("Arriba-Antebrazo");
    //Declaracion de try-catch para obtener valores y errores
    try{
       //Enviamos el modo que ejecutara el brazo a Arduino
       ino.sendData("B");
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
        }catch(ArduinoException | SerialPortException ex){
          //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
          Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }//GEN-LAST:event_Ante_arribaActionPerformed
    //Evento que permite el movimiento hacia abajo del antebrazo
    private void Ante_abajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ante_abajoActionPerformed
    System.out.println("Abajo-Antebrazo");
    //Declaracion de try-catch para obtener valores y errores
    try{
       //Enviamos el modo que ejecutara el brazo a Arduino
       ino.sendData("A");
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
        }catch(ArduinoException | SerialPortException ex){
          //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
          Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }//GEN-LAST:event_Ante_abajoActionPerformed
    //Evento que permite el movimiento hacia arriba del codo
    private void Codo_arribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Codo_arribaActionPerformed
        System.out.println("Arriba-Codo");
    //Declaracion de try-catch para obtener valores y errores
    try{
       //Enviamos el modo que ejecutara el brazo a Arduino
       ino.sendData("C");
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
        }catch(ArduinoException | SerialPortException ex){
          //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
          Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }//GEN-LAST:event_Codo_arribaActionPerformed
    //Evento que permite el movimiento hacia abajo del codo
    private void Codo_abajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Codo_abajoActionPerformed
            System.out.println("Abajo-Codo");
    //Declaracion de try-catch para obtener valores y errores
    try{
       //Enviamos el modo que ejecutara el brazo a Arduino
       ino.sendData("D");
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
        }catch(ArduinoException | SerialPortException ex){
          //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
          Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);   
        }}
       private void Abrir_pinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Abrir_pinzaActionPerformed
        //Mandamos datos a consola solo para propositos de prueba
    System.out.println("Abrir-Pinza");
    //Declaracion de try-catch para obtener valores y errores
    try{
       //Enviamos el modo que ejecutara el brazo a Arduino
       ino.sendData("E");
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
        }catch(ArduinoException | SerialPortException ex){
          //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
          Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Abrir_pinzaActionPerformed

    private void cerrar_pinzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_pinzaActionPerformed
        //Mandamos datos a consola solo para propositos de prueba
    System.out.println("Cerrar Pinza");
    //Declaracion de try-catch para obtener valores y errores
    try{
       //Enviamos el modo que ejecutara el brazo a Arduino
       ino.sendData("F");
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
        }catch(ArduinoException | SerialPortException ex){
          //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
          Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  //GEN-LAST:event_Muñe_abajoActionPerformed
    
    //Evento que permite el movimiento hacia 180 grados del hombro
    private void Button180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button180ActionPerformed
    //Mandamos datos a consola solo para propositos de prueba
    System.out.println("180-Hombro");
    //Declaracion de try-catch para obtener valores y errores
    try{
       //Enviamos el modo que ejecutara el brazo a Arduino
       ino.sendData("1");
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
        }catch(ArduinoException | SerialPortException ex){
          //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
          Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }//GEN-LAST:event_Button180ActionPerformed
    
    //Evento que permite el movimiento hacia 360 grados del hombro
    private void Buttton360ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buttton360ActionPerformed
    //Mandamos datos a consola solo para propositos de prueba
    System.out.println("360-Hombro");
    //Declaracion de try-catch para obtener valores y errores
    try{
       //Enviamos el modo que ejecutara el brazo a Arduino
       ino.sendData("2");
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
        }catch(ArduinoException | SerialPortException ex){
          //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
          Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);   
        }
    }//GEN-LAST:event_Buttton360ActionPerformed

 //GEN-LAST:event_cerrar_pinzaActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
      //Declaracion de try-catch para obtener valores y errores
    try{
       //Enviamos el modo que ejecutara el brazo a Arduino
       ino.sendData("Z");
        //Atrapamos la excepcion que arroja Arduino en caso de no lograr la conexion
        }catch(ArduinoException | SerialPortException ex){
          //Obtenemos el nombre del puerto y aclaramos si si se pudo efectuar la conexion
          Logger.getLogger(Interfaz_Brazo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed
    
    //Creacion del metodo principal para la ejecucion del programa
    public static void main(String args[]) {
        //Se invoca el metodo que creara la interfaz y correra el programa
        java.awt.EventQueue.invokeLater(new Runnable() {
            //Metodo principal
            public void run() {
                //Hacemos visible la interfaz del programa
                new Interfaz_Brazo().setVisible(true);
            }
        });
    }
    
    //Declaracion de variables, creada por NetBeans
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ALTO;
    private javax.swing.JButton Abrir_pinza;
    private javax.swing.JButton Ante_abajo;
    private javax.swing.JButton Ante_arriba;
    private javax.swing.JLabel Antebrazo;
    private javax.swing.JButton Btnejecutar;
    private javax.swing.JButton Button180;
    private javax.swing.JButton Buttton360;
    private javax.swing.JLabel Codo;
    private javax.swing.JButton Codo_abajo;
    private javax.swing.JButton Codo_arriba;
    private javax.swing.JLabel Hombro;
    private javax.swing.JButton Muñe_abajo;
    private javax.swing.JButton Muñe_arriba;
    private javax.swing.JTabbedPane Pestaña;
    private javax.swing.JLabel Pinza;
    private javax.swing.JTextField TFIngresa;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton cerrar_pinza;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    //Fin de declaracion de variables creada por NetBeans
}