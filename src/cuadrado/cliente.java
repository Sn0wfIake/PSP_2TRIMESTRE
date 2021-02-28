package cuadrado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class cliente {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// DECLARO LA IP Y EL MENSAJE
		String ip;
		int num;
		// PUERTO DE ESCUCHA DEL SERVIDOR
		int puerto;

		// ME DECLARO EL HILO DEL SERVER
		Socket hiloServer;
		

		Scanner sc = new Scanner(System.in);

		// LINEA PARA ENVIAR EL MENSAJE
		DataOutputStream enviar;
		//RECIBIR LA RESPUESTA
		DataInputStream entrada;
		
		
		// PREGUNTO AL USUARIO POR LA IP Y EL PUERTO
		System.out.println("Que direccion quieres usar: ");
		ip = sc.nextLine();
		System.out.println("Elije el puerto que vas a usar");
		puerto = sc.nextInt();
		sc.nextLine();

		try {
			// RELLENO MI HILO, CON LA DIRECCION DEL SERVER, ARRANCANDOLO
			hiloServer = new Socket(ip, puerto);

			// RELLENO MI STREAM CON EL TEXTO
			enviar = new DataOutputStream(hiloServer.getOutputStream());

			
				System.out.println("Que mensaje quieres enviar?");
				num = sc.nextInt();

				// A MI DATASTREAM LE PONGO EL MENSAJE Y LO ENVIA DE FORMA AUTOMATICA
				enviar.write(num);
				
				System.out.println("Mensaje recibido desde el SERVIDOR");
				System.out.println("--------------------");

				
				entrada = new DataInputStream(hiloServer.getInputStream());
				System.out.println(entrada.read());
			

			hiloServer.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
