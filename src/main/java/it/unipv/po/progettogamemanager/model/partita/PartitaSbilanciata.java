package it.unipv.po.progettogamemanager.model.partita;

import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;

public class PartitaSbilanciata extends PartitaABS {
    public PartitaSbilanciata(long timeStamp, String giocatore1, String giocatore2, String vincitore) {
        super(timeStamp, giocatore1, giocatore2, vincitore, TipoPartita.SBILANCIATA);
    }
}
