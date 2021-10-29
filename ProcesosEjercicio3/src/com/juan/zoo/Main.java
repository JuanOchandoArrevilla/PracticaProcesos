package com.juan.zoo;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {

            String ruta = "c:"+ File.separator + "Users" + File.separator + "node.txt";
            File file = new File(ruta);

        if(file.exists()) {
            ProcessBuilder procesoBuilder = new ProcessBuilder();
            procesoBuilder.command("powershell.exe","cat" , ruta );
            procesoBuilder.command("powershell.exe","(Get-Content " + ruta + " ).length");

            try {
                Process pro = procesoBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(pro.getInputStream()));
                String linea = "";
                while ( (linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
                pro.waitFor();

               } catch (IOException | InterruptedException e) {
               e.printStackTrace();

               }
        } else {
            System.out.println("el fichero no existe");
        }

    }
}

