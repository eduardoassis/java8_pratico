package models;

public class Usuario {
    private String nome;
    private int idade;
    private boolean moderador;

    public Usuario(final String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.moderador = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}