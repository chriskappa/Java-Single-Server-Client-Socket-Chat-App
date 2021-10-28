import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class clientHandler extends Thread{


    public ArrayList<Socket> users = new ArrayList<>();
    Socket socket;
    public clientHandler(Socket socket){
        this.socket = socket;

    }

    @Override
    public void run(){

        System.out.println("User Connected!");
        users.add(socket);

        receiveMessages();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            /*While loop in order to read messages from the Clients*/
//            while(true){
//                String msg = reader.readLine();
//                writer.write(msg);
//
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printUsers(){
        System.out.println(users+","+users.size());
    }

    private void receiveMessages() {

        try {
            while(true){
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
