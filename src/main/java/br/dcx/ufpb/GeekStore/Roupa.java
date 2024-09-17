package br.dcx.ufpb.GeekStore;

public class Roupa {

    private String nome;
    private String tamanho;
    private String descricao;
    private TipoRoupa tipo;
    private String id;

    public Roupa(String nome, String tamanho, String descricao, TipoRoupa tipo,String id) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.descricao = descricao;
        this.tipo = tipo;
        this.id = id;
    }
    public Roupa(){
        this("","","",TipoRoupa.INDEFINIDO,"");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoRoupa getTipo() {
        return tipo;
    }

    public void setTipo(TipoRoupa tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roupa roupa = (Roupa) o;
        return id.equals(roupa.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
