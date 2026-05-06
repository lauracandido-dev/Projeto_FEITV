/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author candi
 */

import dao.AvaliacoesDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Video;
import view.TelaAvaliacoes;
import model.Usuario;

public class ControleAvaliacao {

    private TelaAvaliacoes tela7;
    private Usuario usuario;

    public ControleAvaliacao(TelaAvaliacoes tela7, Usuario usuario) {
        this.tela7 = tela7;
        this.usuario = usuario;
    }


    
    public void buscarVideoAvaliar() {

        String nome = tela7.getTxt_buscarVideo().getText(); //pega texto

        if (nome.isEmpty()) { //valida se digitou
            JOptionPane.showMessageDialog(tela7, "Digite o nome do vídeo!");
            return;
        }

        Conexao conexao = new Conexao(); //conexão com banco

        try {
            Connection conn = conexao.getConnection();

            Video video = new Video() {}; 
            video.setNomeVideo(nome);

            AvaliacoesDAO dao = new AvaliacoesDAO(conn); //chama o DAO
            ResultSet rs = dao.buscarVideoAvaliar(nome);

            if (rs.next()) {

                String nomeVideo = rs.getString("nomeVideo"); //verifica se encontrou
                String genero = rs.getString("genero");
                String classificacao = rs.getString("classificacao");

                tela7.getLbl_descricao().setText(
                    "Nome: " + nomeVideo +
                    " | Gênero: " + genero +
                    " | Classificação: " + classificacao
                );

            } else {
                JOptionPane.showMessageDialog(tela7, "Vídeo não encontrado!");
            }

            rs.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela7, "Erro ao buscar vídeo!");
        }
    }
    
        public void curtir() {
        avaliar(1);
    }

    public void descurtir() {
        avaliar(-1);
    }

    
    private void avaliar(int valor) {

        String nomeVideo = tela7.getTxt_buscarVideo().getText();

        if (nomeVideo.isEmpty()) {
            JOptionPane.showMessageDialog(tela7, "Digite o nome do vídeo!");
            return;
        }

        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();

            int videoId = buscarIdVideo(conn, nomeVideo);

            if (videoId == -1) {
                JOptionPane.showMessageDialog(tela7, "Vídeo não encontrado!");
                return;
            }

            AvaliacoesDAO dao = new AvaliacoesDAO(conn);
            dao.avaliar(usuario.getId(), videoId, valor);

            // 🎯 mensagem diferente para cada ação
            if (valor == 1) {
                tela7.getLbl_descricao().setText("Você curtiu: " + nomeVideo);
            } else {
                tela7.getLbl_descricao().setText("Você descurtiu: " + nomeVideo);
            }

            JOptionPane.showMessageDialog(tela7, "Ação registrada!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela7, "Erro ao avaliar!");
        }
    }

    private int buscarIdVideo(Connection conn, String nome) throws SQLException {

        String sql = "SELECT id FROM videos WHERE \"nomeVideo\" ILIKE ?";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome + "%");

        java.sql.ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        }

        return -1;
    }
}
