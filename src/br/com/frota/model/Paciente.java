package br.com.frota.model;

import java.util.Date;

public class Paciente extends GenericModel{
    private String nome;
    private Date dtNascimento;

    public Paciente(String nome, Date dtNascimento){
        this.nome = nome;
        this.dtNascimento = dtNascimento;
    }

    public Paciente(Integer id, String nome, Date dtNascimento){
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        super.setId(id);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getNome() {
        return nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    @Override
    public String toString() {
        return "Paciente {" +
                "id ='" + this.getId() + "\'" +
                "nome ='" + nome + "\'" +
                "dt_nascimento =" + dtNascimento + "\'" +
                '}';
    }
}