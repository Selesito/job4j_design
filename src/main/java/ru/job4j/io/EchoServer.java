package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String temp = null;
                    while (!(str.isEmpty())) {
                        System.out.println(str);
                        if (str.contains("GET")) {
                            if (str.contains("Exit")) {
                                temp = "Exit.\r\n\r\n";
                                server.close();
                            } else if (str.contains("Hello")) {
                                temp = "Hello, dear friend.\r\n\r\n";
                            } else {
                                String[] rsl = str.split(" ");
                                rsl = rsl[1].split("=");
                                temp = "What - " + rsl[1];
                            }
                        }

                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(temp.getBytes());
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in log example", e);
        }
    }
}