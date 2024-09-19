package br.dcx.rian.controller;

import br.dcx.rian.SistemaLimpaCasas;
import br.dcx.rian.exception.DiaristaJaCadastradaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaCadastroDiaristaController implements ActionListener {
    private SistemaLimpaCasas sistemaLimpaCasas;
    private JFrame janelaPrincipal;

    public SistemaCadastroDiaristaController(SistemaLimpaCasas sistemaLimpaCasas, JFrame janelaPrincipal) {
        this.sistemaLimpaCasas = sistemaLimpaCasas;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal,"Digite nome da Diarista: ");
        String cpf = JOptionPane.showInputDialog(janelaPrincipal,"Digite o cpf da Diarista: ");
        String telefone = JOptionPane.showInputDialog(janelaPrincipal,"Digite o cpf da Diarista: ");
        boolean cadastro = false;
        try {
            cadastro = sistemaLimpaCasas.cadastraDiarista(nome,cpf,telefone);
        } catch (DiaristaJaCadastradaException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Diarista ja cadastrada");
        }
        if(cadastro){
            JOptionPane.showMessageDialog(janelaPrincipal,"Cadastrou a Diarista");
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal,"Ocorreu um erro tente novamente");
        }
    }
}
