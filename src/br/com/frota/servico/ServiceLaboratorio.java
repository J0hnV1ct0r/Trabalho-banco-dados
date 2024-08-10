package br.com.frota.servico;

import br.com.frota.DAO.*;
import br.com.frota.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceLaboratorio  {
    private ContatoDAO contatoDAO = new ContatoDAO();
    private EnderecoDAO enderecoDAO = new EnderecoDAO();
    private ResponsavelTecnicoDAO responsavelTecnicoDAO = new ResponsavelTecnicoDAO();
    private ResponsavelTecnicoHasLaboratorioDAO responsavelTecnicoHasLaboratorioDAO = new ResponsavelTecnicoHasLaboratorioDAO();

    private LaboratorioDAO insertLaboratorio = new LaboratorioDAO();
    private LaboratorioDAO selectLaboratorio = new LaboratorioDAO();
    private LaboratorioDAO selectAllLaboratorio = new LaboratorioDAO();
    private LaboratorioDAO updateLaboratorio = new LaboratorioDAO();
    private LaboratorioDAO deleteLaboratorio = new LaboratorioDAO();

//INSERTS:
    public void InsertLaboratotio(Laboratorio lab){
        Laboratorio labNov = insertLaboratorio.insertLaboratorio(lab);
       lab.setEnd( enderecoDAO.insertEndereco(labNov.getEnd()));
        for(Contato c : labNov.getCon()){
           contatoDAO.insertContato(c);
        }
        List<ResponsavelTecnico> resp = new ArrayList<>();
        for(ResponsavelTecnico r : labNov.getRes()){
            resp.add(responsavelTecnicoDAO.insertResponsavelTecnico(r));
        }

        List<ResponsavelTecnicoHasLaboratorio> rhl = new ArrayList<>();
        for(ResponsavelTecnico r : resp){
            rhl.add(responsavelTecnicoHasLaboratorioDAO.insertResponsavelTecnicoHasLaboratorio(new ResponsavelTecnicoHasLaboratorio(labNov,r)));
        }
    }

//SELECTS:
    public Laboratorio SelectLaboratorio(int id){
       return selectLaboratorio.selectLaboratorio(id);
    }

    public List<Laboratorio> SelectAllLaboratorio(){
        return selectAllLaboratorio.selectAllLaboratorio();
    }

    public List<Contato> SelectLaboratorioContatos(Laboratorio lab){
        return contatoDAO.selectContatoByLab(lab);
    }

    public List<ResponsavelTecnico> SelectResponsavelLaboratorio(Laboratorio lab){
        List<ResponsavelTecnico> respReturn = new ArrayList<>();
        for(ResponsavelTecnicoHasLaboratorio rhm : responsavelTecnicoHasLaboratorioDAO.selectResponsavelTecnicoHasLaboratorio(lab)){
          respReturn.add(responsavelTecnicoDAO.selectResponsavelTecnico(rhm.getResponsavelTecnico()));
        }
        return respReturn;
    }

    public Endereco SelectLaboratorioEndereco(Laboratorio lab){
       return enderecoDAO.selectEndereco(lab);
    }

//UPDATES:
    public void UpdateLaboratorioEnderece(Laboratorio lab) throws SQLException {
        enderecoDAO.updateEndereco(lab.getEnd());
    }

    public void UpdateLaboratorio(Laboratorio lab) throws SQLException {
        updateLaboratorio.updateLaboratorio(lab);
    }
    public void UpdateLaboratorioContato(Laboratorio lab) throws SQLException {
        for(Contato c : lab.getCon()){
            contatoDAO.updateContato(c);
        }
    }
    public void UpdateLaboratorioResponsavel(Laboratorio lab) throws SQLException {
        for(ResponsavelTecnico r : lab.getRes()){
            responsavelTecnicoDAO.updateResponsavelTecnico(r);
        }

    }
//DELETES:
    public void DeleteContatoLaboratorio(Contato con) throws SQLException {
        contatoDAO.deleteContato(con.getId());
    }

    public void DeleteLaboratorio(Laboratorio lab) throws SQLException {
         for(Contato c : contatoDAO.selectContatoByLab(lab)){
            contatoDAO.deleteContato(c.getId());
         }
         //List<ResponsavelTecnicoHasLaboratorio> res =responsavelTecnicoHasLaboratorioDAO.selectResponsavelTecnicoHasLaboratorio(lab);
        //responsavelTecnicoDAO.deleteResponsavelTecnico(lab.getId());
       // for(ResponsavelTecnicoHasLaboratorio r : responsavelTecnicoHasLaboratorioDAO.selectResponsavelTecnicoHasLaboratorio(lab)) {
            //responsavelTecnicoDAO.deleteResponsavelTecnico(r.getResponsavelTecnico());
       // }
         //enderecoDAO.deleteEndereco(lab.getEnd().getId());
         deleteLaboratorio.deleteLaboratorio(lab.getId());
    }

}
