package it.unipv.po.progettotetris.gui;

import it.unipv.po.progettotetris.model.facade.Controller;
import it.unipv.po.progettotetris.model.giocatore.Giocatore;
import it.unipv.po.progettotetris.model.partita.PartitaParitaria;
import it.unipv.po.progettotetris.model.partita.TipoPartita;

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
                boolean vinceg1 = new Random().nextBoolean();
                Giocatore g1 = controller.getGiocatoreAttuale();
                Giocatore g2 = controller.getGiocatoreByID(nome.getText());
                Giocatore v = vinceg1?g1 : g2; // : = sennò

                PartitaParitaria partitaParitaria = new PartitaParitaria(0,g1,g2,v);
                controller.addPartita(partitaParitaria);
            }
        });
    }
}
