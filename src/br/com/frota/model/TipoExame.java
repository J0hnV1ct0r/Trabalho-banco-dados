package br.com.frota.model;

public class TipoExame extends GenericModel{
    private String observacao;
    private String descricao;

    public TipoExame(int id,String observacao,String descricao) {
        this.descricao = descricao;
        this.observacao = observacao;
        super.setId(id);
    }

    public TipoExame(String observacao, String descricao) {
        this.observacao = observacao;
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString() {
        return "TipoExame {" +
                "id ='" + this.getId() + "\'" +
                "descricao ='" + descricao + "\'"+
                "observacao ='" + observacao + "\'" +
                '}';
    }
}
