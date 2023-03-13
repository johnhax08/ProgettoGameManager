import it.unipv.po.progettotetris.model.facade.Controller;
import it.unipv.po.progettotetris.model.giocatore.GiocatoreBegginner;
import it.unipv.po.progettotetris.model.partita.BasicPartitaManager;
import it.unipv.po.progettotetris.model.partita.PartitaManager;

public class Main {
    public static void main(String[] args) {
        Controller c = Controller.getController();
        c.addGiocatore(new GiocatoreBegginner("ao123","johnny","pass123",0));
        System.out.println(c.authenticate("ao123","pass123"));

    }
}