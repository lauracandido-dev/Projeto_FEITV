/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author candi
 */
public class UsuDAO {
        private Connection conn;

    public UsuDAO(Connection conn) {
        this.conn = conn;
    }

    public ResultSet consultar(Usuario usuario) throws SQLException{
        String sql = "SELECT * FROM cadastros WHERE usuario = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void inserir(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO cadastros (usuario, senha, nome) VALUES ('"
                                 + usuario.getUsuario() + "', '" 
                                 + usuario.getSenha() + "', '"
                                 + usuario.getNome() + "')";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        
        conn.close();
    }

        
    public void atualizar(Usuario usuario) throws SQLException{
        String sql = "UPDATE cadastros SET senha =  ? WHERE usuario = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, usuario.getSenha());
        statement.setString(2, usuario.getUsuario());
        statement.execute();
        
        conn.close();
    }
    
    public void remover(Usuario usuario) throws SQLException{
        String sql = "DELETE FROM cadastros WHERE usuario = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        
        statement.setString(1, usuario.getUsuario());
        statement.execute();
        conn.close();
    }
}
