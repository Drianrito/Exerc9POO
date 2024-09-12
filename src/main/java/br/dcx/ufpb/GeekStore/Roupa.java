package br.dcx.ufpb.GeekStore;

public class Roupa {

    private String nome;
    private String tamanho;
    private String descricao;
    private TipoRoupa tipo;

    public Roupa(String nome, String tamanho, String descricao, TipoRoupa tipo) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.descricao = descricao;
        this.tipo = tipo;
    }
    public Roupa(){
        
    }
}
