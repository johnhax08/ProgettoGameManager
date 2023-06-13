package it.unipv.po.progettogamemanager.view;

import it.unipv.po.progettogamemanager.controller.Controller;
import it.unipv.po.progettogamemanager.controller.Pagine;

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
              controller.switchTo(Pagine.SIGN_UP);
            }
        });

        this.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.switchTo(Pagine.LOG_IN);
            }
        });

        this.ricercapartite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.switchTo(Pagine.RICERCA_PARTITE);
            }
        });
    }



}
