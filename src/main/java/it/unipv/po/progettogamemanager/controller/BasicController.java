package it.unipv.po.progettogamemanager.controller;
import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;
import it.unipv.po.progettogamemanager.model.giocatore.GiocatoreManager;
import it.unipv.po.progettogamemanager.model.partita.Partita;
import it.unipv.po.progettogamemanager.model.partita.PartitaManager;
import java.util.ArrayList;
import java.util.List;

public class BasicController implements Controller {
    protected PartitaManager pm;
    protected GiocatoreManager gm;
    protected List <Listener> elencoListeners;
    protected Pagine paginaAttuale; //non viene inizializzata perchè all'inizio è null.


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
    public boolean authenticate(String ID, int password) {
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
    public Giocatore getGiocatoreByNome(String ID) {
        return gm.getGiocatoreByNome(ID);
    }

    @Override
    public void addListener(Listener listener){                                                                                //è una cosa antiva di basic controller quindi aggiunge un nuovo listener.
        elencoListeners.add(listener);
    }

    @Override
    public void switchTo(Pagine titolo) {
        this.paginaAttuale = titolo;
        for(Listener listener : elencoListeners){
            listener.updatePagina(titolo); //notifica tutti i listener
        }
    }

    @Override
    public void setGiocatoreAttuale(String nome) { //delega il funzionamento al giocatore manager
        this.gm.setGiocatoreAttuale(nome);
    }

    @Override
    public Giocatore getGiocatoreAttuale() {
        return gm.getGiocatoreAttuale();

    }
}
