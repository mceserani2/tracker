package com.mceserani;

import java.lang.IllegalArgumentException;

public class Smartwatch {

    private static final int MinBPM = 40;
    private static final int MaxBPM = 220;

    private static int smartwatchProdotti = 0;
    private static int totalePassiTuttiUtenti = 0;

    private int id;
    private String modello;
    private int passiEffettuati;
    private int obiettivoPassi;
    private int frequenzaCardiaca;

    public Smartwatch(String modello, int obiettivoPassi){
        this.id = ++smartwatchProdotti;
        this.modello = modello;
        this.obiettivoPassi = obiettivoPassi;
        this.passiEffettuati = 0;
    }

    public Smartwatch(String modello){
        this.id = ++smartwatchProdotti;
        this.modello = modello;
        this.obiettivoPassi = 10000;
        this.passiEffettuati = 0;
    }

    public static double calcolaKm(int passi){
        return passi/1400.0;
    }

    // Getters and Setters

    public int getId() {
        return this.id;
    }
    
    // Il setter di Id non viene implementato
    // perché si vuole che l'Id dello SW non sia modificabile
    
    public String getModello() {
        return modello;
    }
    
    public void setModello(String modello) {
        this.modello = modello;
    }
    
    public int getPassiEffettuati() {
        return passiEffettuati;
    }
    
    public void setPassiEffettuati(int passiEffettuati) {
        this.passiEffettuati = passiEffettuati;
    }
    
    public int getObiettivoPassi() {
        return obiettivoPassi;
    }
    
    public void setObiettivoPassi(int obiettivoPassi) {
        this.obiettivoPassi = obiettivoPassi;
    }
    
    public int getFrequenzaCardiaca() {
        return frequenzaCardiaca;
    }
    
    public void setFrequenzaCardiaca(int frequenzaCardiaca) throws IllegalArgumentException {
        if (frequenzaCardiaca < MinBPM || frequenzaCardiaca > MaxBPM)
            throw new IllegalArgumentException("Frequenza cardiaca non valida. Deve essere compresa tra " + MinBPM + " e " + MaxBPM);
        else
            this.frequenzaCardiaca = frequenzaCardiaca;
    }

    public static int getPassiTotaliTuttiUtenti(){
        return totalePassiTuttiUtenti;
    }

    // Aggiungi passi
    public void aggiungiPassi(int passi){
        this.passiEffettuati += passi;
        totalePassiTuttiUtenti += passi;
    }

    // toString
    @Override
    public String toString() {
        return "Smartwatch [id=" + id + ", modello=" + modello + ", passiEffettuati=" + passiEffettuati
                + ", obiettivoPassi=" + obiettivoPassi + ", frequenzaCardiaca=" + frequenzaCardiaca + "]";
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Smartwatch other = (Smartwatch) obj;
        if (id != other.id || !modello.equals(other.modello) || obiettivoPassi != other.obiettivoPassi)
            return false;
        return true;
    }

}
