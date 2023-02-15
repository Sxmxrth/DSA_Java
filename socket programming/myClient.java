import java.io.*;
import java.net.*;
public class myClient {
    public static void main(String[] args) throws IOException {
        Socket client_socket = new Socket("localhost", 3000);
        try {
            System.out.println("Addition of 2 numbers");
            while (true){
                String str = " ";
                BufferedReader user_input = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream client_out = new DataOutputStream(client_socket.getOutputStream());

                BufferedReader server_input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
                for (int i = 1; i <= 2 ; i++) {
                    System.out.println("Enter a number : ");
                    str = str + user_input.readLine();
                }
                client_out.writeBytes(str + "\n");
                String str3 = server_input.readLine();
                System.out.println("The sum is " + str3 );
                client_socket.close();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
