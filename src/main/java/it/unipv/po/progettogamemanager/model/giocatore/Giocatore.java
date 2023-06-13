package it.unipv.po.progettogamemanager.model.giocatore;

import it.unipv.po.progettogamemanager.model.persistenza.Serializzabile;
import it.unipv.po.progettogamemanager.model.utils.Files;
import org.json.JSONObject;

import java.io.IOException;

public interface Giocatore extends Serializzabile {
    String getNome();
    int getPassword();
    TipiGiocatore getTipo();


    /**
     * g1.vince(g2) se è true vuol dire che ha vinto g1
     *
     * */
    public boolean vince(Giocatore g);


    public static Giocatore getGiocatore(String nome, int password, TipiGiocatore tipo){
        switch (tipo){
            case BEGINNER:
                return new GiocatoreBegginner(nome, password);
            case PROFESSIONAL:
                return new GiocatoreProfessional( nome, password);
            default:
                throw new RuntimeException("TIPO GIOCATORE INVALIDO!");

        }

    }
    public static Giocatore readJson(String path){
        String json = null;
        try {
            json = Files.read(path);
        } catch (IOException e) {
            e.printStackTrace();
        }


        JSONObject jo = new JSONObject(json);
        var nome = jo.get("nome").toString();
        var password = Integer.parseInt(jo.get("password").toString()) ;
        switch (jo.get("tipo").toString()){

            case "BEGINNER" :

                return new GiocatoreBegginner(nome, password);

            case "PROFESSIONAL" :
                return new GiocatoreProfessional(nome, password);

        }

        return null;


    }

}
