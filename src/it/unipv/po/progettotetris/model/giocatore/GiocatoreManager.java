package it.unipv.po.progettotetris.model.giocatore;

public interface GiocatoreManager {
    public void addGiocatore(Giocatore g);
    public void removeGiocatore(Giocatore g);
    public boolean authenticate(String nome, String password);

    public Giocatore getGiocatoreByID(String nome);
    //factory method che praticamente quando vorrò cambiare l'implementazione di giocatoremanager ritornera una classe diversa da questo metodo
    static GiocatoreManager getGiocatoreManager(){
        return new BasicGiocatoreManager();
    }

}
