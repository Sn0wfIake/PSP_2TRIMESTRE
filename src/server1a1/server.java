package server1a1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ME DECLARO MI SERVIDOR Y MI HILO DEL SERVIDOR
		ServerSocket server;
		Socket hiloServer;
		
		//PUERTO DE ESCUCHA
		int puerto;
		Scanner sc = new Scanner(System.in);
		
		//VARIABLE PARA RECIBIR LOS PARAMETROS
		DataInputStream entrada;
		
		String mensajes;
		Boolean terminar = false;
		
		//INSERTO EL PUERTO DE MI SERVER
		System.out.println("En que puerto quieres trabajar?");
		puerto = sc.nextInt();
		sc.nextLine();
		
		try {
			
			//ACTIVO MI SERVER EN EL PUERTO SOLICITADO
			server = new ServerSocket(puerto);
			//MI HILO, ESTA ESCUCHANDO EN EL SERVIDOR DECLARADO
			hiloServer = server.accept();
			
			
			System.out.println("Mensajes recibidos");
			System.out.println("__________________");
			while(!terminar) {
				
				//MI INPUTSTREAM PERMANECE A LA ESCUCHA
				entrada = new DataInputStream(hiloServer.getInputStream());
				
				//la variable mensajes, lee constantemente las entradas del cliente
				mensajes = entrada.readUTF();
				System.out.println(mensajes);
				
				if(mensajes.toLowerCase().equals("salir")) {
					terminar = true;
				}
			}
			
			hiloServer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
