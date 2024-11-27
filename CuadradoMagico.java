/**
 * Clase CuadroMagico que simula un juego de cuadro mágico en una cuadricula de 4x4
 * @author Equipo 2. Barreto Velázquez Francisco, Valdez Altamirano Arely Nataly
 * @version 1.0
 */
import java.util.Random;
 public class CuadradoMagico {
    private String [] [] cuadrado = new String [4] [4]; //Atributo cuadrado

    /**
     * Metodo constructor de un cuadro por omision
     */
    
    public CuadradoMagico(){

    for(int i=0 ; i<cuadrado.length ; i++){
            for(int j=0 ; j<cuadrado[i].length; j++){
            cuadrado[i][j]=" ";
    
            }}


    int num1, num2, num3, num4;
    Random random = new Random();
        
        // Ciclo para generar números que sumen 34 y sean únicos
        while (true) {
            num1 = random.nextInt(16) + 1;
            num2 = random.nextInt(16) + 1;
            num3 = random.nextInt(16) + 1;
            num4 = random.nextInt(16) + 1;
            
            // Verificar la suma y si los números son únicos
            if ((num1 + num2 + num3 + num4 == 34) && 
                (num1 != num2) && (num1 != num3) && (num1 != num4) && 
                (num2 != num3) && (num2 != num4) && (num3 != num4)) {
                break; // Salir del ciclo si se cumple la condición
            }
        }
        String c1 = Integer.toString(num1);
        String c2 = Integer.toString(num2);
        String c3 = Integer.toString(num3);
        String c4 = Integer.toString(num4);

    Random random1 = new Random();
    int opcion1= random1.nextInt(3);//elige opción arbitaria de 0=columna,1=fila,2=diagonal
    
    switch (opcion1) {
        case 0://columna
        Random random2 = new Random();
        int columna= random2.nextInt(4);//elige arbitrariamente una columna
        cuadrado [0][columna]=c1;
        cuadrado [1][columna]=c2;
        cuadrado [2][columna]=c3;
        cuadrado [3][columna]=c4;
            break;
    
        case 1://fila
        Random random3 = new Random();
        int fila= random3.nextInt(4);//elige arbitrariamente una fila
        cuadrado [fila][0]=c1;
        cuadrado [fila][1]=c2;
        cuadrado [fila][2]=c3;
        cuadrado [fila][3]=c4;

            break;
      
        case 2://diagonal
        Random random4 = new Random();
        int opcion4= random4.nextInt(2);//elige arbitrariamente una diagonal
            switch (opcion4) {
                case 0:
                    cuadrado [0][0]=c1;
                    cuadrado [1][1]=c2;
                    cuadrado [2][2]=c3;
                    cuadrado [3][3]=c4;
                    break;
            
                case 1:
                    cuadrado [0][3]=c1;
                    cuadrado [1][2]=c2;
                    cuadrado [2][1]=c3;
                    cuadrado [3][0]=c4;
                    break;
                default:
                    break;
            }

            break;
        
        default:
            break;
    }

	}
    



    /**
     * Metodo que representa un tablero de 4x4
     * @return String representacion de tablero
     */

    @Override
    public String toString(){
	String cadena = "-----------------";
	String representacion = "     0   1   2   3\n"
	    + "   " + cadena + "\n"
	    + "0  | " + cuadrado[0][0] + " | " + cuadrado[0][1] + " | " + cuadrado[0][2] + " | " + cuadrado[0][3] + " |\n"
	    + "   " + cadena + "\n"
	    + "1  | " + cuadrado[1][0] + " | " + cuadrado[1][1] + " | " + cuadrado[1][2] + " | " + cuadrado[1][3] + " |\n"
        + "   " + cadena +	"\n"
	    + "2  | " + cuadrado[2][0] + " | " + cuadrado[2][1] + " | " + cuadrado[2][2] + " | " + cuadrado[2][3] + " |\n"
		+ "   " +  cadena + "\n"
        + "3  | " + cuadrado[3][0] + " | " + cuadrado[3][1] + " | " + cuadrado[3][2] + " | " + cuadrado[3][3] + " |\n"
		+ "   " +  cadena + "\n";

	    return representacion;
		}

   
    /** Metodo que determina si una casilla esta ocupada
     *
     */

    public boolean estaOcupada(int fila, int columna){
	if (cuadrado[fila][columna] != " "){
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * Metodo que coloca un numero en el tablero de juego
     * @param fila fila en donde se colocara el número
     * @param columna columna en donde se colocara el número
     * @param numero numero a colocar en el tablero
     * @return boolean false si la casilla esta ocupada; true en caso contrario
     */

     public boolean colocarFigura(int fila, int columna, String numero){

        

	    if (0 <= fila && fila <= 3 && 0 <= columna && columna <= 3 && (estaOcupada(fila, columna)) ){
	    
	    return false;
	} else { if ((Integer.parseInt(numero)<=16) && (Integer.parseInt(numero)> 0) && (numero != cuadrado [0][0]) && (numero != cuadrado [0][1])
        && (numero != cuadrado [0][2]) && (numero != cuadrado [0][3]) && (numero != cuadrado [1][0]) && (numero != cuadrado [1][1]) 
        && (numero != cuadrado [1][2]) && (numero != cuadrado [1][3]) && (numero != cuadrado [2][0]) && (numero != cuadrado [2][1])
        && (numero != cuadrado [2][2]) && (numero != cuadrado [2][3]) && (numero != cuadrado [3][0]) && (numero != cuadrado [3][1])
        && (numero != cuadrado [3][2]) && (numero != cuadrado [3][3])){
	    cuadrado[fila][columna] = numero;

	    return true;
		}
	} return false;
}
    /**
     * Metodo que determina si el juego ha terminado
     * @return boolean true si algun jugador ha ganado o perdido; false en claso contrario
     */
    
     public boolean terminado(){
        int t1 = Integer.parseInt(cuadrado[0][0]);
        int t2 = Integer.parseInt(cuadrado[0][1]);
        int t3 = Integer.parseInt(cuadrado[0][2]);
        int t4 = Integer.parseInt(cuadrado[0][3]);
        int t5 = Integer.parseInt(cuadrado[1][0]);
        int t6 = Integer.parseInt(cuadrado[1][1]);
        int t7 = Integer.parseInt(cuadrado[1][2]);
        int t8 = Integer.parseInt(cuadrado[1][3]);
        int t9 = Integer.parseInt(cuadrado[2][0]);
        int t10 = Integer.parseInt(cuadrado[2][1]);
        int t11 = Integer.parseInt(cuadrado[2][2]);
        int t12 = Integer.parseInt(cuadrado[2][3]);
        int t13 = Integer.parseInt(cuadrado[3][0]);
        int t14 = Integer.parseInt(cuadrado[3][1]);
        int t15 = Integer.parseInt(cuadrado[3][2]);
        int t16 = Integer.parseInt(cuadrado[3][3]);

        int sum1=t1+t2+t3+t4;
        int sum2=t5+t6+t7+t8;
        int sum3=t9+t10+t11+t12;
        int sum4=t13+t14+t15+t16;
        int sum5=t1+t5+t9+t13;
        int sum6=t2+t6+t10+t14;
        int sum7=t3+t7+t11+t15;
        int sum8=t4+t8+t12+t16;
        int sum9=t1+t6+t11+t16;
        int sum10=t4+t7+t10+t13;

        if((sum1==34 && sum2==34 && sum3==34 && sum4==34 && sum5==34 && sum6==34 && sum7==34 && sum8==34 && sum9==34 && sum10==34)
        ||(sum1>34)||(sum2>34)||(sum3>34)||(sum4>34)||(sum5>34)||(sum6>34)||(sum7>34)||(sum8>34)||(sum9>34)||(sum10>34)){
            return true;
        }
        else {
            return false;
        }

     }

     /**
     * Metodo que determina quien es el ganador de juego
     * @return String con el ganador del juego
     */

    public String ganador(){
        int t1 = Integer.parseInt(cuadrado[0][0]);
        int t2 = Integer.parseInt(cuadrado[0][1]);
        int t3 = Integer.parseInt(cuadrado[0][2]);
        int t4 = Integer.parseInt(cuadrado[0][3]);
        int t5 = Integer.parseInt(cuadrado[1][0]);
        int t6 = Integer.parseInt(cuadrado[1][1]);
        int t7 = Integer.parseInt(cuadrado[1][2]);
        int t8 = Integer.parseInt(cuadrado[1][3]);
        int t9 = Integer.parseInt(cuadrado[2][0]);
        int t10 = Integer.parseInt(cuadrado[2][1]);
        int t11 = Integer.parseInt(cuadrado[2][2]);
        int t12 = Integer.parseInt(cuadrado[2][3]);
        int t13 = Integer.parseInt(cuadrado[3][0]);
        int t14 = Integer.parseInt(cuadrado[3][1]);
        int t15 = Integer.parseInt(cuadrado[3][2]);
        int t16 = Integer.parseInt(cuadrado[3][3]);

        int sum1=t1+t2+t3+t4;
        int sum2=t5+t6+t7+t8;
        int sum3=t9+t10+t11+t12;
        int sum4=t13+t14+t15+t16;
        int sum5=t1+t5+t9+t13;
        int sum6=t2+t6+t10+t14;
        int sum7=t3+t7+t11+t15;
        int sum8=t4+t8+t12+t16;
        int sum9=t1+t6+t11+t16;
        int sum10=t4+t7+t10+t13;

        if (sum1==34 && sum2==34 && sum3==34 && sum4==34 && sum5==34 && sum6==34 && sum7==34 && sum8==34 && sum9==34 && sum10==34){
   
            return "El jugador es el ganador";
        }
        else {
            if ((sum1>34)||(sum2>34)||(sum3>34)||(sum4>34)||(sum5>34)||(sum6>34)||(sum7>34)||(sum8>34)||(sum9>34)||(sum10>34)){
            return "El jugador a perdido";
            }
            } 
            return "El juego no ha terminado o las condiciones no son válidas.";
        }
       
    
    public static void main (String [] args){
        CuadradoMagico prueba = new CuadradoMagico();
        String muestra =prueba.toString();
        System.out.println(muestra);
        prueba.colocarFigura(0,0,"18");
        System.out.println(prueba.toString());

        prueba.colocarFigura(0, 3,"5");
        System.out.println(prueba.toString());
    }
}
