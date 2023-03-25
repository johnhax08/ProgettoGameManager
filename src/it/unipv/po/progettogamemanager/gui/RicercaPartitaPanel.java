package it.unipv.po.progettogamemanager.gui;

import it.unipv.po.progettogamemanager.model.facade.Controller;
import it.unipv.po.progettogamemanager.model.partita.Partita;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.List;

public class RicercaPartitaPanel extends JPanel {
    JList lista;
    Controller controller;
    DefaultListModel listModel;
    JTextArea giocatore;
    JTextArea vincitore;


    protected void filtraPartita(){
        var g = giocatore.getText();
        var v =  vincitore.getText();
        var list = controller.filtro(null, g.isBlank()?null : g,v.isBlank()?null : v);

        listModel.removeAllElements();
        for (int x = 0;x < list.size(); x++){
            listModel.add(x,list.get(x).getID());
        }
    }

    public RicercaPartitaPanel(Controller controller){
        this.controller = controller;
        this.lista = new JList();
        this.listModel = new DefaultListModel();
        lista.setModel(listModel);
        this.giocatore = new JTextArea("INSERISCI NOME GIOCATORE");
        this.vincitore = new JTextArea("INSERISCI NOME VINCITORE");

        setLayout(new GridLayout(4,1));
        add(new JScrollPane(lista)); //aggiungo la scroll bar alla lista
        add(giocatore);
        add(vincitore);

        giocatore.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                filtraPartita();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        vincitore.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtraPartita();
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

