package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Calendar;
import javax.swing.JOptionPane;

public final class frmClient extends javax.swing.JFrame implements Runnable {

    //frmCuenta acc = new frmCuenta();
    
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Thread hilo;
    
    private String _IP = "";
    private String _USERNAME = "";
    private final int PUERTO = 8888;
    //private Boolean svConectado = false;

    public frmClient(String IP, String USERNAME) {
        initComponents();
        setLocationRelativeTo(null);
        socket = new Socket();
        hilo = new Thread(this);
        
        this._IP = IP;
        this._USERNAME = USERNAME;

        iniciarSocket();

    }

    public frmClient() {
        initComponents();
        setLocationRelativeTo(null);
        socket = new Socket();
        hilo = new Thread(this);

        iniciarSocket();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        txtMensaje = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        txtChat.setEditable(false);
        txtChat.setColumns(20);
        txtChat.setLineWrap(true);
        txtChat.setRows(5);
        jScrollPane2.setViewportView(txtChat);

        btnSend.setText("Enviar");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 310, Short.MAX_VALUE)
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMensaje))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        //Conectado = true;
            mandarMsg();

    }//GEN-LAST:event_btnSendActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        /*if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Conectado = true;
            if (svConectado) {
                mandarMsg();
            }
        }*/
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced dataInputStream Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmClient().setVisible(true);
            }
        });
    }

    /*
    
        Establecer conexión con el server
    
    */
    
    public void iniciarSocket() {
        try {
            if (!socket.isConnected()) {//
                InetAddress dir_IP = InetAddress.getByName(_IP);
                InetSocketAddress socket_IP = new InetSocketAddress(dir_IP, PUERTO);
                socket.connect(socket_IP);
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                btnSend.setEnabled(true);
                if (!(hilo.isAlive())) {
                    hilo = new Thread(this);
                }
                hilo.start();
                //svConectado = true;
            }
        } catch (IOException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "El servidor no pudo establecer conexión con el cliente.\n" + e.getMessage());
            btnSend.setEnabled(false);
            txtMensaje.setEnabled(false);
            socket = new Socket();

        }

    }

    /*
    
        Mandar mensaje
    
    */
    
    public void mandarMsg() {
        String msg = txtMensaje.getText().trim();
        if (msg.isEmpty()) {
            JOptionPane.showMessageDialog(this,"No dejes el espacio de mensaje en blanco.");
        }
        
        txtMensaje.setText("");
        
        try {
            Calendar now = Calendar.getInstance();
            String tiempo = now.get(Calendar.HOUR_OF_DAY)+":"+now.get(Calendar.MINUTE);
        
            dataOutputStream.writeUTF("[" + tiempo + "]" + " >" + _USERNAME + ": " + msg + "\n");  //Mensaje que recibe el servidor
        
        } catch (IOException e) {
          //
            System.out.println("send error: "+ e.getMessage());
        }
    }

    
    @Override
    public void run() {
        if (Thread.currentThread() == hilo) {
            String str = "";
            while (true) {
                try {
                    str = dataInputStream.readUTF();
                    
                    txtChat.append(str);  //Chat general
                    txtChat.setCaretPosition(txtChat.getDocument().getLength());
                    
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Servidor desconectado");
                    
                    btnSend.setEnabled(false);
                    txtMensaje.setEnabled(false);
                    
                    socket = new Socket(); //Reinicio el socket
                    break;
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSend;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtChat;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}