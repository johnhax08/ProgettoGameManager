package it.unipv.po.progettogamemanager.model.partita;

import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;
import it.unipv.po.progettogamemanager.model.persistenza.Serializzabile;
import it.unipv.po.progettogamemanager.model.utils.Files;
import org.json.JSONObject;

import java.io.IOException;

public interface Partita extends Serializzabile{
    long getTimeStamp();
    String getGiocatore1();
    String getGiocatore2();
    String getVincitore();
    String getID();
    TipoPartita getTipo();

    static Partita getPartita(long timestamp,Giocatore vincitore,Giocatore perdente){
        if (vincitore.getTipo() != perdente.getTipo()){
            return new PartitaSbilanciata(timestamp, vincitore.getNome(), perdente.getNome(), vincitore.getNome());
        }
        else{
            return new PartitaParitaria(timestamp, vincitore.getNome(), perdente.getNome(), vincitore.getNome());
        }
    }

    static Partita readJson(String path){
         String json = null;
        try {
            json = Files.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jo = new JSONObject(json);
        long timestamp = jo.getLong("timestamp" );
        String giocatore1 = jo.getString("giocatore1");
        String giocatore2 = jo.getString("giocatore2");
        String vincitore = jo.getString("vincitore");
        String tipo = jo.getString("tipo");
        switch(tipo){
            case "PARITARIA" :
                return new PartitaParitaria(timestamp,giocatore1,giocatore2,vincitore);

            case "SBILANCIATA" :
                return new PartitaSbilanciata(timestamp, giocatore1, giocatore2, vincitore);
        }
            return null;
    }

}
