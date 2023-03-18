package it.unipv.po.progettotetris.model.facade;

import it.unipv.po.progettotetris.model.giocatore.Giocatore;
import it.unipv.po.progettotetris.model.giocatore.GiocatoreManager;
import it.unipv.po.progettotetris.model.partita.PartitaManager;

public interface Controller extends GiocatoreManager, PartitaManager {
     static Controller getController(){
        return new BasicController();
    }
    void addListener(Listener listener);

     void switchTo(TitoloFinestra titolo);

     void setGiocatoreAttuale(String nome);

    Giocatore getGiocatoreAttuale();
}
