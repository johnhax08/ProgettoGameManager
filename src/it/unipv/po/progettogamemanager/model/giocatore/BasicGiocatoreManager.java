package it.unipv.po.progettogamemanager.model.giocatore;

import it.unipv.po.progettogamemanager.model.persistenza.Serializzabile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasicGiocatoreManager implements GiocatoreManager {
    final String GIOCATORIPATH = "data_progettotetris/giocatori/"  ;
    protected List<Giocatore> giocatori;
    protected String giocatoreAttuale;

    public BasicGiocatoreManager() {
        this.giocatori = new ArrayList<>();
        for(File f : new File(GIOCATORIPATH).listFiles() ) {
            try {
                Giocatore g = (Giocatore) Serializzabile.read(f.getPath());
                addGiocatore(g);
            } catch (IOException | ClassNotFoundException | ClassCastException e) { //io exception = problema di lettura/scrittura,
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addGiocatore(Giocatore g) {
        giocatori.add(g); //il giocatore lo aggiungo alla lista
        try {
            String path = GIOCATORIPATH + g.getNome();
            g.write(path); //sto dicendo al giocatore di salvarsi su questo path
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void removeGiocatore(Giocatore g) { //in questo momento sto rimuovendo dal RAM il giocatore cioè dalla lista
        giocatori.remove(g);
    }

    @Override
    public boolean authenticate(String nome, String password) {
        Giocatore g = getGiocatoreByNome(nome);
        return g!=null && g.getPassword().equals(password); //prima di tutto controllo se il giocatore è null, se non è null controllo la password
    }

    @Override
    public Giocatore getGiocatoreByNome(String nome) {
        for( Giocatore g : giocatori){
            if(g.getNome().equals(nome)) return g;
        }
        return null;
    }

    public void setGiocatoreAttuale(String nome) { //setto il gioc.attuale
        this.giocatoreAttuale = nome;
    }

    @Override
    public Giocatore getGiocatoreAttuale() {
        return getGiocatoreByNome(giocatoreAttuale);

    }
}
