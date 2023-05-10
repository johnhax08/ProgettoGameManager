package it.unipv.po.progettogamemanager.model.facade;
import it.unipv.po.progettogamemanager.model.giocatore.GiocatoreManager;
import it.unipv.po.progettogamemanager.model.partita.PartitaManager;

public interface Controller extends GiocatoreManager, PartitaManager {
     static Controller getController(){
        return new BasicController();
    }
    void addListener(Listener listener);

     void switchTo(Pagine titolo);

}
