package br.dcx.ufpb.GeekStore;

import br.dcx.ufpb.GeekStore.Exception.RoupaJaCadastrada;
import br.dcx.ufpb.GeekStore.Exception.RoupaNaoExiste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SistemaGeekStore implements SistemaStore{

    public HashMap<String,Roupa> roupasMAP = new HashMap<>();

    @Override
    public void cadastrarRoupa(String nome, String tamanho, String descricao, TipoRoupa tipo,String id) throws RoupaJaCadastrada {
        if(roupasMAP.containsKey(id)){
            throw new RoupaJaCadastrada("Roupa com mesmo ID ja cadastrado");
        }else {
        Roupa novaRoupa = new Roupa(nome,tamanho,descricao,tipo,id);
        roupasMAP.put(id,novaRoupa);}
    }

    @Override
    public void removerRoupaID(String id) throws RoupaNaoExiste {
        if(roupasMAP.containsKey(id)) roupasMAP.remove(id);
        else {
            throw new RoupaNaoExiste("Roupa com ID nao encontrado, Verifique novamente");
        }
    }

    @Override
    public List<Roupa> procuraRoupaTipo(TipoRoupa tipo) {
        List<Roupa> listaTipo = new ArrayList<>();
        for(Roupa r: roupasMAP.values()){
            if (r.getTipo() == tipo){
                listaTipo.add(r);
            }
        }return listaTipo;
    }

    public List<Roupa> procuraRoupaNome(String nome){
        List<Roupa> listaNome = new ArrayList<>();
        for(Roupa r: roupasMAP.values()){
            if (r.getNome().startsWith(nome)){
                listaNome.add(r);
            }
        }return listaNome;
    }
    public Roupa procurarPorId (String id){
        return roupasMAP.get(id);
    }

}
