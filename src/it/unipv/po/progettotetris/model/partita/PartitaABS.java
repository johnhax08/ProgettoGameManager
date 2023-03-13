package it.unipv.po.progettotetris.model.partita;

import it.unipv.po.progettotetris.model.giocatore.Giocatore;

public abstract class PartitaABS implements Partita {
    long timeStamp;
    Giocatore giocatore1;
    Giocatore giocatore2;
    Giocatore vincitore;
    TipoPartita tipo;

    public PartitaABS(long timeStamp, Giocatore giocatore1, Giocatore giocatore2, Giocatore vincitore, TipoPartita tipo) {
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
    public Giocatore getGiocatore1() {
        return giocatore1;
    }

    @Override
    public Giocatore getGiocatore2() {
        return giocatore2;
    }

    @Override
    public Giocatore getVincitore() {
        return vincitore;
    }

    @Override
    public TipoPartita getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "PartitaABS{" +
                "timeStamp=" + timeStamp +
                ", giocatore1=" + giocatore1 +
                ", giocatore2=" + giocatore2 +
                ", vincitore=" + vincitore +
                ", tipo=" + tipo +
                '}';
    }
}
