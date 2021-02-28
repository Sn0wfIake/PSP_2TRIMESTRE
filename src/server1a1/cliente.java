package server1a1;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class cliente {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String direccion,mensaje;
		int puerto;
		Socket sock;
		Scanner sc = new Scanner(System.in);
		DataOutputStream enviar;
		Boolean terminar = false;
		
		System.out.println("Que direccion quieres usar: ");
		direccion = sc.nextLine();
		System.out.println("Elije el puerto que vas a usar");
		puerto = sc.nextInt();
		sc.nextLine();
		
		try {
			sock = new Socket(direccion,puerto);
			
			enviar = new DataOutputStream(sock.getOutputStream());
			while(!terminar) {
				System.out.println("Que mensaje quieres enviar?");
				mensaje = sc.nextLine();
				enviar.writeUTF(mensaje);
				if(mensaje.toLowerCase().equals("salir")) {
					terminar = true;
				}
			}
			
			
			sock.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

