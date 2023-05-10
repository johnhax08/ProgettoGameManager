package it.unipv.po.progettogamemanager.gui;

import it.unipv.po.progettogamemanager.model.facade.Controller;
import it.unipv.po.progettogamemanager.model.facade.Pagine;
import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;
import it.unipv.po.progettogamemanager.model.giocatore.TipiGiocatore;
import it.unipv.po.progettogamemanager.model.utils.Hash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPanel extends JPanel {
    JTextArea nome;
    JPasswordField password;
    JPasswordField passwordconf;
    JButton signmeup;
    JComboBox <TipiGiocatore> menutendina; //menu a tendina per i tipi di giocatore

    Controller controller;

    public SignUpPanel(Controller controller) {
        this.nome = new JTextArea();
        this.password = new JPasswordField();
        this.passwordconf = new JPasswordField();
        this.signmeup = new JButton("Sign Me Up");
        this.menutendina =  new JComboBox<>(TipiGiocatore.values());
        this.controller = controller;

        setLayout(new GridLayout(5,1));
        add(nome);
        add(password);
        add(passwordconf);
        add(menutendina);
        add(signmeup);

        this.signmeup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addGiocatore( Giocatore.getGiocatore(getNome(),getPassword(),TipiGiocatore.values()[menutendina.getSelectedIndex()])); //menutendina.get... è un numero da 0 ad n che mi dice l'indice selezionato nel menu a tendina poi lo uso come indice dell'array tipigiocatore.values
                controller.switchTo(Pagine.LOG_IN);
            }
        });

    }
    public String getNome(){
        if(controller.getGiocatoreByNome(this.nome.getText()) != null ){
            JOptionPane.showMessageDialog(this,"IL NOME E' STATO GIA' UTILIZZATO !");
            throw new RuntimeException("IL NOME E' STATO GIA' UTILIZZATO !");
        }
        return this.nome.getText();
    }

    public int getPassword(){
        if( !password.getText().equals(passwordconf.getText())){
            JOptionPane.showMessageDialog(this,"LE PASSWORD NON CORRISPONDONO!");
            throw new RuntimeException("LE PASSWORD NON CORRISPONDONO!");
        }
        return Hash.hash(password.getText());
    }


}
