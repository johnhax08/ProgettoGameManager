package it.unipv.po.progettotetris.model.giocatore;

public class GiocatoreProfessional extends GiocatoreABS {
    public GiocatoreProfessional(String nome, String password, int punteggioTotale) {
        super(nome, password, punteggioTotale, TipiGiocatore.PROFESSIONAL);
    }
}
