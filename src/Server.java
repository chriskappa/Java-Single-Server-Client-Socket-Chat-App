import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    ServerSocket ss;
    Socket socket;
    InputStreamReader is;
    OutputStreamWriter out;
    BufferedReader reader;
    BufferedWriter writer;

    ArrayList<Socket> online = new ArrayList<Socket>();
    private int users =0;


    public static void main(String[] args){
        try {
            Server server = new Server();
            server.startServer();
        } catch (Exception e) {
            System.out.println("Connection lost SERVER");
//            e.printStackTrace();
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
//                sendMessage(socket);
                online.add(socket);
                clientHandler handler = new clientHandler(socket);
                handler.start();
//                receiveMessages();
//                for(Socket soc:online){
//                    writer = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
//                    writer.write("Tet");
//                    writer.newLine();
//                    writer.flush();
//                }
            } catch (IOException e) {
                System.out.println("Connection lost SERVER");
//                e.printStackTrace();
            }

        }


    }

//    private void receiveMessages() {
//
//        try {
//            while(true){
//                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                System.out.println(reader.readLine());
//                System.out.println("Users Online"+online.size());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

public void sendMessage(Socket soc ){

    try {
        writer = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
        writer.write("Hello User from server");
        writer.newLine();
        writer.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }

}

}
