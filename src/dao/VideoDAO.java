/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author candi
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Filme;
import model.Serie;

import model.Video;

public class VideoDAO {

    private Connection conn;

    public VideoDAO(Connection conn) {
        this.conn = conn;
    }

    public int buscarIdPorNome(String nome) throws SQLException {
        String sql = "SELECT id FROM videos WHERE \"nomeVideo\" ILIKE ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + nome + "%"); //procura o video mesmo incompleto

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        }

        return -1;
    }

    public Video buscarVideoPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM videos WHERE \"nomeVideo\" ILIKE ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + nome + "%");

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            String tipo = rs.getString("tipo");

            if (tipo.equalsIgnoreCase("filme")) {

                Filme f = new Filme();
                f.setId(rs.getInt("id"));
                f.setNomeVideo(rs.getString("nomeVideo"));
                f.setGenero(rs.getString("genero"));
                f.setClassificacao(rs.getString("classificacao"));
                f.setSinopse(rs.getString("sinopse"));
                f.setDuracao(rs.getInt("duracao"));

                return f;

            } else if (tipo.equalsIgnoreCase("serie")) {

                Serie s = new Serie();
                s.setId(rs.getInt("id"));
                s.setNomeVideo(rs.getString("nomeVideo"));
                s.setGenero(rs.getString("genero"));
                s.setClassificacao(rs.getString("classificacao"));
                s.setSinopse(rs.getString("sinopse"));
                s.setTemporadas(rs.getInt("temporada"));
                s.setEpisodios(rs.getInt("episodios"));

                return s;
            }
        }

        return null;
    }

    public List<Video> buscarVideos(String termo) throws SQLException {
        String sql = "SELECT * FROM videos WHERE \"nomeVideo\" ILIKE ?";
        List<Video> lista = new ArrayList<>();

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + termo + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            String tipo = rs.getString("tipo");

            if (tipo.equalsIgnoreCase("filme")) {

                Filme f = new Filme();
                f.setNomeVideo(rs.getString("nomeVideo"));
                f.setGenero(rs.getString("genero"));
                f.setClassificacao(rs.getString("classificacao"));
                f.setSinopse(rs.getString("sinopse"));
                f.setDuracao(rs.getInt("duracao"));

                lista.add(f);

            } else {

                Serie s = new Serie();
                s.setNomeVideo(rs.getString("nomeVideo"));
                s.setGenero(rs.getString("genero"));
                s.setClassificacao(rs.getString("classificacao"));
                s.setSinopse(rs.getString("sinopse"));
                s.setTemporadas(rs.getInt("temporada"));
                s.setEpisodios(rs.getInt("episodios"));

                lista.add(s);
            }
        }
        return lista;
    }
}
