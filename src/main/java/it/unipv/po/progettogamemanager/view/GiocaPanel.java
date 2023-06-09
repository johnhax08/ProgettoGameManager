package it.unipv.po.progettogamemanager.view;

import it.unipv.po.progettogamemanager.model.gamemanager.GameManager;
import it.unipv.po.progettogamemanager.model.giocatore.Giocatore;
import it.unipv.po.progettogamemanager.model.partita.Partita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiocaPanel extends JPanel {
    JTextArea nome;
    JButton sfida;
    GameManager gameManager;

    public GiocaPanel(GameManager gameManager){
        this.nome = new JTextArea();
        this.sfida = new JButton("SFIDA!");
        this.gameManager = gameManager;

        setLayout(new GridLayout(2,1));
        add(nome);
        add(sfida);

        this.sfida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Giocatore g1 = gameManager.getGiocatoreAttuale();
                Giocatore g2 = gameManager.getGiocatoreByNome(nome.getText());
                Giocatore v = g1.vince(g2)?g1 : g2;  // : = sennò , ? operatore ternario ed è praticamente un if else su un'unica riga
                //g1.vince(g2) mi dovrebbe tornare true o false , il ? sta per : se questa cosa è vera vince g1 se non è vera vince g2
                Giocatore p = v==g1? g2 : g1; //se v=g1, il perdente è g2 altrimenti è g1

                gameManager.addPartita(Partita.getPartita(System.currentTimeMillis(),v,p));
                if(g1.equals(v)){
                    JOptionPane.showMessageDialog(null, "hai vinto!");
                }
                else{
                    JOptionPane.showMessageDialog(null, "hai perso!");
                }
            }
        });
    }
}


