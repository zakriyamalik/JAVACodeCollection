import java.io.*;
import java.net.*;

public class q1_client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("Hello, Server!");
        System.out.println("Response from server: " + in.readLine());

        socket.close();
    }
}
