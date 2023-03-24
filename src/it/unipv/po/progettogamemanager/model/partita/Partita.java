package it.unipv.po.progettogamemanager.model.partita;

import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;
import it.unipv.po.progettogamemanager.model.persistenza.Serializzabile;

public interface Partita extends Serializzabile {
    long getTimeStamp();
    Giocatore getGiocatore1();
    Giocatore getGiocatore2();
    Giocatore getVincitore();
    String getID();
    TipoPartita getTipo();

    static Partita getPartita(long timestamp,Giocatore vincitore,Giocatore perdente){
        if (vincitore.getTipo() != perdente.getTipo()){
            return new PartitaSbilanciata(timestamp, vincitore, perdente, vincitore);
        }
        else{
            return new PartitaParitaria(timestamp, vincitore, perdente, vincitore);
        }
    }
}
