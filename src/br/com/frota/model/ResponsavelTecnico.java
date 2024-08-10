package br.com.frota.model;

public class ResponsavelTecnico extends GenericModel{
    private String nome;
    private String conselho;
    private String formacao;
    private String siglaFormacao;

    public ResponsavelTecnico(String nome, String conselho, String formacao, String siglaFormacao){
        this.nome = nome;
        this.conselho = conselho;
        this.formacao = formacao;
        this.siglaFormacao = siglaFormacao;
    }

    public ResponsavelTecnico(Integer id, String nome, String conselho, String formacao, String siglaFormacao){
        this.nome = nome;
        this.conselho = conselho;
        this.formacao = formacao;
        this.siglaFormacao = siglaFormacao;
        super.setId(id);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setConselho(String conselho){
        this.conselho = conselho;
    }

    public void setFormacao(String formacao){
        this.formacao = formacao;
    }

    public void setSiglaFormacao(String siglaFormacao){
        this.siglaFormacao = siglaFormacao;
    }

    //
    public String getConselho() {
        return conselho;
    }

    public String getFormacao() {
        return formacao;
    }

    public String getNome() {
        return nome;
    }

    public String getSiglaFormacao() {
        return siglaFormacao;
    }

    @Override
    public String toString() {
        return "Contato {" +
                "id='" + this.getId() + "\'" +
                "nome ='" + nome  + "\'" +
                "conselho ='" + conselho  + "\'" +
                "formacao ='" + formacao  + "\'" +
                "sigla_formacao ='" + siglaFormacao + "\'" +
                '}';
    }
}