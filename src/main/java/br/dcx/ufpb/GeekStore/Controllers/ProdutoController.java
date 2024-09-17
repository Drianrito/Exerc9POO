package br.dcx.ufpb.GeekStore.Controllers;

import br.dcx.ufpb.GeekStore.Roupa;
import br.dcx.ufpb.GeekStore.SistemaGeekStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoController implements ActionListener {

    private SistemaGeekStore sistemaGeekStore;
    private JFrame menuInicial;

    public ProdutoController(SistemaGeekStore sistemaGeek, JFrame menu){
        this.sistemaGeekStore = sistemaGeek;
        this.menuInicial = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(menuInicial,"Digite o nome do produto: ");
    }
}

