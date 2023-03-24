package it.unipv.po.progettogamemanager.model.partita;

import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;

public abstract class PartitaABS implements Partita {
    final protected long timeStamp;
    final protected Giocatore giocatore1;
    final protected Giocatore giocatore2;
    final protected Giocatore vincitore;
    final protected TipoPartita tipo;

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
    public String getID() {
        return timeStamp + giocatore1.getNome() + giocatore2.getNome() + vincitore.getNome();
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
