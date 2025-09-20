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

        System.out.println("Inserido com sucesso!");
    }
    
    public void atualizar(Despesa despesa){
        despesaDAO.update(despesa);
        
        System.out.println("Atualizado com sucesso!");
    }

    public void deletar(int id) {
        despesaDAO.delete(id);

        System.out.println("Excluido com sucesso!");
    }

    public void buscarPorId(int id) {
        Despesa despesa = despesaDAO.findById(id);

        System.out.println(despesa);
    }

    public void buscarPorData(int ano, int mes) {
        List<Despesa> despesas = despesaDAO.findByDate(ano, mes);

        for (Despesa despesa : despesas) {
            System.out.println(despesa);
        }
    }
    
    public void listar() {
        List<Despesa> despesas = despesaDAO.findAll();

        for (Despesa despesa : despesas) {
            System.out.println(despesa);
        }
    }
}
