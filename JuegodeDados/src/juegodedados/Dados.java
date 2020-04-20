/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodedados;

/**
 *
 * @author MAO PANTOJA
 */
public class Dados {
    
 
	
	static String[] jugadores;
 
	
	static int[][] tablaPuntuaciones;
 
	
	static int[] lanzamiento() {
 
		int[] resultados = new int[2];
 
		resultados[0] = (int)(Math.random()*6 + 1);
		resultados[1] = (int)(Math.random()*6 + 1);
		
 
		return resultados;
	}
}
