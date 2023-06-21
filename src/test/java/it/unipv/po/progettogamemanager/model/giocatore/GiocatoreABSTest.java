package it.unipv.po.progettogamemanager.model.giocatore;

import it.unipv.po.progettogamemanager.controller.BasicController;

import static org.junit.jupiter.api.Assertions.*;

class GiocatoreABSTest {

    @org.junit.jupiter.api.Test
    void testEquals() {
        GiocatoreBegginner g1 = new GiocatoreBegginner("Johnny",1234567);
        GiocatoreBegginner g2 = new GiocatoreBegginner("Johnny",1234567);
        GiocatoreBegginner g3 = new GiocatoreBegginner("Aiman",1234);
        assertTrue(g1.equals(g2));
        assertFalse(g1.equals(g3));

    }
}