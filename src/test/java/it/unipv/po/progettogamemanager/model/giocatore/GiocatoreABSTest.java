package it.unipv.po.progettogamemanager.model.giocatore;

import static org.junit.jupiter.api.Assertions.*;

class GiocatoreABSTest { //tester di equals tra i giocatori

    @org.junit.jupiter.api.Test
    void testEquals() {
        GiocatoreBegginner g1 = new GiocatoreBegginner("Johnny",1234567);
        GiocatoreBegginner g2 = new GiocatoreBegginner("Johnny",1234567);
        GiocatoreBegginner g3 = new GiocatoreBegginner("Aiman",1234);
        assertTrue(g1.equals(g2)); //se sono uguali mi aspetto che l'equals mi dia true
        assertFalse(g1.equals(g3)); //se sono diversi mi aspetto che l'equals mi dia false

    }
}

