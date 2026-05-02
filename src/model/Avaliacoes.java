/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author candi
 */

public class Avaliacoes {
    private int id;
    private int usuarioId;
    private String nomeVideo;
    private Integer avaliacao; // Usando Integer para permitir null

    public Avaliacoes() {}

    public Avaliacoes(int usuarioId, String nomeVideo, Integer avaliacao) {
        this.usuarioId = usuarioId;
        this.nomeVideo = nomeVideo;
        this.avaliacao = avaliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNomeVideo() {
        return nomeVideo;
    }

    public void setNomeVideo(String nomeVideo) {
        this.nomeVideo = nomeVideo;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }
 
    
}