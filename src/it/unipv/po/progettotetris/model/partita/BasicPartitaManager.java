package it.unipv.po.progettotetris.model.partita;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicPartitaManager implements  PartitaManager{
    protected List<Partita> partite;

    public BasicPartitaManager() {
        this.partite = new ArrayList<>();
    }

    @Override
    public void addPartita(Partita p) {
        partite.add(p);
    }

    @Override
    public void removePartita(Partita p) {
        partite.remove(p);
    }

    @Override
    public List<Partita> filtro(long timestamp, String g1, String g2, String vincitore) {
        return  partite.stream().filter(p ->
                timestamp<0 || p.getTimeStamp() == timestamp //visto che timestamp è un long cioè un primitivo non posso usare null ma faccio timestamp < 0
                && g1 == null || p.getGiocatore1().getID().equals(g1)
                && g2 == null || p.getGiocatore2().getID().equals(g2)
                && vincitore == null || p.getVincitore().getID().equals(vincitore)).collect(Collectors.toList()); //collect per mettere tutti gli elementi in una lista
        //prendo la lista di partite, ci applico un filtro, questo filtro mi ritorna una nuova lista che non ha nulla a che fare con quella vecchia però è una lista nuova che contiene gli elementi desiderati
    }
}
