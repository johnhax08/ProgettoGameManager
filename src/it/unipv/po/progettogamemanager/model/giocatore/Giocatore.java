package it.unipv.po.progettogamemanager.model.giocatore;

import it.unipv.po.progettogamemanager.model.persistenza.Serializzabile;

public interface Giocatore extends Serializzabile {
    String getNome();
    String getPassword();
    TipiGiocatore getTipo();

    public static Giocatore getGiocatore(String nome, String password, TipiGiocatore tipo){
        switch (tipo){
            case BEGGINNER:
                return new GiocatoreBegginner(nome, password);
            case PROFESSIONAL:
                return new GiocatoreProfessional( nome, password);
            default:
                throw new RuntimeException("TIPO GIOCATORE INVALIDO!");

        }

    }
    /**
     * g1.vince(g2) se è true vuol dire che ha vinto g1
     *
     * */
    public boolean vince(Giocatore g);




}
