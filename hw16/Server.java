package hw16;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        PrintWriter out;
        ServerSocket server;
        Socket clientSocket;
        String res;
        Integer a = 0, b = 0,sum;

        Integer port = 4004;

        server = new ServerSocket(port);
        clientSocket = server.accept();

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        if(in.readLine().equals("GET")){
            res = in.readLine();
            Pattern p = Pattern.compile("http://localhost:4004/&name1= + \"/: \"([^\"]+)\"");
            Pattern p2 = Pattern.compile("http://localhost:4004/&name1= + \"/: \"([^\"]+)\"");
            Matcher m = p.matcher(res);
            Matcher m2 = p2.matcher(res);
            if (m.find() && m2.find()) {
                a = Integer.parseInt(m.group(1));
                b = Integer.parseInt(m.group(1));
            }
        }

        sum = a + b;
        out.write("HTTP/1.0 200 OK\r\n");
        out.write("Date: Sun, 1 Dec 2018 23:59:59 GMT\r\n");
        out.write("Content-Type: text/html\r\n");
        out.write("Content-Length: 6\r\n");
        out.write(sum);
        out.close();
        in.close();
        clientSocket.close();
        server.close();
    }
}