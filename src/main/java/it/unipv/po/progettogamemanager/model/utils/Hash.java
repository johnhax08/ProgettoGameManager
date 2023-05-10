package it.unipv.po.progettogamemanager.model.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static int hash(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashedpassword = md.digest(password.getBytes(StandardCharsets.UTF_8)); // ha fatto l'hash della password e me la ritornata come un array di byte
            //return new String(hashedpassword, StandardCharsets.UTF_8);
            int acc = 0;
            for(byte x :hashedpassword){
                acc += x;
            }
            return acc;
        }
        catch(NoSuchAlgorithmException e){
            return 0;
        }
    }
}
