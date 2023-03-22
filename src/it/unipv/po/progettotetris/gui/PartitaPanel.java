package it.unipv.po.progettotetris.gui;

import it.unipv.po.progettotetris.model.facade.Controller;
import it.unipv.po.progettotetris.model.partita.Partita;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PartitaPanel extends JPanel {
    JList lista;
    Controller controller;
    DefaultListModel listModel;
    JTextArea timestamp;
    JTextArea giocatore;
    JTextArea vincitore;


    public PartitaPanel(Controller controller){
        this.controller = controller;
        this.lista = new JList();
        this.listModel = new DefaultListModel();
        lista.setModel(listModel);
        this.timestamp = new JTextArea("ora");
        this.giocatore = new JTextArea("johnny");
        this.vincitore = new JTextArea("giuseppe");

        setLayout(new GridLayout(4,1));
        add(new JScrollPane(lista));
        add(timestamp);
        add(giocatore);
        add(vincitore);

        giocatore.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("ok");
                var list = controller.filtro(null,giocatore.getText(),null);
                listModel.removeAllElements();
                for (int x = 0;x < list.size(); x++){
                    listModel.add(x,list.get(x).getID());

                }

            }



            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });



    }
}

