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
    private int videoId;
    private int avaliacao; // 1 = curtir, -1 = descurtir

    public Avaliacoes() {}

    public Avaliacoes(int usuarioId, int videoId, int avaliacao) {
        this.usuarioId = usuarioId;
        this.videoId = videoId;
        this.avaliacao = avaliacao;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
}