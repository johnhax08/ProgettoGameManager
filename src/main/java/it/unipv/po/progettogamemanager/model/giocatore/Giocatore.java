package it.unipv.po.progettogamemanager.model.giocatore;

import it.unipv.po.progettogamemanager.model.persistenza.Serializzabile;
import it.unipv.po.progettogamemanager.model.utils.Files;
import org.json.JSONObject;

import java.io.IOException;

public interface Giocatore extends Serializzabile {
    String getNome();
    int getPassword();
    TipiGiocatore getTipo();

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
        System.out.println(jo);
        var nome = jo.get("nome").toString();
        System.out.println(nome);
        var password = Integer.parseInt(jo.get("password").toString()) ;
        System.out.println(password);
        System.out.println(jo.get("tipo").toString());
        switch (jo.get("tipo").toString()){

            case "BEGINNER" :
                //System.out.println("begginner");
                return new GiocatoreBegginner(nome, password);

            case "PROFESSIONAL" :
                return new GiocatoreProfessional(nome, password);

        }

        return null;


    }

    /**
     * g1.vince(g2) se è true vuol dire che ha vinto g1
     *
     * */
    public boolean vince(Giocatore g);




}
