package it.unipv.po.progettogamemanager.model.partita;

import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;

public class PartitaSbilanciata extends PartitaABS {
    public PartitaSbilanciata(long timeStamp, Giocatore giocatore1, Giocatore giocatore2, Giocatore vincitore) {
        super(timeStamp, giocatore1, giocatore2, vincitore, TipoPartita.SBILANCIATA);
    }
}
