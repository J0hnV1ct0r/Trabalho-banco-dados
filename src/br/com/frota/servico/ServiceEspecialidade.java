package br.com.frota.servico;

import br.com.frota.DAO.EspecialidadeDAO;
import br.com.frota.model.Especialidade;

import java.sql.SQLException;
import java.util.List;

public class ServiceEspecialidade extends EspecialidadeDAO {
    @Override
    public Especialidade insertEspecialidade(Especialidade entidade) {
        super.insertEspecialidade(entidade);
        return entidade;
    }

    @Override
    public Especialidade selectEspecialidade(int id) {
        return super.selectEspecialidade(id);
    }

    @Override
    public List<Especialidade> selectAllEspecialidade() {
        return super.selectAllEspecialidade();
    }

    @Override
    public boolean deleteEspecialidade(int id) throws SQLException {
        return super.deleteEspecialidade(id);
    }

    @Override
    public boolean updateEspecialidade(Especialidade entidade) throws SQLException {
        return super.updateEspecialidade(entidade);
    }
}
