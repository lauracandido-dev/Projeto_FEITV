/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.LogadoUsuario;
import model.Usuario;
/**
 *
 * @author candi
 */
public class ControleLogado {
    private LogadoUsuario tela2;
    private Usuario usuario;

    public ControleLogado(LogadoUsuario tela2, Usuario usuario) {
        this.tela2 = tela2;
        this.usuario = usuario;
    }


    public Usuario chamarAlteracao(){
        return usuario;
    }

    public Usuario chamarExclusao(){
        return usuario;
        
    }
    
}
