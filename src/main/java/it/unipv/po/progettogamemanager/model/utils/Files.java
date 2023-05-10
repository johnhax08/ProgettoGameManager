package it.unipv.po.progettogamemanager.model.utils;

import java.io.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

    public class Files {


        public static String read(String path) throws IOException {

            final var br = new BufferedReader(new FileReader(new File(path)));
            String line = null;
            String out = "";

            while ( (line  = br.readLine()) != null) {
                out += line + '\n';
            }

            br.close();
            return out;
        }

        public static void write(String path, String text) throws IOException {


            final var f = new File(path);
            f.createNewFile();
            final var fr =  new FileWriter(f);
            fr.write(text);
            fr.flush();
            fr.close();

        }


    }

