package br.dcx.ufpb.GeekStore;

import br.dcx.ufpb.GeekStore.Exception.RoupaJaCadastrada;
import br.dcx.ufpb.GeekStore.Exception.RoupaNaoExiste;

import java.util.List;

public interface SistemaStore {

    public void cadastrarRoupa(String nome, String tamanho, String descricao, TipoRoupa tipo, String id) throws RoupaJaCadastrada;
    public void removerRoupaID(String id)throws RoupaNaoExiste;
    public List<Roupa> procuraRoupaTipo(TipoRoupa tipo);
}
