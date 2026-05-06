/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuDAO;
import javax.swing.JOptionPane;
import model.Usuario;
import view.ExclusaoUsuario;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author candi
 */
public class ControleExclusao {

    private ExclusaoUsuario tela5;
    private Usuario usuario;

    public ControleExclusao(ExclusaoUsuario tela5, Usuario usuario) {
        this.tela5 = tela5;
        this.usuario = usuario;
    }

    public void remover() {
        int option = JOptionPane.showConfirmDialog(
                tela5,
                "Você realmente deseja excluir o cadastro?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (option == JOptionPane.YES_OPTION) {
            Conexao conexao = new Conexao();
            try {
                Connection conn = conexao.getConnection();
                UsuDAO dao = new UsuDAO(conn);
                dao.remover(usuario);

                JOptionPane.showMessageDialog(tela5,
                        "Usuário removido!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                        tela5.dispose();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(tela5,
                        "Falha na conexão",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
