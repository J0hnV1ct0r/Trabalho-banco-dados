package br.com.frota.util;

import br.com.frota.DAO.PacienteDAO;
import br.com.frota.model.Paciente;

import java.sql.SQLException;
import java.util.List;

public class ServicePaciente {

    private PacienteDAO pacienteDAO = new PacienteDAO();

    public void Insert(Paciente paciente){
        paciente = pacienteDAO.insertPaciente(paciente);
    }
    public Paciente Selcet(int id){
        return pacienteDAO.selectPaciente(id);
    }
    public List<Paciente> SelectAll(){
        return pacienteDAO.selectAllPaciente();
    }
    public void Update(Paciente paciente) throws SQLException {
        pacienteDAO.updatePaciente(paciente);
    }
    public void Delete(int id) throws SQLException {
        pacienteDAO.deletePaciente(id);
    }
}
