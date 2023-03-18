package it.unipv.po.progettotetris.model.giocatore;
//in questa classe metto tutta la roba in comune cioè in giocatoreABS.
public abstract class GiocatoreABS implements  Giocatore{
    String nome;
    String password;
    int punteggioTotale;
    TipiGiocatore tipo;

    public GiocatoreABS(String nome, String password, int punteggioTotale,TipiGiocatore tipo) {
        this.nome = nome;
        this.password = password;
        this.punteggioTotale = punteggioTotale;
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object obj) {
        Giocatore g = (Giocatore) obj;
        try {
            Giocatore other = (Giocatore) obj;
            return this.getNome().equals(other.getNome());
        }
        catch (ClassCastException e)
        {
            return false;
        }
    }

    @Override
    public void aumentaPunti(int delta) {
        punteggioTotale += delta;
    }


    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int getPunteggioTotale() {
        return punteggioTotale;
    }

    @Override
    public TipiGiocatore getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
