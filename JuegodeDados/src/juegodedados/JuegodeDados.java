/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodedados;

import java.util.Scanner;
import static juegodedados.Dados.jugadores;
import static juegodedados.Dados.lanzamiento;
import static juegodedados.Dados.tablaPuntuaciones;

/**
 *
 * @author MAO PANTOJA
 */
public class JuegodeDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ANSI_RED = "\u001B[31m";
        Scanner input = new Scanner(System.in);
        int n;
        do {
            System.out.println("Digita numero de jugadores minimo 2 maximo 4");
            n = Integer.parseInt(input.nextLine());
            if (n >= 2 && n <= 4) {
                break;
            } else {
                System.out.println(ANSI_RED + "Valor introducido incorrecto");

            }
        } while (true);

        jugadores = new String[n];
        tablaPuntuaciones = new int[n][3];

        
        System.out.println("\nIntroduzca nombres.");
        for (int i = 0; i < n; i++) {
            System.out.printf("Jugador #%d: ", (i + 1));
            jugadores[i] = input.nextLine();
        }
        //************************
        boolean salir = false;

        while (!salir) {

            System.out.println("1. Nivel básico (Tablero de 20 posiciones)");
            System.out.println("2.Nivel intermedio (Tablero de 30 posiciones)");
            System.out.println("3. Nivel avanzado (Tablero de 50 posiciones)");
            System.out.println("4. Salir");
         
            System.out.println("Seleccione el nivel ajugar ");
           int  opcion = Integer.parseInt(input.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("1. Nivel básico (Tablero de 20 posiciones)");

                    boolean hayGanador = false;

                    for (int i = 0; i < 3 && !hayGanador; i++) {
                        System.out.print("\n\t\t\tTURNO #" + (i + 1));

                        
                        for (int j = 0; j < jugadores.length && !hayGanador; j++) {

                            System.out.printf("\n\nLanza el jugador %s --> ", jugadores[j]);
                           
                            int[] dados = lanzamiento();
                            System.out.printf("Dado1: %d\tDado2: %d", dados[0], dados[1]);
                          
                            if (dados[0] == dados[1]) {
                                System.out.println("\nHa ganado el Jugador " + jugadores[j]);
                                hayGanador = true; 
                            } else { 
                                tablaPuntuaciones[j][i] = dados[0] + dados[1];
                            }
                            
                        }
                        System.out.println("\n\n\t\tPULSE INTRO PARA CONTINUAR");
                       input.nextLine();
                        
                    }

                    if (!hayGanador) {
                        int mayorPunt = 0;
                        String jugadorMayorPunt = new String();
                        System.out.println("\n\n\t\tTABLA DE RESULTADOS");
                        for (int i = 0; i < jugadores.length; i++) {
                            System.out.print("\n" + jugadores[i]);
                            for (int j = 0; j < 3; j++) {
                                int puntos = tablaPuntuaciones[i][j];
                                System.out.print("\t" + puntos); 
                                if (puntos > mayorPunt) {
                                    mayorPunt = puntos;
                                    jugadorMayorPunt = jugadores[i];
                                }
                            }
                        }

                    
                        System.out.printf("\n\n***Ha ganado %s al conseguir un puntaje de %d***", jugadorMayorPunt, mayorPunt);
                    }
                    input.close();
                    System.out.println("\n\n\t\t\tFIN DE PROGRAMA");

                    break;
                case 2:
                    System.out.println("2. Nivel intermedio (Tablero de 30 posiciones)");
                    int[] TableroIntermedio = new int[20];
                    break;
                case 3:
                    System.out.println("3. Nivel avanzado (Tablero de 50 posiciones)");
                    int[] TableroAvanzado = new int[20];
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println(ANSI_RED + "debe selecionar una opcion entre 1 y 4");
            }

        }
    }
}

        //*************

