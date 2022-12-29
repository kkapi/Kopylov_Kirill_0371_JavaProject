package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Server {
    public static void main(String[] args) {
        int port = 80;
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started on PORT " + port);

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Accept");
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                BufferedReader reader =  new BufferedReader(new InputStreamReader(inputStream));

                Thread.sleep(10);

                String text = "";
                while (reader.ready()) {
                    text +=  reader.readLine();
                }
                System.out.println(text);
                String toClientText = text.toUpperCase();

                PrintWriter writer = new PrintWriter(outputStream, true);
                writer.println(toClientText);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
