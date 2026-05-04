/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author candi
 */
import model.ListaReproducao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListaReproducaoDAO {

    private Connection conn;

    public ListaReproducaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(ListaReproducao lista) throws SQLException {
        String sql = "INSERT INTO listaReproducao (nomeLista, descricaoLista, usuario_id) VALUES (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, lista.getNome());
        stmt.setString(2, lista.getDescricao());
        stmt.setInt(3, lista.getUsuarioId());

        stmt.executeUpdate();
        stmt.close();
    }

    public void atualizarNome(int id, String novoNome) throws SQLException {
        String sql = "UPDATE listaReproducao SET nomeLista = ? WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoNome);
        stmt.setInt(2, id);

        stmt.executeUpdate();
        stmt.close();
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM listaReproducao WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        stmt.executeUpdate();
        stmt.close();
    }

    public List<ListaReproducao> listarPorUsuario(int idUsuario) throws SQLException {
        List<ListaReproducao> listas = new ArrayList<>();

        String sql = "SELECT * FROM listaReproducao WHERE usuario_id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ListaReproducao lista = new ListaReproducao(
                    rs.getInt("id"),
                    rs.getString("nomeLista"),
                    rs.getString("descricaoLista"),
                    rs.getInt("usuario_id")
            );

            listas.add(lista);
        }

        rs.close();
        stmt.close();

        return listas;
    }

    public ListaReproducao buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM listaReproducao WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new ListaReproducao(
                    rs.getInt("id"),
                    rs.getString("nomeLista"),
                    rs.getString("descricaoLista"),
                    rs.getInt("usuario_id")
            );
        }

        rs.close();
        stmt.close();

        return null;
    }

    public ListaReproducao buscarPorNomeEUsuario(String nome, int usuarioId) throws SQLException {
        String sql = "SELECT * FROM listaReproducao WHERE nomeLista = ? AND usuario_id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, usuarioId);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new ListaReproducao(
                    rs.getInt("id"),
                    rs.getString("nomeLista"),
                    rs.getString("descricaoLista"),
                    rs.getInt("usuario_id")
            );
        }

        rs.close();
        stmt.close();

        return null;
    }

    public void adicionarVideo(int listaId, int videoId) throws SQLException {
        String sql = "INSERT INTO listavideo (lista_id, video_id) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, listaId);
        stmt.setInt(2, videoId);

        stmt.executeUpdate();
        stmt.close();
    }

    public void removerVideo(int listaId, int videoId) throws SQLException {
        String sql = "DELETE FROM listavideo WHERE lista_id = ? AND video_id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, listaId);
        stmt.setInt(2, videoId);

        stmt.executeUpdate();
        stmt.close();
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
}
