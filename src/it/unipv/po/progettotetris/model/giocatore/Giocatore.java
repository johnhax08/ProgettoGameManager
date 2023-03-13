package it.unipv.po.progettotetris.model.giocatore;

public interface Giocatore {
    String getID();
    String getNome();
    String getPassword();
    int getPunteggioTotale();
    TipiGiocatore getTipo();

    public void aumentaPunti(int delta); //delta sarebbero i punti che guadagna se vince



}
