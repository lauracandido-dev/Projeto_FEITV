/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author candi
 */
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import view.AlteracaoUsuario;
import model.Usuario;
import dao.UsuDAO;

public class ControleAlteracao {
    private AlteracaoUsuario tela4;
    private Usuario usuario;
    
    public ControleAlteracao(AlteracaoUsuario tela4, Usuario usuario){
        this.tela4 = tela4;
        this.usuario = usuario;
    }
    
    public void atualizar(){
        String senhaNova = tela4.getTxt_senhaNova().getText();
//        Usuario usuario = new Usuario(usuario, senhaNova, "");
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuDAO dao = new UsuDAO(conn);
            dao.atualizar(usuario);
            JOptionPane.showMessageDialog(tela4, "Senha de Usuário atualizada com Sucesso!", 
                                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(tela4, "Falha de conexão!", 
                                        "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
