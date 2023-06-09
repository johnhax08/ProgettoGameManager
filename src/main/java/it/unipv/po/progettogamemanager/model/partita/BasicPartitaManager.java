package it.unipv.po.progettogamemanager.model.partita;

import it.unipv.po.progettogamemanager.model.persistenza.Serializzabile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasicPartitaManager implements  PartitaManager{
    protected List<Partita> partite;
    final String PARTITAPATH = "data_progettotetris/partite/" ;

    public BasicPartitaManager() {
        this.partite = new ArrayList<>();

        for(File f : new File(PARTITAPATH).listFiles()){
         try {
                Partita p = Partita.readJson(f.getPath());
                addPartita(p);
            } catch (RuntimeException e) {
               e.printStackTrace();
            }

        }

    }

    @Override
    public void addPartita(Partita p) { //quando aggiungo una partita viene salvata automaticamente sul disco
        partite.add(p);
        String path = PARTITAPATH + p.getID();
        try {
            p.write(path);
        } catch (IOException e){
            e.printStackTrace(); //ho preferito di non lanciare l'eccezione e quindi ho usato print stack trace che stampa lo stack trace dell'eccezione cioè tutto quello che è andato storto.
        }


    }

    @Override
    public void removePartita(Partita p) {
        partite.remove(p);
    }



    @Override
    public List<Partita> filtro(Long timestamp, String g,String vincitore) { //dovrebbe farmi tornare una lista di partite idonea a questi attributi , se l'attributo è nullo salto il controllo e mi viene fuori la lista di tutte le partite che sono state giocate se tutti gli attributi sono null , nel caso in cui c'è solo un null cioè solo un attributo null mi viene fuori una lista con tutte le partite tutti i timestamp
        return  partite.stream().filter(p ->
                (timestamp == null || p.getTimeStamp() == timestamp) //visto che timestamp è un long cioè un primitivo non posso usare null ma faccio timestamp < 0
                && (g == null || p.getGiocatore1().equals(g) || p.getGiocatore2().equals(g))
                && (vincitore == null || p.getVincitore().equals(vincitore)) )
                .collect(Collectors.toList()); //collect per mettere tutti gli elementi in una lista
        //prendo la lista di partite, ci applico un filtro, questo filtro mi ritorna una nuova lista che non ha nulla a che fare con quella vecchia però è una lista nuova che contiene gli elementi desiderati
    }
}
