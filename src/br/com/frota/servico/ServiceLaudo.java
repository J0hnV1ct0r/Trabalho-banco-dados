package br.com.frota.servico;

import br.com.frota.DAO.LaudoDAO;
import br.com.frota.model.Laudo;

import java.sql.SQLException;
import java.util.List;

public class ServiceLaudo {
    private LaudoDAO laudoDAO = new LaudoDAO();

    public Laudo Insert(Laudo laudo){
        return laudoDAO.insert(laudo);
    }
    public Laudo Selcet(int id){
        return laudoDAO.select(id);
    }
    public List<Laudo> SelectAll(){
        return laudoDAO.selectAll();
    }
    public void Update(Laudo laudo) throws SQLException {
        laudoDAO.update(laudo);
    }
    public void Delete(int id) throws SQLException {
        laudoDAO.delete(id);
    }
}
