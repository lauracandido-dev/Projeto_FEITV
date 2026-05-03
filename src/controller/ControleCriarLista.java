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
import view.CriarLista; 

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

public class ControleCriarLista {

    private CriarLista tela9;
    private Usuario usuario;

    public ControleCriarLista(CriarLista tela9, Usuario usuario) {
        this.tela9 = tela9;
        this.usuario = usuario;
    }


    public void criarLista() {

        String nome = tela9.getTxt_nomeLista().getText();
        String descricao = tela9.getTxt_descricaoLista().getText();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(tela9, "Nome obrigatório!");
            return;
        }

        ListaReproducao lista = new ListaReproducao(nome, descricao, usuario.getId());

        Conexao conexao = new Conexao();

        try {
            Connection conn = conexao.getConnection();
            ListaReproducaoDAO dao = new ListaReproducaoDAO(conn);
            dao.inserir(lista);

            JOptionPane.showMessageDialog(tela9, "Lista criada com sucesso!");

            tela9.getTxt_nomeLista().setText("");
            tela9.getTxt_descricaoLista().setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela9, "Erro ao criar lista!");
            e.printStackTrace();
        }
    }
}