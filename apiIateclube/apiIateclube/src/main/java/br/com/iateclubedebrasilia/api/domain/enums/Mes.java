package br.com.iateclubedebrasilia.api.domain.enums;

public enum Mes {

    JANEIRO(1, "01", "Janeiro", "JAN"),
    FEVEREIRO(2, "02", "Fevereiro", "FEV"),
    MARCO(3, "03", "Março", "MAR"),
    ABRIL(4, "04", "Abril", "ABR"),
    MAIO(5, "05", "Maio", "MAI"),
    JUNHO(6, "06", "Junho", "JUN"),
    JULHO(7, "07", "Julho", "JUL"),
    AGOSTO(8, "08", "Agosto", "AGO"),
    SETEMBRO(9, "09", "Setembro", "SET"),
    OUTUBRO(10, "10", "Outubro", "OUT"),
    NOVEMBRO(11, "11", "Novembro", "NOV"),
    DEZEMBRO(12, "12", "Dezembro", "DEZ"),
    COMPETENCIA(13, "13", "Competência 13", "Competência 13");

    private final int valor;
    private final String valorString;
    private String descricao;
    private String descricaoAbreviada;

    Mes(int valor, String valorString, String descricao, String descricaoAbreviada) {
        this.valor = valor;
        this.descricao = descricao;
        this.descricaoAbreviada = descricaoAbreviada;
        this.valorString = valorString;
    }

    public String getValorString() {
        return valorString;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricaoAbreviada() {
        return descricaoAbreviada;
    }

    public String getDescricao() {
        return descricao;
    }
}
