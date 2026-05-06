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
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Video;
import model.Filme;
import model.Serie;
import dao.VideoDAO;
import model.Usuario;
import view.BuscarVideo;
import java.sql.Connection;

public class ControleBuscar {

    private BuscarVideo view;
    private VideoDAO dao;
    private Usuario userLogado;

    public ControleBuscar(BuscarVideo view) {
        this.view = view;

        try {
            Connection conn = new Conexao().getConnection();
            this.dao = new VideoDAO(conn);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Erro ao conectar com o banco!");
        }
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
                view.getTxtA_Sinopse().setText("Sinopse: " + v.getSinopse());

                if (v instanceof Filme) {
                    Filme f = (Filme) v;
                    view.getLbl_infos().setText("Duração: " + f.getDuracao() + " min");

                } else if (v instanceof Serie) {
                    Serie s = (Serie) v;
                    view.getLbl_infos().setText(
                            "Temporadas: " + s.getTemporadas()
                            + " | Episódios: " + s.getEpisodios()
                    );
                }

            } else {
                view.getLbl_nome().setText("Sinto muito, mas não temos esse título!");
                view.getLbl_genero().setText("");
                view.getLbl_classificacao().setText("");
                view.getTxtA_Sinopse().setText("");
                view.getLbl_infos().setText("");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar: " + e.getMessage());
        }
    }

    private void limparLabels() {
        view.getLbl_nome().setText(" ");
        view.getLbl_genero().setText(" ");
        view.getLbl_classificacao().setText(" ");
        view.getLbl_infos().setText(" ");
        view.getTxtA_Sinopse().setText(" ");

    }

}
