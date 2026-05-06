/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author candi
 */
import dao.Conexao;
import dao.ListaReproducaoDAO;
import dao.VideoDAO;
import model.ListaReproducao;
import model.Usuario;
import view.TelaGerenciarListas;

import javax.swing.JOptionPane;
import java.sql.Connection;
import model.Video;

public class ControleGerenciarListas {

    private TelaGerenciarListas tela12;
    private Usuario usuario;

    public ControleGerenciarListas(TelaGerenciarListas tela12, Usuario usuario) {
        this.tela12 = tela12;
        this.usuario = usuario;
    }

    public void buscarVideo() {
        String nomeVideo = tela12.getTxt_nomeVideo().getText();

        tela12.getLbl_nome().setText("");
        tela12.getLbl_genero().setText("");
        tela12.getLbl_classificacao().setText("");
        tela12.getLbl_resultado().setText("");
        
        
        if (nomeVideo.isEmpty()) {
            JOptionPane.showMessageDialog(tela12, "Digite o nome do vídeo!");
            return;
        }

        try {
            Connection conn = new Conexao().getConnection();
            VideoDAO videoDAO = new VideoDAO(conn);

            Video video = videoDAO.buscarVideoPorNome(nomeVideo);

            if (video == null) {
                tela12.getLbl_resultado().setText("Vídeo não encontrado!");
            } else {
                tela12.getLbl_nome().setText("Nome: " + video.getNomeVideo());
                tela12.getLbl_genero().setText("Gênero: " + video.getGenero());
                tela12.getLbl_classificacao().setText("Classificação: " + video.getClassificacao());
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela12, "Erro ao buscar vídeo!");
        }
    }

    public void adicionarVideoNaLista() {
        String nomeLista = tela12.getTxt_nomeLista().getText();
        String nomeVideo = tela12.getTxt_nomeVideo().getText();

        if (nomeLista.isEmpty() || nomeVideo.isEmpty()) {
            JOptionPane.showMessageDialog(tela12, "Preencha todos os campos!");
            return;
        }

        try {
            Connection conn = new Conexao().getConnection();

            ListaReproducaoDAO listaDAO = new ListaReproducaoDAO(conn);
            VideoDAO videoDAO = new VideoDAO(conn);

            ListaReproducao lista = listaDAO.buscarPorNomeEUsuario(nomeLista, usuario.getId());
            int videoId = videoDAO.buscarIdPorNome(nomeVideo);

            if (lista == null) {
                JOptionPane.showMessageDialog(tela12, "Lista não encontrada!");
                return;
            }

            if (videoId == -1) {
                JOptionPane.showMessageDialog(tela12, "Vídeo não encontrado!");
                return;
            }

            listaDAO.adicionarVideo(lista.getId(), videoId);

            JOptionPane.showMessageDialog(tela12, "Vídeo adicionado!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela12, "Erro ao adicionar!");
        }
    }

    public void removerVideoDaLista() {
        String nomeLista = tela12.getTxt_nomeLista().getText();
        String nomeVideo = tela12.getTxt_nomeVideo().getText();

        if (nomeLista.isEmpty() || nomeVideo.isEmpty()) {
            JOptionPane.showMessageDialog(tela12, "Preencha todos os campos!");
            return;
        }

        try {
            Connection conn = new Conexao().getConnection();

            ListaReproducaoDAO listaDAO = new ListaReproducaoDAO(conn);
            VideoDAO videoDAO = new VideoDAO(conn);

            ListaReproducao lista = listaDAO.buscarPorNomeEUsuario(nomeLista, usuario.getId());
            int videoId = videoDAO.buscarIdPorNome(nomeVideo);

            if (lista == null) {
                JOptionPane.showMessageDialog(tela12, "Lista não encontrada!");
                return;
            }

            if (videoId == -1) {
                JOptionPane.showMessageDialog(tela12, "Vídeo não encontrado!");
                return;
            }

            listaDAO.removerVideo(lista.getId(), videoId);

            JOptionPane.showMessageDialog(tela12, "Vídeo removido!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela12, "Erro ao remover!");
        }
    }
}
