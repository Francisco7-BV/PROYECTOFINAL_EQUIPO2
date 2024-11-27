import java.io.Serializable;

public class Jugador implements Serializable{
    String nombre;
    int saldo;
    int puntos;

    public Jugador(String nombre){
	this.nombre = nombre;
	this.saldo = 100;
	this.puntos = 0;
    }

    public Jugador(){
	this.nombre = "";
	this.saldo = 100;
	this.puntos = 0;
    }
    
    public void asignarNombre(String nombre){
        this.nombre = nombre;
    }

    public void sumarSaldo(int saldo){
	this.saldo += saldo;
    }

    public void asignarSaldo(int saldo){
	this.saldo = saldo;
    }

    public void	restarSaldo(int saldo){
        this.saldo -= saldo;
    }

    public void	sumarPuntos(int puntos){
        this.puntos += puntos;
    }

    public void restarPuntos(int puntos){
	this.puntos -= puntos;
    }

    public String obtenerNombre(){
	return nombre;
    }

    public int obtenerSaldo(){
	return saldo;
    }

    public int obtenerPuntos(){
	return puntos;
    }

    @Override

    public String toString(){
	String representacion = "\n \n" +
	                        "//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\" + "\n" +
	                        " JUGADOR =   " + this.obtenerNombre() + "\n" +
	                        " SALDO ACTUAL =   " + this.obtenerSaldo() + " creditos restantes" + "\n" +
	                        " PUNTAJE ACTUAL =   " + this.obtenerPuntos() + " puntos acumulados" + "\n" +
	                        "//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\" +
	                        "\n \n";
	return representacion;
    }
}
    
