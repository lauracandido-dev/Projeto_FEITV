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