package br.dcx.rian;

import java.util.Objects;

public class Diarista implements Comparable<Diarista>{
    private String nome;
    private String cpf;
    private String telefone;

    public Diarista(String telefone, String nome, String cpf) {
        this.telefone = telefone;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Diarista() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diarista diarista = (Diarista) o;
        return Objects.equals(cpf, diarista.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public int compareTo(Diarista outraDiarista) {
        return this.nome.compareTo(outraDiarista.getNome());
            }
}
