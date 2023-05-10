package it.unipv.po.progettogamemanager.model.giocatore;

public interface GiocatoreManager {
    public void addGiocatore(Giocatore g);
    public void removeGiocatore(Giocatore g);
    public boolean authenticate(String nome, int password);

    public Giocatore getGiocatoreByNome(String nome);

    static GiocatoreManager getGiocatoreManager(){
        return new BasicGiocatoreManager();
    }

    void setGiocatoreAttuale(String nome);

    Giocatore getGiocatoreAttuale();

}
