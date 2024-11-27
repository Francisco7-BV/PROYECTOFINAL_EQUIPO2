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
            System.out.println("No se pueden registrar más de 100 jugadores");
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
		    System.out.println(" 2- Conecta 4");

		    int eleccionUno = in.nextInt();

		    switch(eleccionUno){

		    case 1:

			//JUEGO DE CUADRADO MAGICO
			
			break;
		    case 2:

			//JUEGO DE CONECTA 4
			
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
                    System.out.println("Opción inválida. Regresaras al menu. Por favor selecciona una opcion valida.");
            }
        }
    }

}
