package it.unipv.po.progettotetris.model.facade;

import it.unipv.po.progettotetris.model.giocatore.Giocatore;
import it.unipv.po.progettotetris.model.giocatore.GiocatoreManager;
import it.unipv.po.progettotetris.model.partita.Partita;
import it.unipv.po.progettotetris.model.partita.PartitaManager;

import java.util.ArrayList;
import java.util.List;

public class BasicController implements Controller {
    protected PartitaManager pm;
    protected GiocatoreManager gm;
    protected List <Listener> elencoListeners;
    protected TitoloFinestra paginaAttuale;
    protected String giocatoreAttuale;

    public BasicController() {
        pm = PartitaManager.getPartitaManager();
        gm = GiocatoreManager.getGiocatoreManager();
        elencoListeners =  new ArrayList<>();
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
    public List<Partita> filtro(Long timestamp, String g, String vincitore) {
        return pm.filtro(timestamp,g,vincitore);
    }

    @Override
    public Giocatore getGiocatoreByID(String ID) {
        return gm.getGiocatoreByID(ID);
    }

    @Override
    public void addListener(Listener listener) {
        elencoListeners.add(listener);
    }

    @Override
    public void switchTo(TitoloFinestra titolo) {
        this.paginaAttuale = titolo;
        System.out.println(titolo);
        for(Listener listener : elencoListeners){
            listener.switchTo(titolo);
        }
    }

    @Override
    public void setGiocatoreAttuale(String nome) {
        this.giocatoreAttuale = nome;
    }

    @Override
    public Giocatore getGiocatoreAttuale() {
        return getGiocatoreByID(giocatoreAttuale);

    }
}
