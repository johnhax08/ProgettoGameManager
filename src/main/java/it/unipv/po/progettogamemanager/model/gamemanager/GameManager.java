package it.unipv.po.progettogamemanager.model.gamemanager;
import it.unipv.po.progettogamemanager.model.giocatore.GiocatoreManager;
import it.unipv.po.progettogamemanager.model.partita.PartitaManager;

public interface GameManager extends GiocatoreManager, PartitaManager {
     static GameManager getGameManager(){
        return new BasicGameManager();
    }
    void addListener(Listener listener);

     void switchTo(Pagine titolo);

}
