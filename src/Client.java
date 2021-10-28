import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Client {
    Socket socket;
    InputStreamReader is;
    OutputStreamWriter out;
    BufferedReader reader;
    BufferedWriter writer;
    Scanner read = new Scanner(System.in);
    boolean isPlaying = true;
    ArrayList<User> users = new ArrayList<User>();


    public static void main(String[] args) throws IOException {
    Client client = new Client();
        client.startClient();


    }


    public Client() throws IOException {
        try {
            socket = new Socket("localhost",2020);
            is = new InputStreamReader(socket.getInputStream());
            out = new OutputStreamWriter(socket.getOutputStream());
            reader = new BufferedReader(is);
            writer = new BufferedWriter(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void startClient(){
        while(isPlaying){
            printMenu();
            String res =  read.nextLine();
            switch(res){
                case "1" : {
                    createAccount();
                    break;
                }
                case "2": sendMessage();
                default:
                    System.exit(1);
                    break;

            }
        }

    }
    public void printMenu(){
        System.out.println("Welcome To Chat Application");
        System.out.println("1) Create Account");
        System.out.println("2  Joing Chat Room");
        System.out.println("3) Exit");
        System.out.println("Please Make Enter Your Choice");
    }

    public void login(){
        System.out.println("Welcome To The Chat Room!");
    }
    public void sendMessage() {
        Random rand = new Random();
    while(true){

        try {;
            System.out.println("Enter Your Message!");
            String msg = read.nextLine();
            if(msg.equals("exit")) exitFromApp();
            writer.write(users.size() > 0 ? users.get(0).getUserName().toUpperCase()+":"+msg : "User "+rand.nextInt(10)+" "+msg);
            writer.newLine();
            writer.flush();



        } catch (IOException e) {
            System.out.println("Lost Connection with the Server!");
            e.printStackTrace();
        }
    }

    }

    private void exitFromApp() {
        System.out.println("Thank you for using this chat Application");
        try {


            for (int i = 0; i < 7; i++) {
                System.out.print(".");
                Thread.sleep(200);
            }
            System.exit(1000);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }

    public void createAccount(){
        System.out.println("Please Enter Your Account Name!");
        String name = read.nextLine();
        User user = new User(name);
        users.add(user);
        startClient();

    }

}
