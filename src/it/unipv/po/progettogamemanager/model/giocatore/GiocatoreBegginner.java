package it.unipv.po.progettogamemanager.model.giocatore;

import java.util.Random;

public class GiocatoreBegginner extends GiocatoreABS{
    public GiocatoreBegginner(String nome, String password) {
        super(nome, password,TipiGiocatore.BEGGINNER);
    }

    @Override
    public boolean vince(Giocatore g) {

        return new Random().nextFloat() <= 0.5  ; //next float mi ritorna un numero fra 0 e 1 con distribuzione uniforme, il beginner vince con meno frequenza rispetto al professional
    }
}
