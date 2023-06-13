package it.unipv.po.progettogamemanager.model.partita;

import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;
import it.unipv.po.progettogamemanager.model.utils.Files;

import java.io.IOException;

public abstract class PartitaABS implements Partita {
    final protected long timeStamp;
    final protected String giocatore1;
    final protected String giocatore2;
    final protected String vincitore;
    final protected TipoPartita tipo;

    public PartitaABS(long timeStamp, String giocatore1, String giocatore2, String vincitore, TipoPartita tipo) {
        this.timeStamp = timeStamp;
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
        this.vincitore = vincitore;
        this.tipo = tipo;
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String getGiocatore1() {
        return giocatore1;
    }

    @Override
    public String getGiocatore2() {
        return giocatore2;
    }

    @Override
    public String getVincitore() {
        return vincitore;
    }

    @Override
    public TipoPartita getTipo() {
        return tipo;
    }

    @Override
    public String getID() {
        return timeStamp + giocatore1 + giocatore2 + vincitore ;
    }


    public String toJson() {
        return
                "{ \n"  +
                         "\"timestamp\" : " + this.timeStamp + ",\n" +
                         "\"giocatore1\" : \"" +  this.giocatore1 + "\", \n" +
                         "\"giocatore2\" : \"" +  this.giocatore2 + "\", \n" +
                         "\"vincitore\" : \"" +  this.vincitore + "\", \n" +
                         "\"tipo\" : \"" +  this.tipo + "\", \n" +


                "}" ;
    }

    @Override
    public void write(String filename) throws IOException {
        Files.write(filename,toJson());
    }

    @Override
    public String toString() { //una rapp.testuale
        return "PartitaABS{" +
                "timeStamp=" + timeStamp +
                ", giocatore1=" + giocatore1 +
                ", giocatore2=" + giocatore2 +
                ", vincitore=" + vincitore +
                ", tipo=" + tipo +
                '}';
    }
}
