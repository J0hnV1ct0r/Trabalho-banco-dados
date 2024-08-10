package br.com.frota.model;

public class Especialidade extends GenericModel{
    private String descricao;
    private String observacao;

    public Especialidade(String descricao, String observacao){
        this.descricao = descricao;
        this.observacao = observacao;
    }

    public Especialidade(Integer id, String descricao, String observacao){
        this.descricao = descricao;
        this.observacao = observacao;
        super.setId(id);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    @Override
    public String toString() {
        return "Esepecialidade {" +
                "id = '" + this.getId() + "\'" +
                ", descricao = '" + descricao + "\'" +
                ", observacao = '" + observacao + "\'" +
                '}';
    }
}