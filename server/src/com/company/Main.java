package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    private ArrayList clientList = new ArrayList();

    private void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            while(true) {
                Socket sock = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                clientList.add(in);
                new Thread(new clientHandler(in)).start();
            }
        } catch (IOException e) {
            System.out.println("Could not make Server socket!!!");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Main().startServer();
    }

    private class clientHandler implements Runnable {

        BufferedReader in;
        clientHandler(BufferedReader fin) {
            this.in = fin;
        }

        @Override
        public void run() {
            String str;
            try {
                while(true) {
                    str = in.readLine();
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.out.println("Could not ratline!!!");
                e.printStackTrace();
            }

        }
    }
}
