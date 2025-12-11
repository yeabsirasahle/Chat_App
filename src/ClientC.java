import java.io.*;
import java.net.*;

public class ClientC {
    private static final String PROMPT = "Client: ";

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            Thread receiveThread = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        synchronized (System.out) {
                            
                            System.out.print("\r");
                            System.out.print("Server: " + msg + System.lineSeparator());
                            System.out.print(PROMPT);
                            System.out.flush();
                        }
                    }
                    synchronized (System.out) {
                        System.out.print("\r");
                        System.out.println("Server disconnected.");
                    }
                } catch (IOException e) {
                    synchronized (System.out) {
                        System.out.println("Connection closed.");
                    }
                }
            });
            receiveThread.setDaemon(true);
            receiveThread.start();

            String line;
            while (true) {
                synchronized (System.out) {
                    System.out.print(PROMPT);
                    System.out.flush();
                }
                line = keyboard.readLine();
                if (line == null) break; 
                out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
