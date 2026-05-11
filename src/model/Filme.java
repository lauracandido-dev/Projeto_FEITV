/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author candi
 */

public class Filme extends Video {
    private int duracao;

    public Filme() {}

    public Filme(int duracao) {
        this.duracao = duracao;
    }

    public Filme(int duracao, String nomeVideo, 
            String genero, String classificacao, 
            String sinopse, int id, String tipo) {
        super(nomeVideo, genero, classificacao, sinopse, id, tipo);
        this.duracao = duracao;
    }

    

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}