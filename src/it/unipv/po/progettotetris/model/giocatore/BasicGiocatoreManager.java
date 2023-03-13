package it.unipv.po.progettotetris.model.giocatore;

import java.util.ArrayList;
import java.util.List;

public class BasicGiocatoreManager implements GiocatoreManager {
    protected List<Giocatore> giocatori;

    public BasicGiocatoreManager() {
        this.giocatori = new ArrayList<>();
    }

    @Override
    public void addGiocatore(Giocatore g) {
        giocatori.add(g);
    }

    @Override
    public void removeGiocatore(Giocatore g) {
        giocatori.remove(g);
    }

    @Override
    public boolean authenticate(String ID, String password) {
        Giocatore g = null;
        for (Giocatore g1 : giocatori) //per ciascun g1 in giocatori
        {
            if (g1.getID().equals(ID)) { //uso equals perchè sto confrontado due stringhe, quando confronto il valore logico di due oggeti uso l'equals mentre quando confronto due tipi primitivi posso usare ==, che è anche l'unica opzione
                g = g1;
                break;
            }
        }
        if (g == null) {
            return false;
        }
        return g.getPassword().equals(password);
    }

    @Override
    public Giocatore getGiocatoreByID(String ID) {
        for( Giocatore g : giocatori){
            if(g.getID().equals(ID)) return g;
        }
        return null;
    }
}
