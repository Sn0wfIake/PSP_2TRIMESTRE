package ping;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ping {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tiempo;
		int repeticiones;
		String stSeguir;
		
		Boolean Seguir = true;

		while (Seguir) {
			System.out.println("Cuantas veces quieres hacer ping: ");
			repeticiones = sc.nextInt();
			sc.nextLine();
			System.out.println("Cuanto tiempo de espera quieres (milisegundos): ");
			tiempo = sc.nextInt();
			sc.nextLine();
	
			System.out.println("Introduce IP:");
			String ip = sc.next();

			try {
				InetAddress direccion = InetAddress.getByName(ip);
			

			
					for (int i = 0; i < repeticiones; i++) {
						System.out.println("Se ha encontrado la direccion " + direccion.getHostName() + ": "
								+ direccion.isReachable(tiempo));
					
					}
			
				}

			 catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			System.out.println("Quieres seguir (Y/N): ");
			stSeguir = sc.next();
			sc.nextLine();
			if (stSeguir.toUpperCase().equals("Y")) {
				Seguir = true;
			} else {
				Seguir = false;
			}
		}
		sc.close();
	}
}
