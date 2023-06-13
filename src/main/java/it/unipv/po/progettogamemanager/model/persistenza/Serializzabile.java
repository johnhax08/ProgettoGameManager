package it.unipv.po.progettogamemanager.model.persistenza;

import java.io.*;

public interface Serializzabile {

    default void write(String filename) throws IOException {
        ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream(filename));
        f.writeObject(this);
    }
}
