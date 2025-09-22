
package DAO;

import java.time.LocalDate;
import java.util.List;
import model.Despesa;

public interface DespesaDAO {
    
    void insert(Despesa despesa);
    void update(Despesa despesa);
    void delete(Integer id);
    Despesa findById(Integer id);
    List<Despesa> findByStatus(String status);
    List<Despesa> findByDate(int year, int month);
    List<Despesa> findAll();
}
