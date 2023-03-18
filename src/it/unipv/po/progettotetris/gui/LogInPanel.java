package it.unipv.po.progettotetris.gui;

import it.unipv.po.progettotetris.model.facade.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPanel extends JPanel {
    JTextArea username;
    JPasswordField password;
    Controller controller;
    JButton login;

    public LogInPanel(Controller controller){
        this.username = new JTextArea();
        this.password = new JPasswordField();
        this.controller = controller;
        this.login = new JButton("Log In");

        setLayout(new GridLayout(3,1));
        add(username);
        add(password);
        add(login);

        this.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.authenticate(username.getText(), password.getText())){
                    JOptionPane.showMessageDialog(null,"Log In è stato effettuato con successo!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Log In non riuscito!");
                }

            }
        });


    }


}