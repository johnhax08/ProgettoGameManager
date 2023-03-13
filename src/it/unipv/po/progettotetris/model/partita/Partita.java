package it.unipv.po.progettotetris.model.partita;

import it.unipv.po.progettotetris.model.giocatore.Giocatore;

public interface Partita {
    long getTimeStamp();
    Giocatore getGiocatore1();
    Giocatore getGiocatore2();
    Giocatore getVincitore();

    TipoPartita getTipo();
}
