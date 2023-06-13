package it.unipv.po.progettogamemanager.model.persistenza;

import java.io.*;

public interface Serializzabile {

     void write(String filename) throws IOException ; //serializza un oggetto serializzabile cioè lo salva su disco
}
