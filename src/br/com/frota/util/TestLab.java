package br.com.frota.util;

import br.com.frota.model.Contato;
import br.com.frota.model.Endereco;
import br.com.frota.model.Laboratorio;
import br.com.frota.model.ResponsavelTecnico;
import br.com.frota.servico.ServiceLaboratorio;

import java.sql.SQLException;
import java.text.ParseException;

public class TestLab {
    public static void main(String[] args) throws SQLException, ParseException{
        //Laboratorio lab = new Laboratorio("Grande laboratorio","Nest","09853487","7453263478","8743683274");
        //Endereco end = new Endereco("Redfield","perto do parque","centro","83729837","Raccon City",lab,"654");
        //lab.setEnd(end);
        //lab.setCon(new Contato("098-2465-123",lab));
        //lab.setCon(new Contato("837-2369-123",lab));
        //lab.setRes(new ResponsavelTecnico("Lydia Frie","nada é verdade","radiologia","caverinha de perigo"));
        Laboratorio lab = new Laboratorio("laboratorio subterranio","Mansão Arkley","0837442375","776342578","4875682");
        Endereco end = new Endereco("trilha","segredo","montanhas Arkleys","875649","Raccon City",lab,"000");
        lab.setEnd(end);
        lab.setCon(new Contato("837-523-123",lab));
        lab.setCon(new Contato("555-666-123",lab));
        lab.setRes(new ResponsavelTecnico("William Barken","teste em se msm","virologia","v"));
        lab.setRes(new ResponsavelTecnico("Gustavo", "conselho","radiologia","r"));
        new ServiceLaboratorio().InsertLaboratotio(lab);
        //System.out.println(new ServiceLaboratorio().SelectLaboratorioEndereco(lab));
        //System.out.println(new ServiceLaboratorio().SelectLaboratorio(1));
        //for(Contato c:new ServiceLaboratorio().SelectLaboratorioContatos(lab)){
            //System.out.println(c);
       // }
        //for(ResponsavelTecnico r:new ServiceLaboratorio().SelectResponsavelLaboratorio(lab)){
           //System.out.println(r);
        //}
        //new LaboratorioDAO().deleteLaboratorio(7);
        //new ServiceLaboratorio().UpdateLaboratorioEnderece(lab);
        //new ServiceLaboratorio().DeleteLaboratorio(lab);





    }
}
