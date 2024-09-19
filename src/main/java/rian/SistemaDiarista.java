package rian;

import rian.exception.*;


public interface SistemaDiarista {
    public boolean cadastraDiarista(String nome, String cpf, String telefone)throws DiaristaJaCadastradaException;
    public void removerDiaristaPorCPF(String cpf)throws DiaristaNaoEncontradaException;
    public void contratarDiarista(String cpf,String cpfProprietario);
    public void cadastrarMoradia(Moradia dono,Endereco endereco)throws CasaJaExisteException;
    public void removerMoradia(String cpfProprietario, Endereco endereco);
}
