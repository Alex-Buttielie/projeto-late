package br.com.iateclubedebrasilia.api.util;

import java.util.Collection;
import java.util.List;

public class Util {

    public static Collection< ? > isListaObjVazia(final List c) {

        if (c.isEmpty())
            return null;

        return c;
    }
}
