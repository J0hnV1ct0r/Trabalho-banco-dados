package br.com.frota.util;

import br.com.frota.model.HabilitacaoExame;
import br.com.frota.model.Laboratorio;
import br.com.frota.model.TipoExame;
import br.com.frota.servico.ServiceHabilitacaoExame;

import java.sql.SQLException;

public class testeHabilitaçaoExame {
    public static void main(String[] args) throws SQLException {
        Laboratorio lab = new Laboratorio(1,"laboratorio subterranio","Mansão Arkley","0837442375","776342578","4875682");
        TipoExame tipoExame = new TipoExame(2,"sonda louca", "meia-noite te conto");
        HabilitacaoExame habilitacaoExame = new HabilitacaoExame("exame unico",98,lab,tipoExame);
        new ServiceHabilitacaoExame().Insert(habilitacaoExame);
        System.out.println(new ServiceHabilitacaoExame().Selcet(1));
        HabilitacaoExame habilitacaoExame2 = new HabilitacaoExame(1,"exame fatal",98,lab,tipoExame);
        new ServiceHabilitacaoExame().Update(habilitacaoExame2);
        //new ServiceHabilitacaoExame().Delete(1);


    }
}
