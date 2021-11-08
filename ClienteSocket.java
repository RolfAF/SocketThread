/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket_thread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
        
/**
 *
 * @author asd
 */
public class ClienteSocket {
    public static void main(String[] args) throws IOException{
        PrintStream saida   = null;
        Scanner     entrada = new Scanner(System.in);
        String      texto   = "";
        Socket      cliente = null;
        System.out.println("Cliente");
        
        try{
            
            cliente = new Socket("127.0.0.1",7000);
            saida = new PrintStream(cliente.getOutputStream());
            do{
                texto = entrada.nextLine();
                saida.println(texto);
            }while(!"sair".equals(texto));
            
        }catch(IOException e){
            System.out.println("Algo errado aconteceu");
        }finally{
            cliente.close();
        }
    }
}
