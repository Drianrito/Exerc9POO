package rian;

public class Moradia extends Endereco{
    private String cpfProprietario;
    private String nomeProprietario;
    private Endereco endereco;

    public Moradia(String nomeProprietario, String cpfProprietario,Endereco endereco) {
        super(endereco.getRua(), endereco.getBairro(), endereco.getNumeroCasa(), endereco.getCidade());
        this.nomeProprietario = nomeProprietario;
        this.cpfProprietario = cpfProprietario;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }

}
