package br.com.frota.util;

import br.com.frota.model.MaterialExame;
import br.com.frota.servico.ServicoMaterialExame;

import java.sql.SQLException;

public class testeMaterialExame {
    public static void main(String[] args) throws SQLException {
        ServicoMaterialExame servicoMaterialExame = new ServicoMaterialExame();
        MaterialExame materialExame = new MaterialExame("Sangue","contaminado");
        servicoMaterialExame.Insert(materialExame);
        System.out.println(servicoMaterialExame.Selcet(1));
        MaterialExame materialExame2 = new MaterialExame(1,"Sangue","Limpo");
        servicoMaterialExame.Update(materialExame2);

        //servicoMaterialExame.Delete(1);
    }
}
