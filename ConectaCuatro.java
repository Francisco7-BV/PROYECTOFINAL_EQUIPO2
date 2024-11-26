/**                
 * Clase ConectaCuatro que simula un juego de Conecta cuatro                
 * @author Equipo 2. Barreto Velázquez Francisco, Valdez Altamirano Arely Nataly   
 * @version 1.0
 */

import java.util.Random;
public class ConectaCuatro{
    private char [] [] tablero = new char [6] [7]; //Atributo tablero

    /**   
     * Metodo constructor de un tablero por omision                                
     */

    public ConectaCuatro(){               
        for(int i=0 ; i<tablero.length ; i++){         
            for(int j=0 ; j<tablero[i].length; j++){ 
                tablero[i][j]=' ';    
            }                                                                                                      
        }                                  
    }                      

      /**                                 
     * Metodo que representa un tablero de 6 x 7                  
     * @return String representacion de tablero    
     */

    @Override
    public String toString(){
	        String cadena = "-----------------------------";
	String representacion = "  0   1   2   3   4   5   6  \n"
	                      + cadena + "\n"
	    + "| " + tablero[0][0] +  " | " +  tablero[0][1] + " | " + tablero[0][2] + " | " + tablero[0][3] +	" | " + tablero[0][4] + " | " + tablero[0][5] +	" | " + tablero[0][6] +  " | " + "\n" 
	                      + cadena + "\n"
            + "| " + tablero[1][0] +  " | " +  tablero[1][1] + " | " + tablero[1][2] + " | " + tablero[1][3] +  " | " + tablero[1][4] + " | " + tablero[1][5] + " | " + tablero[1][6] +  " | " + "\n" 
	                      + cadena + "\n"
            + "| " + tablero[2][0] +  " | " +  tablero[2][1] + " | " + tablero[2][2] + " | " + tablero[2][3] +  " | " + tablero[2][4] + " | " + tablero [2][5] + " | " + tablero[2][6] +  " | " + "\n" 
	                      + cadena + "\n"
            + "| " + tablero[3][0] +  " | " +  tablero[3][1] + " | " + tablero[3][2] + " | " + tablero[3][3] +  " | " + tablero[3][4] + " | " + tablero[3][5] + " | " + tablero[3][6] +  " | " + "\n"
	                      + cadena + "\n"
            + "| " + tablero[4][0] +  " | " +  tablero[4][1] + " | " + tablero[4][2] + " | " + tablero[4][3] +  " | " + tablero[4][4] + " | " + tablero [4][5] + " | " + tablero[4][6] +  " | " + "\n"
                              + cadena + "\n"
            + "| " + tablero[5][0] +  " | " +  tablero[5][1] + " | " + tablero[5][2] + " | " + tablero[5][3] +  " | " + tablero[5][4] + " | " + tablero[5][5] + " | " + tablero[5][6] + " | " + "\n"
	                      + cadena + "\n";

	return representacion;
    }

    /**
     * Metodo que determina si una casilla esta ocupada
     *
     */

