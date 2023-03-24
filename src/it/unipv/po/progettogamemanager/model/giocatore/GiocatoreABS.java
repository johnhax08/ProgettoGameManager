package it.unipv.po.progettogamemanager.model.giocatore;
//in questa classe metto tutta la roba in comune cioè in giocatoreABS.
public abstract class GiocatoreABS implements  Giocatore{
    String nome;
    String password;
    TipiGiocatore tipo;

    public GiocatoreABS(String nome, String password,TipiGiocatore tipo) {
        this.nome = nome;
        this.password = password;
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Giocatore other = (Giocatore) obj;
            return this.getNome().equals(other.getNome()); // due gioc sono considerati uguali se hanno lo stesso nome
        }
        catch (ClassCastException e)
        {
            return false;
        }
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
    public TipiGiocatore getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nome;
    }
}
