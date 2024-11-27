import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

   Jugador[] jugadores = new Jugador[100];
   int jugadoresRegistrados = 0;
   Scanner in = new Scanner(System.in);

	System.out.println("BIENVENIDO A LA FERIA");

	 try (ObjectInputStream obtencion = new ObjectInputStream(new FileInputStream("jugadores.txt"))) {
            jugadoresRegistrados = obtencion.readInt();
            for (int i = 0; i < jugadoresRegistrados; i++) {
                jugadores[i] = (Jugador) obtencion.readObject();
            }
            System.out.println("Datos cargados correctamente.");
        } catch (Exception e) {
            System.out.println("No se encontraron datos para cargar, por lo que se comenzara con un nuevo registro");
        }

	
        boolean salir = false;

        while (salir == false) {
            System.out.println(" POR FAVOR SELECCIONA UNA ACTIVIDAD A REALIZAR");
            System.out.println("1. Registro de jugador");
            System.out.println("2. Acceder a juegos de dia 1");
            System.out.println("3. Acceder a juegos de dia 2");
            System.out.println("4. Ver quienes son los 3 mejores jugadores hasta el momento");
	    System.out.println("5. Ver los puntos acumulados hasta el momento");
	    System.out.println("6. Guardar datos y salir de sistema");

            int seleccion = in.nextInt();
	    in.nextLine();
	    
            switch (seleccion) {
                case 1:

 		         if (jugadoresRegistrados >= 100) {
            System.out.println("No se pueden registrar más jugadores. El límite ha sido alcanzado.");
            return;
        }

	System.out.print("Introduce el nombre del jugador: ");
        String nombre = in.nextLine();
 	
        jugadores[jugadoresRegistrados++] = new Jugador(nombre);
        System.out.println("Jugador registrado exitosamente.");

                    break;
                case 2:

		    System.out.println("Selecciona alguno de los juegos de dia 1 para jugar: ");                                                                       
                    System.out.println(" 1- Cuadrado mágico");                                                                                                         
                    System.out.println(" 2- Conecta 4. Costo de juego = 15 creditos");                                                                                 
                    int eleccionUno = in.nextInt();                                                                                                                    
                    switch(eleccionUno){

		    case 1:

			//JUEGO DE CUADRADO MAGICO
			
			break;
		    case 2:

		    System.out.println("Selecciona alguna de las modalidades de juego: ");
                    System.out.println(" 1- Juego de dos jugadores");
                    System.out.println(" 2- Juego contra la computadora");

                    int eleccionConecta = in.nextInt();
		    in.nextLine();
		    
                    switch(eleccionConecta){
                                                                                                                                                             
                    case 1:                                                  
                        System.out.println("Ingresa el nombre con el que se registro el jugador 1:");                            
                        String nombreConecta1 = in.nextLine();                                     
                        boolean recursos1 = false;                                                
                        boolean encontrado1 = false;                    
                        Jugador jugadorConecta1 = new Jugador();               
                        System.out.println("Ingresa el nombre con el que se registro el jugador 2:");                       
                        String nombreConecta2 = in.nextLine();                          
                        boolean recursos2 = false;                                                
                        boolean encontrado2 = false;                            
                        Jugador jugadorConecta2 = new Jugador();
			
                            for (int i = 0; i < jugadoresRegistrados; i++) {                                                                                         
                                if (jugadores[i].obtenerNombre().equals(nombreConecta1)){
				    jugadorConecta1 = jugadores[i];
				    encontrado1 = true;
				    if (jugadorConecta1.obtenerSaldo() >= 15){
					recursos1 = true;                                                                                                               
                                            System.out.println("Jugador 1 encontrado");                                                                                        
                                    } else {                                                                                                                  
                                System.out.println("Jugador encontrado,pero el jugador 1 no tiene saldo suficiente");                                                                               
                            }                                                                                                                                                   
                                          } else {                                                                                                                                  
                                }                                               
                            }

                            for (int i = 0; i < jugadoresRegistrados; i++) {
                                if (jugadores[i].obtenerNombre().equals(nombreConecta2)){
                                    jugadorConecta2 = jugadores[i];
                                    encontrado2 = true;

                                        if (jugadorConecta2.obtenerSaldo() >= 15){
                                            recursos2 = true;
                                            System.out.println("Jugador 2 encontrado");

                                    } else {
                                System.out.println("Jugador encontrado, pero el jugador 2 no tiene saldo suficiente");
                            }
                                          } else {
                                }
                            }

                            if (encontrado1 == true && recursos1 == true && encontrado2 == true && recursos2 == true){

                                jugadorConecta1.restarSaldo(15);
                                jugadorConecta2.restarSaldo(15);

                                for (int i = 0; i < jugadoresRegistrados; i++) {
                                if (jugadores[i].obtenerNombre().equals(nombreConecta1)){
                                    jugadores[i].asignarSaldo(jugadorConecta1.obtenerSaldo());
                                } else {
                                }
                                }

                                for (int i = 0; i < jugadoresRegistrados; i++) {
                                if (jugadores[i].obtenerNombre().equals(nombreConecta2)){
                                    jugadores[i].asignarSaldo(jugadorConecta2.obtenerSaldo());
                                } else {
                                }
                                }

                                System.out.println("Se han descontado 15 del saldo de ambos jugadores. Bienvenidos; el juego comenzara... \n");

                                // DESARROLLO DEL JUEGO                                                                              
                                // ASIGNACION DE PUNTOS                                                                                                             
                                // MOSTRAR POSICION ACTUAL             
                                // CONOCER TRES PRIMEROS CONCURSANTES VICTORIOSOS
				
                            } else {
                                System.out.println(" \n //\\//\\ Regresaran al menu principal. Ingresen el nombre con el que se registraron  para asegurar que sean encontrados, o registrense como nuevos jugadores antes de jugar. Consideren su saldo disponible antes de jugar \n Nota: Considera mayusculas, minusculas, espacios y acentos. \n");
                            }

                        break;
                    case 2:

			System.out.println("Ingresa el nombre con el que te registraste:");
			String nombreConecta = in.nextLine();

			boolean recursos = false;
			boolean encontrado = false;
			Jugador jugadorConecta = new Jugador();

			    for (int i = 0; i < jugadoresRegistrados; i++) {
				if (jugadores[i].obtenerNombre().equals(nombreConecta)){
				    jugadorConecta = jugadores[i];
				    encontrado = true;

					if (jugadorConecta.obtenerSaldo() >= 15){
					    recursos = true;
					    jugadores[i].restarSaldo(15);
					    
					     System.out.println("Jugador encontrado");
					    
                                    } else {
                                System.out.println("Jugador encontrado, pero el jugador no tiene saldo suficiente");
                            }
				} else {
				}
			    }

			    if (encontrado == true && recursos == true){
				System.out.println("Se han descontado 15 de tu saldo. Bienvenido; el juego comenzara... \n");

				// DESARROLLO DEL JUEGO
				// ASIGNACION DE PUNTOS
				// MOSTRAR POSICION ACTUAL
				// CONOCER TRES PRIMEROS CONCURSANTES VICTORIOSOS
			    } else {
				System.out.println(" \n //\\//\\ Regresaras al menu principal. Ingresa el nombre con el que te registraste para asegurar que seas encontrado, o registrate como nuevo jugador antes de jugar. Considera tu saldo disponible antes de jugar \n Nota: Considera mayusculas, minusculas, espacios y acentos. \n");
			    }
				
			    break;
		    default:
			System.out.println("Seleccion incorrecta, regresaras al menu principal. Por favor selecciona una opcion valida \n");
			break;
		    }
			break;
		    default:
			System.out.println("Seleccion incorrecta, regresaras al menu principal. Por favor selecciona una opcion valida \n");
			break;

		    }
			
	             break;
		     
                case 3:

		    System.out.println("Selecciona alguno de los juegos de dia 2 para jugar: "); 
                    System.out.println(" 1- Salvados");
                    System.out.println(" 2- Torres de Hanoi");
                                                        
                    int eleccionDos = in.nextInt();    
                                                       
                    switch(eleccionDos){
                                                                                                                                                                                      
                    case 1:    
                                                                                                                                                         
                        //JUEGO DE SALVADOS
                                                                                  
                        break;
		      
                    case 2:                                                                                                                          
                        //JUEGO DE TORRES DE HANOI
			
                        break;  
                    default:    
                        System.out.println("Seleccion incorrecta, regresaras al menu principal. Por favor selecciona una opcion valida \n");  
                        break;                                                                                           
                                                                    
                    }

                    break;

	    case 4:

		//VER MEJORES 3 JUGADORES

		break;

	    case 5:
		//VER PUNTOS ACUMULADOS ACTUALES
		
                case 6:

      try (ObjectOutputStream registro = new ObjectOutputStream(new FileOutputStream("jugadores.txt"))) {
            registro.writeInt(jugadoresRegistrados);
            for (int i = 0; i < jugadoresRegistrados; i++) {
                registro.writeObject(jugadores[i]);
            }
            System.out.println("Datos guardados con exito.");
	    System.out.println("\n HASTA PRONTO!!!");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al guardar los datos");
        }
    
                    salir = true;

	break;
		    
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

}
