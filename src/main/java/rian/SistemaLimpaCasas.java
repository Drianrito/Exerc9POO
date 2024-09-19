package rian;


import rian.exception.CasaJaExisteException;
import rian.exception.DiaristaJaCadastradaException;
import rian.exception.DiaristaNaoEncontradaException;

import java.util.ArrayList;
import java.util.HashMap;

public class SistemaLimpaCasas implements SistemaDiarista{
    public HashMap<String,Diarista> listaDiaristas = new HashMap();
    public ArrayList<Moradia> listaMoradia = new ArrayList<>();
    public ArrayList<DiaristasContratadas> listaContratadas= new ArrayList<>();

    @Override
    public boolean cadastraDiarista(String nome, String cpf, String telefone)throws DiaristaJaCadastradaException {
        if(!listaDiaristas.containsKey(cpf)){
           Diarista diarista = new Diarista(nome,cpf,telefone);
            listaDiaristas.put(cpf,diarista);
            return true;
        }else {
            throw new DiaristaJaCadastradaException("Ja existe diarista com esse cpf");
        }
    }

    @Override
    public void removerDiaristaPorCPF(String cpf)throws DiaristaNaoEncontradaException {
        if(listaDiaristas.containsKey(cpf)){
            listaDiaristas.remove(cpf);
        }else{
            throw new DiaristaNaoEncontradaException("Essa diarista nao se encontra no sistema");
        }
    }

    @Override
    public void contratarDiarista(String cpf, String cpfProprietario) {
            if(listaDiaristas.containsKey(cpf)){
                for(Moradia mo: listaMoradia){
                    if(cpfProprietario.equals(mo.getCpfProprietario())){
                        Diarista diarista = listaDiaristas.get(cpf);
                        DiaristasContratadas contratadas = new DiaristasContratadas(diarista,mo);
                        listaContratadas.add(contratadas);
                    }
            }
        }
    }

    @Override
    public void cadastrarMoradia(Moradia dono, Endereco endereco)throws CasaJaExisteException {
        for (Moradia moradia: listaMoradia){
            if (endereco.getNumeroCasa().equals(moradia.getNumeroCasa()) && endereco.getRua().equals(moradia.getRua())){
                throw new CasaJaExisteException("Casa ja cadastrada");
            }else{
                Moradia moradiaAdicionar = new Moradia(dono.getNomeProprietario(), dono.getCpfProprietario(), endereco);
                listaMoradia.add(moradiaAdicionar);
            }
        }
    }

    @Override
    public void removerMoradia(String cpfProprietario, Endereco endereco) {
        for (Moradia m: listaMoradia){
            if (cpfProprietario.equals(m.getCpfProprietario()) && endereco.getNumeroCasa().equals(m.getNumeroCasa())){
                listaMoradia.remove(m);
            }
        }
    }
}
