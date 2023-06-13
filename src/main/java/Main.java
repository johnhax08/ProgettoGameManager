import it.unipv.po.progettogamemanager.view.FramePrincipale;

import it.unipv.po.progettogamemanager.controller.Controller;
import it.unipv.po.progettogamemanager.controller.Pagine;


public class Main {
    public static void main(String[] args) {
        Controller c = Controller.getController(); //creo il modello

        new FramePrincipale(c); //creo la gui

        c.switchTo(Pagine.MENU_PRINCIPALE); //  l'app quando viene lanciata deve venire lanciata sul menu principale





    }
}