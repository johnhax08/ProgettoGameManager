package it.unipv.po.progettogamemanager.view;

import it.unipv.po.progettogamemanager.controller.Controller;
import it.unipv.po.progettogamemanager.controller.Pagine;
import it.unipv.po.progettogamemanager.model.utils.Hash;

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


        setLayout(new GridLayout(5,1));
        add(new JLabel("username : "));
        add(username);
        add(new JLabel("password : "));
        add(password);
        add(login);



        this.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.authenticate(username.getText(), Hash.hash(password.getText()))){
                    JOptionPane.showMessageDialog(null,"Log In è stato effettuato con successo!");
                    controller.setGiocatoreAttuale(username.getText());
                    controller.switchTo(Pagine.GIOCA_ORA);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Log In non riuscito!");
                }

            }
        });



    }


}
