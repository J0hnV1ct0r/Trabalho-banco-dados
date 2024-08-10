package br.com.frota.model;

import java.util.ArrayList;
import java.util.List;

public class Medico extends GenericModel{
    private String nome;
    private String crm;

    private List<Especialidade> esp = new ArrayList<>();

    public Medico(String nome, String crm){
        this.nome = nome;
        this.crm = crm;
    }

    public Medico(int id,String nome, String crm){
        this.nome = nome;
        this.crm = crm;
        super.setId(id);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    //


    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;

    }

    @Override
    public String toString() {
        return "Medico {" +
                "id='" + this.getId() + "\'" +
                "nome ='" + nome  + "\'" +
                "crm ='" + crm  + "\'" +
                '}';
    }

    public void setEsp(Especialidade esp) {
         this.esp.add(esp);
    }

    public List<Especialidade> getEsp() {
        return esp;
    }
}