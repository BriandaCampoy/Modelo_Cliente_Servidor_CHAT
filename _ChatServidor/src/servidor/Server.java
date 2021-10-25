package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Server {

    private boolean conectado = false;
    private final String _IP = ""; // <---- Agregar IPv4
    private final int _PUERTO = 8888; //<---- Puerto donde el servidor se aloja
    private ServerSocket serverSocket = null;
    private ArrayList<ChatClient> usuarios = new ArrayList<>();
    //private int numClientes = 0;

    public static void main(String[] args) {
        new Server().start();
    }

    public void start() {
        try {
            InetAddress _IPv = InetAddress.getByName(_IP);

            serverSocket = new ServerSocket(_PUERTO, 10, _IPv);
            conectado = true;
        } catch (BindException err) {
            System.out.println("Puerto no disponible: " + err.getMessage());
        } catch (IOException err) {
          
        }

        try {
            
            //Cliente multiple
            while (conectado) {
                Socket s = serverSocket.accept();

                ChatClient c = new ChatClient(s);

                new Thread(c).start();

                usuarios.add(c);

            }
        } catch (IOException err) {
            
        } finally {
            try {
                serverSocket.close();
            } catch (IOException err) {

            }
        }
    }

    //multi-cliente
    public class ChatClient implements Runnable {

        private Socket socket;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        boolean Usuarios_Conectados = false;

        public ChatClient(Socket s) {
            this.socket = s;
            try {
                dataInputStream = new DataInputStream(s.getInputStream()); //recibe msg
                dataOutputStream = new DataOutputStream(s.getOutputStream()); //envia msg
                Usuarios_Conectados = true;
            } catch (IOException e) {
                
            }
        }

        public void enviarMsg(String str) {
            try {

                dataOutputStream.writeUTF(str);

            } catch (SocketException err) {
                System.out.println(err.getMessage());
            } catch (IOException err) {
                
            }
        }

        //
        @Override
        public void run() {
            
            try {
                
                while (Usuarios_Conectados) 
                {
                    String str = dataInputStream.readUTF();
                    for (int i = 0; i < usuarios.size(); i++) {
                        ChatClient c = usuarios.get(i);
                        c.enviarMsg(str);
                    }

                    //Guardar chat log
					
                    //LocalDate dataAtual = LocalDate.now();
                    //String df = dataAtual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    //File f = new File("C:\\chat\\chatLog [" + df + "].txt");
                    //FileWriter fw = new FileWriter(f, true);
                    //PrintWriter pw = new PrintWriter(fw);

                    //pw.println(str);
                    //fw.close();
                }
                
            } catch (EOFException err) {
                
            } catch (IOException err) {
                
            } 
            
            if (dataInputStream != null) {
                if (socket != null)
		    try {
                    dataInputStream.close();
                    socket.close();
                    dataOutputStream.close();
                } catch (IOException err) {

                }
            }

        }
    }
}
