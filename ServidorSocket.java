/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author asd
 */
public class ServidorSocket {
    public static void main(String[] args) throws IOException{
        BufferedReader entrada  = null;
        ServerSocket   servidor = null;
        Socket         conexao  = null;
        System.out.println("Servidor");
        
        try{
            
            servidor = new ServerSocket(7000);
            conexao  = servidor.accept();
            entrada  = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            do{
                String texto = entrada.readLine();
                if(texto == null){
                    break;
                }
                
                try{
                    
                    String[] array = texto.split(" ");
                    if(array.length == 3 && array[0].equals("new") && Integer.parseInt(array[1]) >= 0){
                        System.out.println("Criando Thread...");
                        new java.lang.Thread(new ThreadSocket(Integer.parseInt(array[1]),array[2])).start();
                    }
                    
                }catch(NumberFormatException e){}
                
                System.out.println("recebido: "+texto);
                
            }while(!"sair".equals(entrada.toString()));
            
        }catch(IOException e){
            System.out.println("Algo errado aconteceu");
        }finally{
            conexao.close();
            servidor.close();
        }
    }
}
