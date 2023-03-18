package it.unipv.po.progettotetris.gui;

import it.unipv.po.progettotetris.model.facade.Controller;
import it.unipv.po.progettotetris.model.facade.TitoloFinestra;
import it.unipv.po.progettotetris.model.giocatore.Giocatore;
import it.unipv.po.progettotetris.model.giocatore.GiocatoreBegginner;
import it.unipv.po.progettotetris.model.giocatore.TipiGiocatore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpPanel extends JPanel {
    JTextArea nome;
    JPasswordField password;
    JPasswordField passwordconf;
    JButton signmeup;

    Controller controller;

    public SignUpPanel(Controller controller) {
        this.nome = new JTextArea();
        this.password = new JPasswordField();
        this.passwordconf = new JPasswordField();
        this.signmeup = new JButton("Sign Me Up");
        this.controller = controller;

        setLayout(new GridLayout(4,1));
        add(nome);
        add(password);
        add(passwordconf);
        add(signmeup);

        this.signmeup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addGiocatore( Giocatore.getGiocatore(getNome(),getPassword(), TipiGiocatore.BEGGINNER));
                controller.switchTo(TitoloFinestra.LOG_IN);
            }
        });

    }
    public String getNome(){
        return this.nome.getText();
    }

    public String getPassword(){
        if( !password.getText().equals(passwordconf.getText())){
            JOptionPane.showMessageDialog(this,"LE PASSWORD NON CORRISPONDONO!");
            throw new RuntimeException("LE PASSWORD NON CORRISPONDONO!");
        }
        return password.getText();
    }


}
