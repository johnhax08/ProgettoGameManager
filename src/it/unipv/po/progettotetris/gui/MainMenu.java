package it.unipv.po.progettotetris.gui;

import it.unipv.po.progettotetris.model.facade.Controller;
import it.unipv.po.progettotetris.model.facade.TitoloFinestra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {
    JButton signup;
    JButton login;
    JButton ricercapartite;
    JLabel benvenuto;

    public MainMenu(Controller controller){
        this.signup = new JButton("SIGN UP");
        this.login = new JButton("LOG IN");
        this.ricercapartite = new JButton("RICERCA PARTITE");
        this.benvenuto = new JLabel("BENVENUTO/A!",SwingConstants.CENTER);


        setLayout(new GridLayout(4,1));
        add(benvenuto);
        add(signup);
        add(login);
        add(ricercapartite);

        this.signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              controller.switchTo(TitoloFinestra.SIGN_UP);
            }
        });
        this.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.switchTo(TitoloFinestra.LOG_IN);
            }
        });
        this.ricercapartite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.switchTo(TitoloFinestra.RICERCA_PARTITE);
            }
        });
    }



}
