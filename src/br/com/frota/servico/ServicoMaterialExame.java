package br.com.frota.servico;

import br.com.frota.DAO.MaterialExameDAO;
import br.com.frota.model.MaterialExame;

import java.sql.SQLException;
import java.util.List;

public class ServicoMaterialExame {
    private MaterialExameDAO materialExameDAO =  new MaterialExameDAO();

    public MaterialExame Insert(MaterialExame materialExame){
        return materialExameDAO.insert(materialExame);
    }
    public MaterialExame Selcet(int id){
        return materialExameDAO.select(id);
    }
    public List<MaterialExame> SelectAll(){
        return materialExameDAO.selectAll();
    }
    public void Update(MaterialExame materialExame) throws SQLException {
        materialExameDAO.update(materialExame);
    }
    public void Delete(int id) throws SQLException {
        materialExameDAO.delete(id);
    }

}
