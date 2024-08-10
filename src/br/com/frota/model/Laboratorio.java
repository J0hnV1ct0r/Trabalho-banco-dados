package br.com.frota.model;

import java.util.ArrayList;
import java.util.List;

public class Laboratorio extends GenericModel{
    private String descricao;
    private String nome_fantasia;
    private String cnes;
    private String cnpj;
    private String crbm;

    private List<Contato> con = new ArrayList<>();
    private Endereco end;
    private List<ResponsavelTecnico> res = new ArrayList<>();

    public Laboratorio(String descricao,String nome_fantasia, String cnes, String cnpj,String crbm){
        super();
        this.descricao =  descricao;
        this.nome_fantasia = nome_fantasia;
        this.cnes = cnes;
        this.cnpj = cnpj;
        this.crbm =  crbm;
    }

    public Laboratorio(Integer id, String descricao,String nome_fantasia, String cnes, String cnpj,String crbm){
        this.descricao =  descricao;
        this.nome_fantasia = nome_fantasia;
        this.cnes = cnes;
        this.cnpj = cnpj;
        this.crbm =  crbm;
        super.setId(id);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome_fantasia(String nome_fantasia) {

        this.nome_fantasia = nome_fantasia;
    }

    public void setCnes(String cnes) {

        this.cnes = cnes;
    }

    public void setCnpj(String cnpj) {

        this.cnpj = cnpj;
    }

    public void setCrbm(String crbm) {

        this.crbm = crbm;
    }

    //
    public String getDescricao(){
        return descricao;
    }

    public String getCnes() {
        return cnes;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCrbm() {
        return crbm;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    @Override
    public String toString() {
        return "Laboratorio {" +
                " id = '" + this.getId() + "\'" +
                ", descricao = '" + descricao + "\'" +
                ", nome_fantasia = " + nome_fantasia + "\'" +
                ", cnes = " + cnes + "\'" +
                ", cnpj = " + cnpj + "\'" +
                ", crbm = " + crbm +"\'" +
                '}';
    }


    public void setCon(Contato con) {
        this.con.add(con);
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }

    public void setRes(ResponsavelTecnico res) {
        this.res.add(res);
    }

    public List<Contato> getCon() {
        return con;
    }

    public Endereco getEnd() {
        return end;
    }

    public List<ResponsavelTecnico> getRes() {
        return res;
    }
}
