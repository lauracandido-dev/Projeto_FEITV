/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author candi
 */

public class Serie extends Video {
    private int temporadas;
    private int episodios;

    public Serie() {}

    public Serie(int temporadas, int episodios) {
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    public Serie(int temporadas, int episodios, String nomeVideo, String genero, String classificacao, String sinopse, int id, String tipo) {
        super(nomeVideo, genero, classificacao, sinopse, id, tipo);
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    
    

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }
}