import java.io.*;

public class Prueba {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("jugadores.txt"))) {
            // Lee el número de jugadores
            int cantidad = ois.readInt();
            System.out.println("Cantidad de jugadores: " + cantidad);

            for (int i = 0; i < cantidad; i++) {
                // Lee cada jugador y lo imprime
                Jugador jugador = (Jugador) ois.readObject();
                System.out.println("Jugador " + (i + 1) + ":");
                System.out.println("  Nombre: " + jugador.obtenerNombre());
                System.out.println("  Puntos: " + jugador.obtenerPuntos());
                System.out.println("  Saldo: " + jugador.obtenerSaldo());
            }
        } catch (EOFException e) {
            System.out.println("Fin del archivo alcanzado.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace(); // Para ver más detalles del error
        }
    }
}
