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
import java.sql.SQLException;
import java.sql.PreparedStatement;
import model.Video;

public class AvaliacoesDAO {
    private Connection conn;

    public AvaliacoesDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet buscarVideoAvaliar(String nome) throws SQLException {
        String sql = "SELECT * FROM videos WHERE \"nomeVideo\" ILIKE ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nome + "%");
        return statement.executeQuery();
    }

    public void avaliar(int usuarioId, int videoId, int avaliacao) throws SQLException {

        String sqlCheck = "SELECT * FROM avaliacoes WHERE usuario_id = ? AND video_id = ?";
        PreparedStatement check = conn.prepareStatement(sqlCheck);
        check.setInt(1, usuarioId);
        check.setInt(2, videoId);

        ResultSet rs = check.executeQuery();

        if (rs.next()) {

            String sqlUpdate = "UPDATE avaliacoes SET avaliacao = ? "
                    + "WHERE usuario_id = ? AND video_id = ?";

            PreparedStatement update = conn.prepareStatement(sqlUpdate);
            update.setInt(1, avaliacao);
            update.setInt(2, usuarioId);
            update.setInt(3, videoId);
            update.execute();

        } else {

            String sqlInsert = "INSERT INTO avaliacoes (usuario_id, video_id, avaliacao) VALUES (?, ?, ?)";

            PreparedStatement insert = conn.prepareStatement(sqlInsert);
            insert.setInt(1, usuarioId);
            insert.setInt(2, videoId);
            insert.setInt(3, avaliacao);
            insert.execute();
        }

        conn.close();
    }
}