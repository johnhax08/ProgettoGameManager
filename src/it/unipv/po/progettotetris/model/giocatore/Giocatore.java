package it.unipv.po.progettotetris.model.giocatore;

import it.unipv.po.progettotetris.model.persistenza.Serializzabile;

public interface Giocatore extends Serializzabile {
    String getID();
    String getNome();
    String getPassword();
    int getPunteggioTotale();
    TipiGiocatore getTipo();

    public void aumentaPunti(int delta); //delta sarebbero i punti che guadagna se vince



}
