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
import view.TelaAtualizarLista;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

public class ControleEditarLista {

    private TelaAtualizarLista tela10;
    private Usuario usuario;

    public ControleEditarLista(TelaAtualizarLista tela10, Usuario usuario) {
        this.tela10 = tela10;
        this.usuario = usuario;
    }

    public void alterarNomeLista() {

        String nomeAtual = tela10.getTxt_antigoNome().getText();
        String novoNome = tela10.getTxt_novoNome().getText();

        if (nomeAtual.isEmpty() || novoNome.isEmpty()) {
            JOptionPane.showMessageDialog(tela10, "Preencha todos os campos!");
            return;
        }

        try {
            Conexao conexao = new Conexao();
            Connection conn = conexao.getConnection();

            ListaReproducaoDAO dao = new ListaReproducaoDAO(conn);

            ListaReproducao lista = dao.buscarPorNomeEUsuario(nomeAtual, usuario.getId());

            if (lista == null) {
                JOptionPane.showMessageDialog(tela10, "Lista não encontrada!");
                return;
            }

            dao.atualizarNome(lista.getId(), novoNome);

            JOptionPane.showMessageDialog(tela10, "Nome da lista atualizado com sucesso!");
            tela10.dispose();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela10, "Erro ao atualizar lista!");
        }
    }
}