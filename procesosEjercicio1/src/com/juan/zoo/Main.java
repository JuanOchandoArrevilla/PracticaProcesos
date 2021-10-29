package com.juan.zoo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("cuantos navegadores quieres ?");
        int Nnavegador = sc.nextInt();
        ProcessBuilder procesoBuiler = new ProcessBuilder();
        procesoBuiler.command("C:\\Program Files\\Google\\Chrome\\Application/chrome.exe");
        ArrayList<Process> list =  new ArrayList<>();
        try {
           for (int i = 0; i < Nnavegador; i++) {
               Process pro = procesoBuiler.start();
               list.add(pro);
           }
           for(Process proceso: list){
               while (proceso.isAlive()) {
                   proceso.waitFor();
               }

           }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        sc.close();
    }

}
