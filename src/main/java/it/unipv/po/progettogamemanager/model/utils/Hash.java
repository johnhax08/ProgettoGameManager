package it.unipv.po.progettogamemanager.model.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    final static int MAX = 10000;
    public static int hash(String password) {
        return Math.abs(password.hashCode() % MAX);
    }
}
