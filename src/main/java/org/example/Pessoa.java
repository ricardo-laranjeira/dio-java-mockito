package org.example;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private String documento;
    private LocalDate nascimento;
    private DadosLocalizacao endereco;

    public Pessoa(String nome, String documento, LocalDate nascimento) {
        this.nome = nome;
        this.documento = documento;
        this.nascimento = nascimento;
    }

    public void adicionarDadosEndereco(DadosLocalizacao endereco){
        this.endereco = endereco;
    }

    public DadosLocalizacao getEndereco() {
        return this.endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

}
