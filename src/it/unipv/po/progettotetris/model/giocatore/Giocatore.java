package it.unipv.po.progettotetris.model.giocatore;

import it.unipv.po.progettotetris.model.persistenza.Serializzabile;

import java.util.Random;

public interface Giocatore extends Serializzabile {
    String getNome();
    String getPassword();
    int getPunteggioTotale();
    TipiGiocatore getTipo();

    public void aumentaPunti(int delta); //delta sarebbero i punti che guadagna se vince

    public static Giocatore getGiocatore(String nome, String password, TipiGiocatore tipo){
        //String ID = new Random().nextInt(10000000) + ""; // facendo +"" ---> lo converto in una stringa :)
        switch (tipo){
            case BEGGINNER:
                return new GiocatoreBegginner(nome, password, 0);
            case PROFESSIONAL:
                return new GiocatoreProfessional( nome, password, 0);
            default:
                throw new RuntimeException("TIPO GIOCATORE INVALIDO!");

        }

    }




}
