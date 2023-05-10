package it.unipv.po.progettogamemanager.model.partita;

import java.util.List;

public interface PartitaManager {
    public void addPartita(Partita p) ;
    public void removePartita(Partita p);
    public List<Partita> filtro(Long timestamp, String g,String vincitore);

    static PartitaManager getPartitaManager(){
        return new BasicPartitaManager();
    }
}
