package it.unipv.po.progettotetris.model.giocatore;

public class GiocatoreProfessional extends GiocatoreABS {
    public GiocatoreProfessional(String ID, String nome, String password, int punteggioTotale) {
        super(ID, nome, password, punteggioTotale, TipiGiocatore.PROFESSIONAL);
    }
}
