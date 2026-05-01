/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author candi
 */
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Video;
import dao.VideoDAO;
import model.Usuario;
import view.BuscarVideo;

public class ControleBuscar {

    private BuscarVideo view;
    private VideoDAO dao;
    private Usuario userLogado;

    public ControleBuscar(BuscarVideo view) {
        this.view = view;
        this.dao = new VideoDAO();
    }
    


    public void acaoPesquisar() {
        String termo = view.getTxt_buscar().getText();

        if (termo.isEmpty()) {
            limparLabels();
            return;
        }

        try {
            List<Video> resultados = dao.buscarVideos(termo);
            if (!resultados.isEmpty()) {
                Video v = resultados.get(0);
                view.getLbl_nome().setText("Nome: " + v.getNomeVideo());
                view.getLbl_genero().setText("Gênero: " + v.getGenero());
                view.getLbl_classificacao().setText("Classificação: " + v.getClassificacao());
                view.getLbl_sinopse().setText("Sinopse: " + v.getSinopse());

            } else {
                view.getLbl_nome().setText("Sinto muito, mas não temos esse título!");
                view.getLbl_genero().setText("");
                view.getLbl_classificacao().setText("");
                view.getLbl_sinopse().setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar: " + e.getMessage());
        }
    }

    private void limparLabels() {
        view.getLbl_nome().setText("Nome");
        view.getLbl_genero().setText("Gênero");
        view.getLbl_classificacao().setText("Classificação");
        view.getLbl_sinopse().setText("Sinopse");
    }

}
