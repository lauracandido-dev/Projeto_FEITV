/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author candi
 */
import dao.UsuDAO;
import dao.Conexao;
import model.Usuario;
import view.CadastroUsuario;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleCadastro {
    private CadastroUsuario tela3;
    
    public ControleCadastro(CadastroUsuario tela3){
        this.tela3 = tela3;
    }
    
    public void salvarAluno(){
        String nome = tela3.getTxt_nome().getText();
        String usuario = tela3.getTxt_usuario().getText();
        String senha = tela3.getTxt_senha().getText();
        Usuario user = new Usuario(usuario,senha,nome); //construtor de cadastro
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuDAO dao = new UsuDAO(conn);
            dao.inserir(user);
            JOptionPane.showMessageDialog(tela3, "Usuario Cadastrado!","Aviso", 
                                        JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(tela3, "Usuário não cadastrado!","Erro", 
                                        JOptionPane.ERROR_MESSAGE);
        }
    }
}

