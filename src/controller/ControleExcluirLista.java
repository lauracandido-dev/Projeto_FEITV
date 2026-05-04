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
import dao.ListaReproducaoDAO;
import model.ListaReproducao;
import model.Usuario;
import view.TelaExcluirLista;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

public class ControleExcluirLista {

    private TelaExcluirLista tela11;
    private Usuario usuario;

    public ControleExcluirLista(TelaExcluirLista tela11, Usuario usuario) {
        this.tela11 = tela11;
        this.usuario = usuario;
    }

    public void excluirLista() {

        String nomeLista = tela11.getTxt_listaExcluir().getText();

        if (nomeLista.isEmpty()) {
            JOptionPane.showMessageDialog(tela11, "Digite o nome da lista!");
            return;
        }

        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();

            ListaReproducaoDAO dao = new ListaReproducaoDAO(conn);

            // 🔍 buscar lista
            ListaReproducao lista = dao.buscarPorNomeEUsuario(nomeLista, usuario.getId());

            if (lista == null) {
                JOptionPane.showMessageDialog(tela11, "Lista não encontrada!");
                return;
            }

            int resposta = JOptionPane.showConfirmDialog(
                    tela11,
                    "Tem certeza que deseja excluir a lista '" + nomeLista + "'?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta != JOptionPane.YES_OPTION) {
                return; // cancela
            }

            dao.excluir(lista.getId());

            JOptionPane.showMessageDialog(tela11, "Lista excluída com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela11, "Erro ao excluir lista!");
        }
    }
}
