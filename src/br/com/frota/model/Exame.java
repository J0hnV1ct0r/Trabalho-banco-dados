package br.com.frota.model;

public class Exame extends GenericModel{
    private String descricao;
    private String metodo;
    private TipoExame tipoExameId;
    private MaterialExame materialExameId;

    public Exame(int id, String descricao,String metodo,MaterialExame materialExameId,TipoExame tipoExameId) {
        this.descricao = descricao;
        this.metodo = metodo;
        this.materialExameId = materialExameId;
        this.tipoExameId = tipoExameId;
        super.setId(id);

    }

    public Exame(String descricao, String metodo, MaterialExame materialExameId, TipoExame tipoExameId) {
        this.descricao = descricao;
        this.metodo = metodo;
        this.tipoExameId = tipoExameId;
        this.materialExameId = materialExameId;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getTipoExameId() {
        return tipoExameId.getId();
    }

    public void setTipoExameId(TipoExame tipoExameId) {
        this.tipoExameId = tipoExameId;
    }

    public int getMaterialExameId() {
        return materialExameId.getId();
    }

    public void setMaterialExameId(MaterialExame materialExameId) {
        this.materialExameId = materialExameId;
    }

    @Override
    public String toString() {
        return "Exame {" +
                "id ='" + this.getId() + "\'" +
                "descricao ='" + descricao + "\'" +
                "metodo =" + metodo + "\'" +
                "tipoExameId =" + tipoExameId + "\'" +
                "materialExameId =" + materialExameId + "\'" +
                '}';
    }
}
