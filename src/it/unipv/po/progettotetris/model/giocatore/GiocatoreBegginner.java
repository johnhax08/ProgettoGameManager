package it.unipv.po.progettotetris.model.giocatore;

public class GiocatoreBegginner extends GiocatoreABS{
    public GiocatoreBegginner(String nome, String password, int punteggioTotale) {
        super(nome, password, punteggioTotale, TipiGiocatore.BEGGINNER);
    }
}
