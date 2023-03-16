import it.unipv.po.progettotetris.model.facade.Controller;
import it.unipv.po.progettotetris.model.giocatore.GiocatoreBegginner;
import it.unipv.po.progettotetris.model.giocatore.GiocatoreProfessional;
import it.unipv.po.progettotetris.model.partita.BasicPartitaManager;
import it.unipv.po.progettotetris.model.partita.PartitaManager;
import it.unipv.po.progettotetris.model.partita.PartitaParitaria;

public class Main {
    public static void main(String[] args) {
        Controller c = Controller.getController();
        //c.addGiocatore(new GiocatoreBegginner("ao123","Johnny","ehdb",4));
        //c.addGiocatore(new GiocatoreBegginner("ao423","Aiman","ehdi",5));
        //c.addGiocatore(new GiocatoreProfessional("ab345","Giuseppe","npc",10));

       // c.addPartita(new PartitaParitaria(19, c.getGiocatoreByID("ao123"), c.getGiocatoreByID("ao423"), c.getGiocatoreByID("ao423") ));
       // c.addPartita(new PartitaParitaria(19, c.getGiocatoreByID("ao423"), c.getGiocatoreByID("a0123"), c.getGiocatoreByID("ao123") ));
       //c.addPartita(new PartitaParitaria(19, c.getGiocatoreByID("ab345"), c.getGiocatoreByID("ao423"), c.getGiocatoreByID("ab345") ));



        System.out.println(c.filtro((long)19,null,null,null));
        //System.out.println(c.getGiocatoreByID("ab345"));




    }
}