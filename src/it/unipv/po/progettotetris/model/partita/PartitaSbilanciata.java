package it.unipv.po.progettotetris.model.partita;

import it.unipv.po.progettotetris.model.giocatore.Giocatore;

public class PartitaSbilanciata extends PartitaABS {
    public PartitaSbilanciata(long timeStamp, Giocatore giocatore1, Giocatore giocatore2, Giocatore vincitore) {
        super(timeStamp, giocatore1, giocatore2, vincitore, TipoPartita.SBILANCIATA);
    }
}
