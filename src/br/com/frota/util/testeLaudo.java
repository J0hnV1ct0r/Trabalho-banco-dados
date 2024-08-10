package br.com.frota.util;

import br.com.frota.model.*;
import br.com.frota.servico.ServiceLaudo;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testeLaudo {
    public static void main(String[] args) throws ParseException, SQLException {
        String dateSTR = "28-05-2001";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date data = formatter.parse(dateSTR);
        Paciente pac = new Paciente(1,"Maria",data);
        Medico med = new Medico(1,"William Birkin","54551");
        med.setEsp(new Especialidade("virologia","o melhor"));
        med.setEsp(new Especialidade("Anatomia","o melhor"));
        ConsultaMedica consultaMedica =  new ConsultaMedica(1,data,"88776",pac,med);
        Laboratorio lab = new Laboratorio(1,"laboratorio subterranio","Mansão Arkley","0837442375","776342578","4875682");
        TipoExame tipoExame = new TipoExame(2,"sonda louca", "meia-noite te conto");
        HabilitacaoExame habilitacaoExame = new HabilitacaoExame(1,"exame unico",98,lab,tipoExame);
        MaterialExame materialExame = new MaterialExame(1,"Sangue","contaminado");
        Exame exame = new Exame(2,"abrir ao meio","no bisturi",materialExame,tipoExame);
        SolicitacaoExame solicitacaoExame = new SolicitacaoExame(1,"987",data,consultaMedica,habilitacaoExame,exame);

        Laudo laudo = new Laudo("william","23/02/2012","7846",solicitacaoExame);

        new ServiceLaudo().Insert(laudo);
        System.out.println(new ServiceLaudo().Selcet(1));
        Laudo laudo2 = new Laudo(1,"william Birkin","23/02/2012","7846",solicitacaoExame);
        new ServiceLaudo().Update(laudo2);
        new ServiceLaudo().Delete(1);






    }
}
