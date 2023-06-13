package it.unipv.po.progettogamemanager.model.partita;

import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;

public class PartitaParitaria extends PartitaABS {
    public PartitaParitaria(long timeStamp, String giocatore1, String giocatore2, String vincitore) {
        super(timeStamp, giocatore1, giocatore2, vincitore, TipoPartita.PARITARIA);
    }
}
