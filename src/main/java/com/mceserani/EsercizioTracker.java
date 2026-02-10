package com.mceserani;

import java.util.Scanner;

public class EsercizioTracker {
	
	private EsercizioTracker(){
	}

	/**
	 * 
	 * @param args Command line arguments
	 * @author 
	 * @version 
	 */
    public static void main(String[] args){
       
		Scanner sc = new Scanner(System.in);

		Smartwatch sws[] = new Smartwatch[10];
		int pos = 0;

		int opzione;

		do{
			System.out.println("Benvenuto! Scegli un'opzione.");
			System.out.println("1. Crea nuovo Smartwatch");
			System.out.println("2. Visualizza dati di uno Smartwatch");
			System.out.println("3. Visualizza dati di tutti gli Smartwatch");
			System.out.println("4. Aggiungi passi a uno Smartwatch");
			System.out.println("5. Aggiungi passi a tutti gli Smartwatch");
			System.out.println("6. Imposta frequenza cardiaca");
			System.out.println("7. Esci");
			opzione = sc.nextInt();
			sc.nextLine();
			if (opzione < 1 || opzione > 7)
				System.out.println("Opzione non valida!");
		}while(opzione < 1 || opzione > 7);

		switch(opzione){
			case 1: ...
					if (pos < 10) {
						sws[pos] = new Smartwatch(...);
						pos++
					else {
						...
					}

		}

		sc.close();

    }

}