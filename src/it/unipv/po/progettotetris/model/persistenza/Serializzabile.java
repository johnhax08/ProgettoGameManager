package it.unipv.po.progettotetris.model.persistenza;

import java.io.*;

public interface Serializzabile extends Serializable {

    default void write(String filename) throws IOException {
        ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream(filename));
        f.writeObject(this);
    }

    static Serializzabile read(String filename) throws IOException, ClassNotFoundException{
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename))){
            return(Serializzabile)is.readObject();
        }
    }
}
