package it.unipv.po.progettotetris.model.facade;

import it.unipv.po.progettotetris.model.giocatore.GiocatoreManager;
import it.unipv.po.progettotetris.model.partita.PartitaManager;

public interface Controller extends GiocatoreManager, PartitaManager {
    static Controller getController(){
        return new BasicController();
    }
}
