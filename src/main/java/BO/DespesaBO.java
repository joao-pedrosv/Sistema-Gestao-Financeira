package BO;

import DAO.DespesaDAO;
import java.util.List;
import model.Despesa;

public class DespesaBO {

    private DespesaDAO despesaDAO;

    public DespesaBO(DespesaDAO despesaDAO) {
        this.despesaDAO = despesaDAO;
    }

    public void inserirDespesa(Despesa despesa) {
        despesaDAO.insert(despesa);
    }
    
    public void atualizar(Despesa despesa){
        despesaDAO.update(despesa);
    }

    public void deletar(int id) {
        despesaDAO.delete(id);
    }

    public Despesa buscarPorId(int id) {
        return despesaDAO.findById(id);
    }

    public List<Despesa> buscarPorData(int ano, int mes) {
        List<Despesa> despesas = despesaDAO.findByDate(ano, mes);

        return despesas;
    }
    
    public List<Despesa> listar() {
        List<Despesa> despesas = despesaDAO.findAll();
        
        return despesas;

    }
}
