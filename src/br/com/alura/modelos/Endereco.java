package br.com.alura.modelos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Endereco implements Serializable {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    @SerializedName("uf")
    private String estado;

    public Endereco(String cep, String logradouro, String bairro, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
