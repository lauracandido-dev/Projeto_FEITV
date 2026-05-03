/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author candi
 */
public class ListaReproducao {
    private int id;
    private String nome, descricao;
    private int usuarioId;

    public ListaReproducao() {
    }

    public ListaReproducao(String nome, String descricao, int usuarioId) {
        this.nome = nome;
        this.descricao = descricao;
        this.usuarioId = usuarioId;
    }

    public ListaReproducao(int id, String nome, String descricao, int usuarioId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    
    
}
