package it.unipv.po.progettogamemanager.view;

import it.unipv.po.progettogamemanager.model.gamemanager.GameManager;
import it.unipv.po.progettogamemanager.model.gamemanager.Pagine;
import it.unipv.po.progettogamemanager.model.utils.Hash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInPanel extends JPanel {
    JTextArea username;
    JPasswordField password;
    GameManager gameManager;
    JButton login;

    public LogInPanel(GameManager gameManager){
        this.username = new JTextArea();
        this.password = new JPasswordField();
        this.gameManager = gameManager;
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
                if(gameManager.authenticate(username.getText(), Hash.hash(password.getText()))){
                    JOptionPane.showMessageDialog(null,"Log In è stato effettuato con successo!");
                    gameManager.setGiocatoreAttuale(username.getText());
                    gameManager.switchTo(Pagine.GIOCA_ORA);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Log In non riuscito!");
                }

            }
        });



    }


}
