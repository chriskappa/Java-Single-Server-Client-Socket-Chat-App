import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket ss;
    Socket socket;
    InputStreamReader is;
    OutputStreamWriter out;
    BufferedReader reader;
    BufferedWriter writer;
    private int users =0;


    public static void main(String[] args){
        try {
            Server server = new Server();
            server.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public Server() throws IOException{
        ss = new ServerSocket(2020);
    }


    public void startServer() {
        System.out.println("Waiting for users to Connect!");

        while(true){
            try {
                socket = ss.accept();
                clientHandler handler = new clientHandler(socket);
                handler.start();
//                receiveMessages();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    private void receiveMessages() {

        try {
            while(true){
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
