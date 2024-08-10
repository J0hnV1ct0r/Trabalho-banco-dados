package br.com.frota.servico;

import br.com.frota.DAO.ExameDAO;
import br.com.frota.model.Exame;

import java.sql.SQLException;
import java.util.List;

public class ServiceExame {
    private ExameDAO exameDAO = new ExameDAO();

    public Exame Insert(Exame exame){
        return exameDAO.insert(exame);
    }
    public Exame Selcet(int id){
        return exameDAO.select(id);
    }
    public List<Exame> SelectAll(){
        return exameDAO.selectAll();
    }
    public void Update(Exame exame) throws SQLException {
        exameDAO.update(exame);
    }
    public void Delete(int id) throws SQLException {
        exameDAO.delete(id);
    }
}
