package it.unipv.po.progettotetris.model.facade;

import it.unipv.po.progettotetris.model.giocatore.Giocatore;
import it.unipv.po.progettotetris.model.giocatore.GiocatoreManager;
import it.unipv.po.progettotetris.model.partita.Partita;
import it.unipv.po.progettotetris.model.partita.PartitaManager;

import java.util.List;

public class BasicController implements Controller {
    protected PartitaManager pm;
    protected GiocatoreManager gm;

    public BasicController() {
        pm = PartitaManager.getPartitaManager();
        gm = GiocatoreManager.getGiocatoreManager();
    }

    @Override
    public void addGiocatore(Giocatore g) {
      gm.addGiocatore(g);
    }

    @Override
    public void removeGiocatore(Giocatore g) {
        gm.removeGiocatore(g);

    }

    @Override
    public boolean authenticate(String ID, String password) {
        return gm.authenticate(ID, password);
    }

    @Override
    public void addPartita(Partita p) {
        pm.addPartita(p);

    }

    @Override
    public void removePartita(Partita p) {
        pm.removePartita(p);

    }

    @Override
    public List<Partita> filtro(long timestamp, String g1, String g2, String vincitore) {
        return pm.filtro(timestamp,g1,g2,vincitore);
    }
}
