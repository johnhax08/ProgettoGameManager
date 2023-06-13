package it.unipv.po.progettogamemanager.view;

import it.unipv.po.progettogamemanager.controller.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class RicercaPartitaPanel extends JPanel {
    JList lista;
    Controller controller;
    DefaultListModel listModel;
    JTextArea giocatore;
    JTextArea vincitore;


    public RicercaPartitaPanel(Controller controller){
        this.controller = controller;
        this.lista = new JList();
        this.listModel = new DefaultListModel();
        lista.setModel(listModel);
        this.giocatore = new JTextArea();
        this.vincitore = new JTextArea();

        setLayout(new GridLayout(6,1));
        add(new JScrollPane(lista)); //aggiungo la scroll bar alla lista
        add(new JLabel("Inserisci nome giocatore:"));
        add(giocatore);
        add(new JLabel("Inserisci nome vincitore:"));
        add(vincitore);

        giocatore.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                filtraPartita();

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtraPartita();
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
                filtraPartita();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        filtraPartita();


    }
    protected void filtraPartita(){
        var g = giocatore.getText();
        var v =  vincitore.getText();
        var list = controller.filtro(null, g.isBlank()?null : g,v.isBlank()?null : v);

        listModel.removeAllElements();
        for (int x = 0;x < list.size(); x++){
            listModel.add(x,list.get(x).prettyPrint());
        }
    }
}

