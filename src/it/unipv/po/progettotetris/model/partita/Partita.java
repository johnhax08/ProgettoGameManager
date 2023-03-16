package it.unipv.po.progettotetris.model.partita;

import it.unipv.po.progettotetris.model.giocatore.Giocatore;
import it.unipv.po.progettotetris.model.persistenza.Serializzabile;

public interface Partita extends Serializzabile {
    long getTimeStamp();
    Giocatore getGiocatore1();
    Giocatore getGiocatore2();
    Giocatore getVincitore();

    String getID();
    TipoPartita getTipo();
}
