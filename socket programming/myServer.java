import java.io.*;
import java.net.*;
import java.lang.*;
public class myServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3000);
        while(true){
            Socket listen_socket = ss.accept();
            System.out.println("Server start");
            String str1 = " ";
            String[] temp;
            String del = "#";
            BufferedReader user_input = new BufferedReader(new InputStreamReader(listen_socket.getInputStream()));
            DataOutputStream server_output = new DataOutputStream(listen_socket.getOutputStream());
            str1 = user_input.readLine();
            temp = str1.split(del);
            double sum = 0.0;
            for (int i = 0; i < temp.length ; i++) {
                float num = Float.parseFloat(temp[i]);
                sum = sum + num;
            }
            String str2 = " ";
            server_output.writeBytes(str2);
            System.out.println("output sent ");
        }
    }
}
