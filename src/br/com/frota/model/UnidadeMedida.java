package br.com.frota.model;

public class UnidadeMedida extends GenericModel{
    private String descricao;

    public UnidadeMedida(String descricao) {
        this.descricao = descricao;
    }


    public UnidadeMedida(Integer id, String descricao){
        this.descricao = descricao;
        super.setId(id);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Unidade_medida {" +
                "id ='" + this.getId() + "\'" +
                "descricao ='" + descricao + "\'" +
                '}';
    }
}
