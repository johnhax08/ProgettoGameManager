package it.unipv.po.progettogamemanager.model.giocatore;

import it.unipv.po.progettogamemanager.model.utils.Files;

import java.io.IOException;

//in questa classe metto tutta la roba in comune cioè in giocatoreABS.
public abstract class GiocatoreABS implements Giocatore {
    String nome;
    int password;
    TipiGiocatore tipo;

    public GiocatoreABS(String nome, int password, TipiGiocatore tipo) {
        this.nome = nome;
        this.password = password;
        this.tipo = tipo;
    }

    @Override
    public void write(String filename) throws IOException {
        Files.write(filename,this.toJson());

    }

    @Override
    public boolean equals(Object obj) {
        try {
            Giocatore other = (Giocatore) obj;
            return this.getNome().equals(other.getNome()); // due gioc sono considerati uguali se hanno lo stesso nome
        } catch (ClassCastException e) {
            return false;
        }
    }

    public String toJson() {
        return
                "{ \n" +
                        "\"nome\" : \"" +  this.nome + "\", \n" +
                        "\"password\" : \""  +  this.password + "\", \n" +
                        "\"tipo\" : \"" + this.tipo + "\" \n" +
                        "}";
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getPassword() {
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
