package it.unipv.po.progettogamemanager.model.giocatore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicGiocatoreManagerTest { //tester del metodo authenticate

    @Test
    void authenticate() {
        GiocatoreManager gm  = GiocatoreManager.getGiocatoreManager();
        gm.addGiocatore(Giocatore.getGiocatore("giorgia", 12345, TipiGiocatore.BEGINNER));
        assertTrue(gm.authenticate("giorgia", 12345));
        assertFalse(gm.authenticate("federica", 3421));
        assertFalse(gm.authenticate("johnny", 54321));
    }
}