package br.com.frota.servico;

import br.com.frota.DAO.TipoExameDAO;
import br.com.frota.model.TipoExame;

import java.sql.SQLException;
import java.util.List;

public class ServiceTipoExama {
    private TipoExameDAO tipoExameDAO = new TipoExameDAO();

    public TipoExame Insert(TipoExame tipoExame) {
        return tipoExameDAO.insertTipoExame(tipoExame);
    }

    public TipoExame Selcet(int id) {
        return tipoExameDAO.selectTipoExame(id);
    }

    public List<TipoExame> SelectAll() {
        return tipoExameDAO.selectAllTipoExama();
    }

    public void Update(TipoExame tipoExame) throws SQLException {
        tipoExameDAO.updateTipoExame(tipoExame);
    }

    public void Delete(int id) throws SQLException {
        tipoExameDAO.deleteTipoExame(id);
    }
}
