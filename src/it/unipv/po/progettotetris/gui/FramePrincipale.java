package it.unipv.po.progettotetris.gui;

import it.unipv.po.progettotetris.model.facade.Controller;
import it.unipv.po.progettotetris.model.facade.Listener;
import it.unipv.po.progettotetris.model.facade.TitoloFinestra;

import javax.swing.*;
import java.awt.*;

public class FramePrincipale extends JFrame implements Listener {
    SignUpPanel signUpPanel;
    Controller controller;
    LogInPanel loginpanel;
    GiocaPanel giocaPanel;
    MainMenu mainMenu;
    PartitaPanel partitaPanel;

    public FramePrincipale(Controller controller){
        this.signUpPanel = new SignUpPanel(controller);
        this.controller = controller;
        this.loginpanel = new LogInPanel(controller);
        this.giocaPanel = new GiocaPanel(controller);
        this.partitaPanel = new PartitaPanel(controller);
        this.mainMenu = new MainMenu(controller);
        add(mainMenu);



        setLayout(new GridLayout(1,1));
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Menù Principale");
        controller.addListener(this);
    }

    @Override
    public void onUpdate(Object object) {

    }

    @Override
    public void switchTo(TitoloFinestra titolo) {

        this.getContentPane().removeAll();
        switch (titolo){
            case LOG_IN :
                setTitle("LOG IN");
                add(loginpanel);
                break;

            case SIGN_UP :
                setTitle("SIGN UP");
                add(signUpPanel);
                break;

            case GIOCA_ORA :
                setTitle("GIOCA ORA");
                add(giocaPanel);
                break;
            case RICERCA_PARTITE :
                setTitle("RICERCA PARTITE");
                add(partitaPanel);
                break;

        }
        this.repaint();
        this.revalidate();
    }
}
