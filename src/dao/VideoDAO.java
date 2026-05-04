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

import model.Video;

public class VideoDAO {

    private Connection conn;

    public VideoDAO(Connection conn) {
        this.conn = conn;
    }

    public int buscarIdPorNome(String nome) throws SQLException {
        String sql = "SELECT id FROM videos WHERE \"nomeVideo\" ILIKE ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        }

        return -1;
    }

    public Video buscarVideoPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM videos WHERE \"nomeVideo\" ILIKE ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Video v = new Video();
            v.setId(rs.getInt("id"));
            v.setNomeVideo(rs.getString("nomeVideo"));
            v.setGenero(rs.getString("genero"));
            v.setClassificacao(rs.getString("classificacao"));

            return v;
        }

        return null;
    }

    public List<Video> buscarVideos(String termo) throws SQLException {
        String sql = "SELECT * FROM videos WHERE \"nomeVideo\" ILIKE ?";
        List<Video> lista = new ArrayList<>();

        Conexao conexao = new Conexao();
        Connection conn = conexao.getConnection();

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, termo + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Video v = new Video();
            v.setNomeVideo(rs.getString("nomeVideo"));
            v.setGenero(rs.getString("genero"));
            v.setClassificacao(rs.getString("classificacao"));
            v.setSinopse(rs.getString("sinopse"));
            lista.add(v);
        }

        rs.close();
        stmt.close();
        conn.close();

        return lista;
    }
}
