package hw16;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket clientSocket;
        BufferedReader in;
        PrintWriter out;
        int sum = 0;

        String host = "localhost";
        Integer port = 4004;
        clientSocket = new Socket(host, port);

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        URL url = new URL("http://" + host + ":" + port + "/");
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        httpURLConnection.getInputStream();

        while (in.readLine() != null){
            System.out.println(in.readLine());
        }

        out.flush();
        out.close();
        in.close();
        clientSocket.close();
    }

}
