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
import model.Avaliacoes;
import model.Usuario;
import view.TelaAvaliacoes;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

public class ControleAvaliacao {

    private TelaAvaliacoes tela7;
    private Usuario usuario;

    public ControleAvaliacao(TelaAvaliacoes tela7, Usuario usuario) {
        this.tela7 = tela7;
        this.usuario = usuario;
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
            JOptionPane.showMessageDialog(tela7, "Digite um nome!");
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

            Avaliacoes a = new Avaliacoes(
                    usuario.getId(),
                    videoId,
                    valor
            );

            AvaliacoesDAO dao = new AvaliacoesDAO(conn);
            dao.avaliar(a);

            tela7.getLbl_descricao().setText("Você avaliou: " + nomeVideo);

            JOptionPane.showMessageDialog(tela7, "Avaliação salva!");

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

    public void buscarIdVideo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}