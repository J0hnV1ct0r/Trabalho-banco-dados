package br.com.frota.servico;

import br.com.frota.DAO.PacienteDAO;
import br.com.frota.model.Paciente;

import java.sql.SQLException;
import java.util.List;

public class ServicePaciente extends PacienteDAO {
    @Override
    public Paciente insertPaciente(Paciente entidade) {
        super.insertPaciente(entidade);
        return entidade;
    }

    @Override
    public Paciente selectPaciente(int id) {
        return super.selectPaciente(id);
    }

    @Override
    public List<Paciente> selectAllPaciente() {
        return super.selectAllPaciente();
    }

    @Override
    public boolean deletePaciente(int id) throws SQLException {
        return super.deletePaciente(id);
    }

    @Override
    public boolean updatePaciente(Paciente entidade) throws SQLException {
        return super.updatePaciente(entidade);
    }
}
