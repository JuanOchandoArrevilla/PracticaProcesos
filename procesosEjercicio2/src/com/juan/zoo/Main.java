package com.juan.zoo;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class Main {

    public static void main(String[] args) {
        ProcessBuilder procesoPage = new ProcessBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("que paginas quieres abrir?");
        String page = sc.nextLine();
        System.out.println("cuantas ventanas de navegador quieres ?");
        int numNavegador = sc.nextInt();
        
        procesoPage.command("C:\\Program Files\\Google\\Chrome\\Application/chrome.exe","/c", page);
        ArrayList<Process> list =  new ArrayList<>();

            try {
                for (int i = 0; i <numNavegador ; i++) {
                    Process  pro = procesoPage.start();
                    list.add(pro);
                    ProcessHandle.Info info = pro.info();
                    System.out.println("proceso " + pro.pid() + "\n" +
                                       "hora de incio: " +  LocalDateTime.now());
                }
                System.out.println("\n");
                for(Process proceso: list){
                    proceso.waitFor(500, TimeUnit.MILLISECONDS);
                    System.out.println("proceso " + proceso.pid() + "\n" +
                            "hora finalizacion: " +  LocalDateTime.now());
                    proceso.destroy();

                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        sc.close();
    }
}
