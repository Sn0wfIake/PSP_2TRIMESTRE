package server1a1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ServerSocket server;
		Socket sock;
		int puerto;
		Scanner sc = new Scanner(System.in);
		DataInputStream entrada;
		String mensajes;
		Boolean terminar = false;
		
		System.out.println("En que puerto quieres trabajar?");
		puerto = sc.nextInt();
		sc.nextLine();
		
		try {
			server = new ServerSocket(puerto);
			sock = server.accept();
			
			
			System.out.println("Mensajes recibidos");
			System.out.println("__________________");
			while(!terminar) {
				entrada = new DataInputStream(sock.getInputStream());
				
				mensajes = entrada.readUTF();
				System.out.println(mensajes);
				if(mensajes.toLowerCase().equals("salir")) {
					terminar = true;
				}
			}
			
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
