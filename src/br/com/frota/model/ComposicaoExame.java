package br.com.frota.model;

public class ComposicaoExame extends GenericModel{
    private String descricao;
    private UnidadeMedida unidadeMedidaId;

    public ComposicaoExame(String descricao,UnidadeMedida unidadeMedidaId){
        super();
        this.unidadeMedidaId = unidadeMedidaId;
        this.descricao = descricao;
    }

    public ComposicaoExame(Integer id, String descricao, UnidadeMedida unidadeMedidaId){
        this.descricao = descricao;
        this.unidadeMedidaId = unidadeMedidaId;
        super.setId(id);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getUnidadeMedidaId() {
        return unidadeMedidaId.getId();
    }

    public void setUnidadeMedidaId(UnidadeMedida unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }

    @Override
    public String toString() {
        return "Composicao_exame {" +
                "id ='" + this.getId() + "\'" +
                "descricao ='" + descricao + "\'"+
                "unidade_medida_id ='" + unidadeMedidaId + "\'" +
                '}';
    }


}