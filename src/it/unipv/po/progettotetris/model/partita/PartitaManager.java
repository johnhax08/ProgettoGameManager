package it.unipv.po.progettotetris.model.partita;

import it.unipv.po.progettotetris.model.giocatore.Giocatore;

import java.util.List;

public interface PartitaManager {
    public void addPartita(Partita p) ;
    public void removePartita(Partita p);
    public List<Partita> filtro(long timestamp, String g1, String g2,String vincitore);

    static PartitaManager getPartitaManager(){
        return new BasicPartitaManager();
    }
}
