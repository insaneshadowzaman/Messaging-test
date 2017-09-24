package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = null;

        try {
            Socket sock = new Socket("127.0.0.1", 4242);
            out = new PrintWriter(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            String str = sc.nextLine();
            out.println(str);
            out.flush();
        }
    }
}
