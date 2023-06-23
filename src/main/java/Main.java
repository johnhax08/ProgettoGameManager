import it.unipv.po.progettogamemanager.view.FramePrincipale;

import it.unipv.po.progettogamemanager.model.gamemanager.GameManager;
import it.unipv.po.progettogamemanager.model.gamemanager.Pagine;


public class Main {
    public static void main(String[] args) {
        GameManager c = GameManager.getGameManager(); //creo il modello

        new FramePrincipale(c); //creo la gui

        c.switchTo(Pagine.MENU_PRINCIPALE); //  l'app quando viene lanciata deve venire lanciata sul menu principale





    }
}