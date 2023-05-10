package it.unipv.po.progettogamemanager.model.giocatore;

import java.util.Random;

public class GiocatoreProfessional extends GiocatoreABS {
    public GiocatoreProfessional(String nome, int password) {
        super(nome, password, TipiGiocatore.PROFESSIONAL);
    }

    @Override
    public boolean vince(Giocatore g) {

        return new Random().nextFloat() <= 0.7;
    }
}
