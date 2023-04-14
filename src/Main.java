import it.unipv.po.progettogamemanager.gui.FramePrincipale;

import it.unipv.po.progettogamemanager.model.facade.Controller;
import it.unipv.po.progettogamemanager.model.facade.Pagine;
import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;
import it.unipv.po.progettogamemanager.model.partita.Partita;


public class Main {
    public static void main(String[] args) {
        Controller c = Controller.getController(); //creo il modello

        //Giocatore giocatore = Giocatore.getGiocatore();
        //c.addGiocatore(giocatore);

        //Partita partita =  Partita.getPartita();
        //c.addPartita(partita);

        new FramePrincipale(c); //creo la gui

        c.switchTo(Pagine.MENU_PRINCIPALE); //  l'app quando viene lanciata deve venire lanciata sul menu principale





    }
}