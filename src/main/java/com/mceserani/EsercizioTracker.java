package com.mceserani;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EsercizioTracker {
	
	static final int N = 10;

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

		Smartwatch sws[] = new Smartwatch[N];
		int pos = 0;

		int opzione = 0;
		int obiettivo = 0, id = 0, passi = 0;

		int i;

		do{ // ciclo principale

			do{
				System.out.println("Benvenuto! Scegli un'opzione.");
				System.out.println("1. Crea nuovo Smartwatch");
				System.out.println("2. Visualizza dati di uno Smartwatch");
				System.out.println("3. Visualizza dati di tutti gli Smartwatch");
				System.out.println("4. Aggiungi passi a uno Smartwatch");
				System.out.println("5. Aggiungi passi a tutti gli Smartwatch");
				System.out.println("6. Imposta frequenza cardiaca");
				System.out.println("7. Esci");
				opzione = EsercizioTracker.getPosInt(sc);
				if (opzione < 1 || opzione > 7)
					System.out.println("Opzione non valida!");
			}while(opzione < 1 || opzione > 7);

			switch(opzione){
				case 1: if (pos < N) {
							System.out.print("Inserisci modello: ");
							String modello = sc.nextLine();
							System.out.print("Obiettivo passi: ");
							obiettivo = EsercizioTracker.getPosInt(sc);
							sws[pos] = new Smartwatch(modello, obiettivo);
							pos++;
						}else {
							System.out.println("Impossibile creare nuovi smartwatch");
						}
						break;
				case 2: System.out.print("Inserisci id: ");
						id = EsercizioTracker.getPosInt(sc);
						for(i = 0; i < pos; i++){
							if(sws[i].getId() == id){
								System.out.println(sws[i].toString());
								break;
							}
						}
						if(i == pos)
							System.out.println("Smartwatch non presente.");
						break;
				case 3: for(i = 0; i < pos; i++){
							System.out.println(sws[i].toString());
						}
						break;
				case 4: System.out.print("Inserisci id: ");
						id = EsercizioTracker.getPosInt(sc);
						for(i = 0; i < pos; i++){
							if(sws[i].getId() == id){
								break;
							}
						}
						if (i == pos)
							System.out.println("Orologio non presente");
						else {
							System.out.print("Inserisci passi: ");
							passi = EsercizioTracker.getPosInt(sc);
							sws[i].aggiungiPassi(passi);
						}
						break;
				case 5: System.out.print("Inserisci passi: ");
						passi = EsercizioTracker.getPosInt(sc);
						for(i = 0; i < pos; i++){
							sws[i].aggiungiPassi(passi);
						}
						break;
				case 6: System.out.print("Inserisci id: ");
						id = EsercizioTracker.getPosInt(sc);
						for(i = 0; i < pos; i++){
							if(sws[i].getId() == id){
								break;
							}
						}
						if (i == pos)
							System.out.println("Orologio non presente");
						else {
							int freq;
							System.out.print("Inserisci frequenza cardiaca: ");
							freq = EsercizioTracker.getPosInt(sc);
							try {
								sws[i].setFrequenzaCardiaca(freq);
							} catch (IllegalArgumentException e) {
								System.out.println(e.getMessage());
							}
						}
						break;
				case 7: break;
				default: System.out.println("Opzione non valida");
			}

		}while(opzione != 7);
		System.out.println("Bye!");

		sc.close();

    }

	private static int getPosInt(Scanner sc){
		int num = 0;
		do {
			try {
				num = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Errore! Inserire un numero intero!");
				num = 0;
				sc.nextLine();
			} catch (IllegalStateException | NoSuchElementException e) {
				System.out.println("Ops... C'è stato un problema. Riprova.");
				num = 0;
				sc.nextLine();
			}
			if (num<=0)
				System.out.println("Il numero deve essere positivo");
		}while(num <= 0);
		return num;
	} 

}