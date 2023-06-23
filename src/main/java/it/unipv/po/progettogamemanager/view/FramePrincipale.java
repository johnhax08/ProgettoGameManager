package it.unipv.po.progettogamemanager.view;

import it.unipv.po.progettogamemanager.model.gamemanager.GameManager;
import it.unipv.po.progettogamemanager.model.gamemanager.Listener;
import it.unipv.po.progettogamemanager.model.gamemanager.Pagine;

import javax.swing.*;
import java.awt.*;

public class FramePrincipale extends JFrame implements Listener {
    SignUpPanel signUpPanel;
    GameManager gameManager;
    LogInPanel loginpanel;
    GiocaPanel giocaPanel;
    MainMenu mainMenu;
    RicercaPartitaPanel partitaPanel;


    public FramePrincipale(GameManager gameManager){
        this.signUpPanel = new SignUpPanel(gameManager);
        this.gameManager = gameManager;
        this.loginpanel = new LogInPanel(gameManager);
        this.giocaPanel = new GiocaPanel(gameManager);
        this.partitaPanel = new RicercaPartitaPanel(gameManager);
        this.mainMenu = new MainMenu(gameManager);


        setLayout(new GridLayout(1,1));
        setSize(500,500);
        setLocationRelativeTo(null);//centrare la finestra sullo schermo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        gameManager.addListener(this);
    }

    @Override
    public void updatePagina(Pagine titolo) {

        this.getContentPane().removeAll();//rimuovo qualsiasi panel precedente
        switch (titolo){ //in base alla pagina che mi è stata richiesta faccio uno switch case
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

            case MENU_PRINCIPALE:
                setTitle("MENU PRINCIPALE");
                add(mainMenu);
                break;

        }
        this.repaint(); //servono per ridisegnare lo schermo, non so se uno basta ma abbondare non fa male :)
        this.revalidate();
    }
}
