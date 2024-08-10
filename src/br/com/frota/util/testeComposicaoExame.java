package br.com.frota.util;

import br.com.frota.model.ComposicaoExame;
import br.com.frota.model.UnidadeMedida;
import br.com.frota.servico.ServiceComposicaoExame;

import java.sql.SQLException;

public class testeComposicaoExame {


    public static void main(String[] args) throws SQLException {
        ServiceComposicaoExame serviceComposicaoExame = new ServiceComposicaoExame();
        UnidadeMedida un = new UnidadeMedida(2,"muito grande");
        ComposicaoExame composicaoExame = new ComposicaoExame("uma descricao aqui",un);
        serviceComposicaoExame.Insert(composicaoExame);
        System.out.println(serviceComposicaoExame.Selcet(1));
        ComposicaoExame composicaoEx = new ComposicaoExame(1,"uma descricao aqui",un);
        serviceComposicaoExame.Update(composicaoEx);
    }
}
