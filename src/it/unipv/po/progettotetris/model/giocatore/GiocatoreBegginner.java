package it.unipv.po.progettotetris.model.giocatore;

public class GiocatoreBegginner extends GiocatoreABS{
    public GiocatoreBegginner(String ID, String nome, String password, int punteggioTotale) {
        super(ID, nome, password, punteggioTotale, TipiGiocatore.BEGGINNER);
    }
}
