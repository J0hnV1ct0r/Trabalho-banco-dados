package br.com.frota.util;

import br.com.frota.model.Exame;
import br.com.frota.model.MaterialExame;
import br.com.frota.model.TipoExame;
import br.com.frota.servico.ServiceExame;

import java.sql.SQLException;

public class testeExame {
    public static void main(String[] args) throws SQLException {
        ServiceExame serviceExame = new ServiceExame();
        TipoExame tipoExame = new TipoExame(1,"sonda louca", "meia-noite te conto");
        MaterialExame materialExame = new MaterialExame(1,"Sangue","contaminado");
        Exame exame = new Exame("abrir ao meio","no bisturi",materialExame,tipoExame);
        serviceExame.Insert(exame);
        //System.out.println(serviceExame.Selcet(1));
        Exame exame2 = new Exame(1,"abrir ao meio","no bisturi",materialExame,tipoExame);
        //serviceExame.Update(exame2);
        //serviceExame.Delete(1);
    }
}
