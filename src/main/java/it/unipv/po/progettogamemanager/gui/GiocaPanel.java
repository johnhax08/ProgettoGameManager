package it.unipv.po.progettogamemanager.gui;

import it.unipv.po.progettogamemanager.model.facade.Controller;
import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;
import it.unipv.po.progettogamemanager.model.partita.Partita;
import it.unipv.po.progettogamemanager.model.partita.PartitaParitaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GiocaPanel extends JPanel {
    JTextArea nome;
    JButton sfida;
    Controller controller;

    public GiocaPanel(Controller controller){
        this.nome = new JTextArea();
        this.sfida = new JButton("SFIDA!");
        this.controller = controller;

        setLayout(new GridLayout(2,1));
        add(nome);
        add(sfida);

        this.sfida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Giocatore g1 = controller.getGiocatoreAttuale();
                Giocatore g2 = controller.getGiocatoreByNome(nome.getText());
                Giocatore v = g1.vince(g2)?g1 : g2;  // : = sennò , ? operatore ternario ed è praticamente un if else su un'unica riga
                //g1.vince(g2) mi dovrebbe tornare true o false , il ? sta per : se questa cosa è vera vince g1 se non è vera vince g2
                Giocatore p = v==g1? g2 : g1; //se v=g1, il perdente è g2 altrimenti è g1

                controller.addPartita(Partita.getPartita(System.currentTimeMillis(),v,p));
            }
        });
    }
}


