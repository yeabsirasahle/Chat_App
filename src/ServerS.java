import java.io.*;
import java.net.*;

public class ServerS {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server running...");

        Socket socket = server.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String msg = in.readLine();
            System.out.println("Client: " + msg);

            System.out.print("Server: ");
            String reply = keyboard.readLine();
            out.println(reply);
        }
    }
}
