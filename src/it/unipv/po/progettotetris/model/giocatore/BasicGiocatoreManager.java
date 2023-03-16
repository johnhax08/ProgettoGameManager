package it.unipv.po.progettotetris.model.giocatore;

import it.unipv.po.progettotetris.model.persistenza.Serializzabile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasicGiocatoreManager implements GiocatoreManager {
    final String GIOCATORIPATH = "data_progettotetris/giocatori/"  ;
    protected List<Giocatore> giocatori;

    public BasicGiocatoreManager() {
        this.giocatori = new ArrayList<>();
        for(File f : new File(GIOCATORIPATH).listFiles() ) {
            try {
                Giocatore g = (Giocatore) Serializzabile.read(f.getPath());
                addGiocatore(g);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addGiocatore(Giocatore g) {
        giocatori.add(g);
        try {
            String path = GIOCATORIPATH + g.getID() ;
           // System.out.println(path);
            g.write(path);
        } catch (IOException e) {
            e.printStackTrace();

        }

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
