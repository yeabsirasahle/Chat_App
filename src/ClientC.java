import java.io.*;
import java.net.*;

public class ClientC {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Client: ");
            String msg = keyboard.readLine();
            out.println(msg);

            String reply = in.readLine();
            System.out.println("Server: " + reply);
        }
    }
}
