package com.mceserani;

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

		int opzione;

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
				opzione = sc.nextInt();
				sc.nextLine();
				if (opzione < 1 || opzione > 7)
					System.out.println("Opzione non valida!");
			}while(opzione < 1 || opzione > 7);

			switch(opzione){
				case 1: if (pos < N) {
							System.out.print("Inserisci modello: ");
							String modello = sc.nextLine();
							System.out.print("Obiettivo passi: ");
							int obiettivo = sc.nextInt();
							sc.nextLine();
							sws[pos] = new Smartwatch(modello, obiettivo);
							pos++;
						}else {
							System.out.println("Impossibile creare nuovi smartwatch");
						}
						break;
				case 2: System.out.print("Inserisci id: ");
						int id = sc.nextInt();
						sc.nextLine();
						int i;
						for(i = 0; i < pos; i++){
							if(sws[i].getId() == id){
								System.out.println(sws[i].toString());
								break;
							}
						}
						if(i == pos)
							System.out.println("Smartwatch non presente.");
						break;

			}

		}while(opzione != 7);
		System.out.println("Bye!");

		sc.close();

    }

}