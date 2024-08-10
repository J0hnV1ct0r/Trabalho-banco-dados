package br.com.frota.model;

public class MaterialExame extends GenericModel{
    private String material;
    private String observacao;

    public MaterialExame(String material, String observacao){
        this.material = material;
        this.observacao = observacao;
    }

    public MaterialExame(Integer id, String material, String observacao){
        this.material = material;
        this.observacao = observacao;
        super.setId(id);
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Material_exame {" +
                "id ='" + this.getId() + "\'" +
                "observacao ='" + observacao + "\'" +
                "material =" + material + "\'" +
                '}';
    }
}