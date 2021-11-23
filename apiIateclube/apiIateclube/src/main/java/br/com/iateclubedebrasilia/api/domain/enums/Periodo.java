package br.com.iateclubedebrasilia.api.domain.enums;

public enum Periodo {

    DIURNO		(1, "Diurno", "DIURNO"),
    NOTURNO				(2, "Noturno", "NOTURNO");

    private final int valor;
    private final String descricao;
    private final String valorStr;

    Periodo(int valor, String descricao, String valorStr) {
        this.valor = valor;
        this.descricao = descricao;
        this.valorStr = valorStr;
    }

    public int getValor() {
        return this.valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getValorStr() {
        return valorStr;
    }

    public static String getDescricao(int valor) {
        for (Periodo periodoEnum : values())
            if (periodoEnum.getValor() == valor)
                return periodoEnum.getDescricao();
        return null;
    }

}
