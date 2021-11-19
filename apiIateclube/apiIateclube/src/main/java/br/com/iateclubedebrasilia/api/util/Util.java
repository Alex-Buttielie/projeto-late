package br.com.iateclubedebrasilia.api.util;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Util {



    public static Collection< ? > isListaObjVazia(final List c) {

        if (c.isEmpty())
            return null;

        return c;
    }


    public static String newPassword() {
        char[] vet = new char[10];
        for (int i=0; i<10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private static char randomChar() {
        Random rand = new Random();
        int opt = rand.nextInt(3);
        if (opt == 0) { // gera um digito
            return (char) (rand.nextInt(10) + 48);
        }
        else if (opt == 1) { // gera letra maiuscula
            return (char) (rand.nextInt(26) + 65);
        }
        else { // gera letra minuscula
            return (char) (rand.nextInt(26) + 97);
        }
    }
}