    public boolean estaOcupada(int fila, int columna){
	if (tablero[fila][columna] != ' '){
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * Metodo que coloca una ficha en una columna de tablero
     *
     */

    public void colocarFigura(int columna, char simbolo){
	    if (this.estaOcupada(5,columna) == false){
    	    tablero[5][columna] = simbolo;
    	} else
		{ if (this.estaOcupada(4,columna) == false){
    		    tablero[4][columna] = simbolo;
    		} else
			{ if (this.estaOcupada(3,columna) == false){
                  tablero[3][columna] = simbolo;
    		} else
				{ if (this.estaOcupada(2,columna) == false){
    		    tablero[2][columna] = simbolo;
    		} else
					{ if (this.estaOcupada(1,columna) == false){
                  tablero[1][columna] = simbolo;
    		} else
						{ if (this.estaOcupada(0,columna) == false){
                  tablero[0][columna] = simbolo;
    		} else
    							{
    							}
    						}
    				       }
    			      }
    		     }
    	    }
    }


    /**
     * Metodo que verifica si se han conectado 4 fichas con simbolos iguales horizontalmente
     *
     */
 
    boolean horizontal;
      public boolean verificacionHorizontal(){
          for (int i=0; i<=5; i++){
    	    for (int j=0; j<=3; j++){
    		if ((tablero[i][j] == tablero[i][j+1]) && (tablero [i][j] == tablero[i][j+2]) && (tablero [i][j] == tablero[i][j+3])){
		    horizontal = true;
		} else
		    { horizontal = false;
		    }
	    }
	}

	  if (horizontal == true) {
	      return true;
	  } else
	      return false;
      }

    /**
     * Metodo que verifica si se han conectado 4 fichas con simbolos iguales verticalmente
     *
     */
    
        boolean vertical;
      public boolean verificacionVertical(){
          for (int i=0; i<=6; i++){
            for (int j=0; j<=2; j++){
                if ((tablero[j][i] == tablero[j+1][i]) && (tablero [j][i] == tablero[j+2][i]) && (tablero [j][i] == tablero[j+3][i])){
                    vertical = true;
                } else
                    { vertical = false;
                    }
            }
        }

          if (vertical == true) {
              return true;
          } else
              return false;
      }

    /**
     * Metodo que verifica si se han conectado 4 fichas con simbolos iguales dioagonalmente a 135°
     *
     */

    public boolean verificacionDiagonal135(){
	if  (
	     ((tablero[2][0] == tablero[3][1]) && (tablero[2][0] == tablero[4][2]) && (tablero [2][0] == tablero[5][3])) ||
	     ((tablero[1][0] == tablero[2][1]) && (tablero[1][0] == tablero[3][2]) && (tablero [2][0] == tablero[4][3])) ||
	     ((tablero[2][1] == tablero[3][2]) && (tablero[2][1] == tablero[4][3]) && (tablero [2][1] == tablero[5][4])) ||
	     ((tablero[0][0] == tablero[1][1]) && (tablero[0][0] == tablero[2][2]) && (tablero [0][0] == tablero[3][3])) ||
	     ((tablero[1][1] == tablero[2][2]) && (tablero[1][1] == tablero[3][3]) && (tablero [1][1] == tablero[4][4])) ||
	     ((tablero[2][2] == tablero[3][3]) && (tablero[2][2] == tablero[4][4]) && (tablero [2][2] == tablero[5][5])) ||
	     ((tablero[0][1] == tablero[1][2]) && (tablero[0][1] == tablero[2][3]) && (tablero [0][1] == tablero[3][4])) ||
	     ((tablero[1][2] == tablero[2][3]) && (tablero[1][2] == tablero[3][4]) && (tablero [1][2] == tablero[4][5])) ||
	     ((tablero[2][3] == tablero[3][4]) && (tablero[2][3] == tablero[4][5]) && (tablero [2][3] == tablero[5][6])) ||
	     ((tablero[0][2] == tablero[1][3]) && (tablero[0][2] == tablero[2][4]) && (tablero [0][2] == tablero[3][5])) ||
	     ((tablero[1][3] == tablero[2][4]) && (tablero[1][3] == tablero[3][5]) && (tablero [1][3] == tablero[4][6])) ||
	     ((tablero[0][3] == tablero[1][4]) && (tablero[0][3] == tablero[2][5]) && (tablero [0][3] == tablero[3][6]))
	     ){

	    return true;
	} else
	    {
	    return false;
	    }
    }
    
    /**
     * Metodo que verifica si se han conectado 4 fichas con simbolos iguales dioagonalmente a 45°
     *
     */

        public boolean verificacionDiagonal45(){                                                                                                                                                       
        if  (                                                                                                                                                                                   
             ((tablero[0][3] == tablero[1][2]) && (tablero[0][3] == tablero[2][1]) && (tablero [0][3] == tablero[3][0])) ||       
             ((tablero[0][4] == tablero[1][3]) && (tablero[0][4] == tablero[2][2]) && (tablero [0][4] == tablero[3][1])) ||   
             ((tablero[1][3] == tablero[2][2]) && (tablero[1][3] == tablero[3][1]) && (tablero [1][3] == tablero[4][0])) ||  
             ((tablero[0][5] == tablero[1][4]) && (tablero[0][5] == tablero[2][3]) && (tablero [0][5] == tablero[3][2])) ||  
             ((tablero[1][4] == tablero[2][3]) && (tablero[1][4] == tablero[3][2]) && (tablero [1][4] == tablero[4][1])) ||  
             ((tablero[2][3] == tablero[3][2]) && (tablero[2][3] == tablero[4][1]) && (tablero [2][3] == tablero[5][0])) ||     
             ((tablero[0][6] == tablero[1][5]) && (tablero[0][6] == tablero[2][4]) && (tablero [0][6] == tablero[3][3])) ||   
             ((tablero[1][5] == tablero[2][4]) && (tablero[1][5] == tablero[3][3]) && (tablero [1][5] == tablero[4][2])) ||        
             ((tablero[2][4] == tablero[3][3]) && (tablero[2][4] == tablero[4][2]) && (tablero [2][4] == tablero[5][1])) ||     
             ((tablero[1][6] == tablero[2][5]) && (tablero[1][6] == tablero[3][4]) && (tablero [1][6] == tablero[4][3])) ||     
             ((tablero[2][5] == tablero[3][4]) && (tablero[2][5] == tablero[4][3]) && (tablero [2][5] == tablero[5][2])) ||                
             ((tablero[2][6] == tablero[3][5]) && (tablero[2][6] == tablero[4][4]) && (tablero [2][6] == tablero[5][3])) 
             ){                                                                                                                                                                               
                            
            return true;                                   
        } else   
            {      
            return false;        
            }                                                                                              
    }

    /**
     * Metodo que determina si un jugador ha ganado (Ha colocado 4 fichas con el ismo simbolo juntas) (En cualquier direccion)
     *
     */

    public boolean haGanado(){
	if ((this.verificacionDiagonal45() == true) || (this.verificacionDiagonal135() == true) || (this.verificacionHorizontal() == true) || (this.verificacionVertical() == true)){
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * Metodo que determina si el tablero esta lleno
     *
     */

    public boolean tableroLleno(){
	if ((tablero [0][0] != ' ') && (tablero [0][1] != ' ') && (tablero [0][2] != ' ') && (tablero [0][3] != ' ') && (tablero [0][4] != ' ') && (tablero [0][5] != ' ') &&
 	    (tablero [0][6] != ' ') &&
	    (tablero [1][0] != ' ') && (tablero [1][1] != ' ') && (tablero [1][2] != ' ') && (tablero [1][3] != ' ') && (tablero [1][4] != ' ') && (tablero [1][5] != ' ') &&
            (tablero [1][6] != ' ') &&
	    (tablero [2][0] != ' ') && (tablero [2][1] != ' ') && (tablero [2][2] != ' ') && (tablero [2][3] != ' ') && (tablero [2][4] != ' ') && (tablero [2][5] != ' ') &&
            (tablero [2][6] != ' ') &&
	    (tablero [3][0] != ' ') && (tablero [3][1] != ' ') && (tablero [3][2] != ' ') && (tablero [3][3] != ' ') && (tablero [3][4] != ' ') && (tablero [3][5] != ' ') &&
            (tablero [3][6] != ' ') &&
	    (tablero [4][0] != ' ') && (tablero [4][1] != ' ') && (tablero [4][2] != ' ') && (tablero [4][3] != ' ') && (tablero [4][4] != ' ') && (tablero [4][5] != ' ') &&
            (tablero [4][6] != ' ') &&
	    (tablero [5][0] != ' ') && (tablero [5][1] != ' ') && (tablero [5][2] != ' ') && (tablero [5][3] != ' ') && (tablero [5][4] != ' ') && (tablero [5][5] != ' ') &&
            (tablero [5][6] != ' ') &&
	    (tablero [6][0] != ' ') && (tablero [6][1] != ' ') && (tablero [6][2] != ' ') && (tablero [6][3] != ' ') && (tablero [6][4] != ' ') && (tablero [6][5] != ' ') &&
            (tablero [6][6] != ' ')
	    ) {
	    return true;
	} else {
	    return false;
	}
    }
    
    
public static void main (String [] args){
    ConectaCuatro prueba = new ConectaCuatro();
    String muestra =prueba.toString();
    System.out.println(muestra);

    prueba.colocarFigura(3,'X');
    System.out.println(prueba.toString());

    prueba.colocarFigura(3,'O');
    System.out.println(prueba.toString());

}
}
