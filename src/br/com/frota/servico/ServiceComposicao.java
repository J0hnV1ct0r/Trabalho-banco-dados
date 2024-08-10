package br.com.frota.servico;

import br.com.frota.DAO.ComposicaoDAO;
import br.com.frota.model.Composicao;

import java.sql.SQLException;
import java.util.List;

public class ServiceComposicao {
    private ComposicaoDAO composicaoDAO = new ComposicaoDAO();

    public Composicao Insert(Composicao composicao){
        return composicaoDAO.insert(composicao);
    }
    public Composicao Selcet(int id){
        return composicaoDAO.select(id);
    }
    public List<Composicao> SelectAll(){
        return composicaoDAO.selectAll();
    }
    public void Update(Composicao composicao) throws SQLException {
        composicaoDAO.update(composicao);
    }
    public void Delete(int id) throws SQLException {
        composicaoDAO.delete(id);
    }
}
