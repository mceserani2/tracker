package com.mceserani;

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
       
		Smartwatch sportWatchX = new Smartwatch("SportWatch");
	   	Smartwatch fitnessBandZ = new Smartwatch("FitnessBand");

		sportWatchX.aggiungiPassi(3500);
		fitnessBandZ.aggiungiPassi(7235);

		System.out.println(Smartwatch.stampaPassiTotali());

		if (sportWatchX.equals(fitnessBandZ)) {
			System.out.println("Gli orologi sono uguali");
		} else {
			System.out.println("Gli orologi sono diversi");
		}

		System.out.println(Smartwatch.calcolaKm(fitnessBandZ.getPassiEffettuati()));

    }

}