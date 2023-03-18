package it.unipv.po.progettotetris.gui;

import it.unipv.po.progettotetris.model.facade.Controller;
import it.unipv.po.progettotetris.model.facade.Listener;
import it.unipv.po.progettotetris.model.facade.TitoloFinestra;

import javax.swing.*;
import java.awt.*;

public class FramePrincipale extends JFrame implements Listener {
    SignUpPanel signUpPanel;
    String titolo;
    Controller controller;
    LogInPanel loginpanel;

    public FramePrincipale(Controller controller){
        this.signUpPanel = new SignUpPanel(controller);
        this.titolo = "SIGN UP";
        this.controller = controller;
        this.loginpanel = new LogInPanel(controller);
        add(signUpPanel);


        setLayout(new GridLayout(1,1));
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle(titolo);
        controller.addListener(this);
    }

    @Override
    public void onUpdate(Object object) {

    }

    @Override
    public void switchTo(TitoloFinestra titolo) {
        System.out.println(titolo + " Frame Principale ");
        this.getContentPane().removeAll();
        //setLayout(new GridLayout(1,1));
        switch (titolo){
            case LOG_IN :

                add(loginpanel);
                System.out.println(" ok sono al login ");
                break;
            case SIGN_UP :

                add(signUpPanel);
                break;
        }
        this.repaint();
        this.revalidate();
    }
}
