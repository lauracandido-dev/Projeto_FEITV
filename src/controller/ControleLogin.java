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
import view.LoginUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import dao.UsuDAO;
import view.LogadoUsuario;
//import view.LogadoUsuario;


public class ControleLogin{
    private LoginUsuario tela1;
    
    public ControleLogin(LoginUsuario tela1){
        this.tela1 = tela1;
    }
    
     public void loginAluno(){
        Usuario usuario = new Usuario(tela1.getTxt_usuario().getText(),tela1.getTxt_senha().getText(), null);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuDAO dao = new UsuDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if(res.next()){
                JOptionPane.showMessageDialog(tela1, "Login efetuado", "Aviso", 
                                                JOptionPane.INFORMATION_MESSAGE);
                String usuarioBanco = res.getString("usuario");
                String senha = res.getString("senha");
                String nome = res.getString("nome");
//                LogadoUsuario tela2 = new LogadoUsuario(new Usuario(usuarioBanco, senha, nome));
//                tela2.setVisible(true);
                tela1.setVisible(false);
            } else{;
                JOptionPane.showMessageDialog(tela1, "Login não efetuado", "Erro", 
                                                JOptionPane.ERROR_MESSAGE);
                
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(tela1, "Erro de conexão", "Erro", 
                                                JOptionPane.ERROR_MESSAGE);
        }
    }
}
