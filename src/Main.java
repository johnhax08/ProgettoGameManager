import it.unipv.po.progettogamemanager.gui.FramePrincipale;

import it.unipv.po.progettogamemanager.model.facade.Controller;
import it.unipv.po.progettogamemanager.model.facade.Pagine;


public class Main {
    public static void main(String[] args) {
        Controller c = Controller.getController();


        new FramePrincipale(c);

        c.switchTo(Pagine.MENU_PRINCIPALE);



    }
}