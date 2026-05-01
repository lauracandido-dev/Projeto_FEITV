/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author candi
 */

import java.sql.*;
import model.Avaliacoes;

public class AvaliacoesDAO {

    private Connection conn;

    public AvaliacoesDAO(Connection conn) {
        this.conn = conn;
    }

    public void avaliar(Avaliacoes a) throws SQLException {

        String sqlCheck = "SELECT * FROM avaliacoes WHERE usuario_id = ? AND video_id = ?";
        PreparedStatement check = conn.prepareStatement(sqlCheck);
        check.setInt(1, a.getUsuarioId());
        check.setInt(2, a.getVideoId());

        ResultSet rs = check.executeQuery();

        if (rs.next()) {
            // UPDATE
            String sqlUpdate = "UPDATE avaliacoes SET avaliacao = ? WHERE usuario_id = ? AND video_id = ?";
            PreparedStatement update = conn.prepareStatement(sqlUpdate);
            update.setInt(1, a.getAvaliacao());
            update.setInt(2, a.getUsuarioId());
            update.setInt(3, a.getVideoId());
            update.execute();
        } else {
            // INSERT
            String sqlInsert = "INSERT INTO avaliacoes (usuario_id, video_id, avaliacao) VALUES (?, ?, ?)";
            PreparedStatement insert = conn.prepareStatement(sqlInsert);
            insert.setInt(1, a.getUsuarioId());
            insert.setInt(2, a.getVideoId());
            insert.setInt(3, a.getAvaliacao());
            insert.execute();
        }

        conn.close();
    }
}