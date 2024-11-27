import java.io.*;
import java.net.*;

public class q3_client {
    public static void main(String[] args) {
        String url = "http://example.com";

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }
}

