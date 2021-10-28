import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class clientHandler extends Thread{
    Socket socket;
    public clientHandler(Socket socket){
        this.socket = socket;

    }

    @Override
    public void run(){

        System.out.println("User Connected!");
        receiveMessages();
//
    }


    private void receiveMessages() {

        try {
            while(true){
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(reader.readLine());
            }

        } catch (IOException e) {
//            System.out.println("Something Went Wrong "+e.toString());
            System.out.println("User Disconnected from the chat!");
//            e.printStackTrace();
        }
    }
}
