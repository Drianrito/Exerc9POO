package br.dcx.ufpb.GeekStore.GUI;

import br.dcx.ufpb.GeekStore.Controllers.ProdutoController;
import br.dcx.ufpb.GeekStore.Roupa;
import br.dcx.ufpb.GeekStore.SistemaGeekStore;

import javax.swing.*;
import java.awt.*;

public class PogramaGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon iconeApp = new ImageIcon("./imgs/images.png");
    JButton botaoNovoProduto, botaoPesquisar, botaoRemover;
    SistemaGeekStore sistema = new SistemaGeekStore();
    public PogramaGUI(){
        setTitle("Agenda de Aniversario");
        setSize(800,800);
        setLocation(150,150);
        setResizable(true);
        getContentPane().setBackground(Color.lightGray);
        linha1 = new JLabel("Loja do momento em Cultura Geek",JLabel.CENTER);
        linha2 = new JLabel(iconeApp,JLabel.CENTER);
        botaoPesquisar = new JButton();
        botaoNovoProduto = new JButton("Produto");
        botaoNovoProduto.addActionListener(new ProdutoController(sistema,this));
        botaoRemover = new JButton();
        setLayout(new GridLayout(3,3));
        add(new JLabel());
        add(linha1);
        add(new JLabel());
        add(new JLabel());
        add(linha2);
        add(new JLabel());
        add(botaoNovoProduto);
        add(botaoPesquisar);
        add(botaoRemover );
    }

    public static void main(String[] args) {
        JFrame janela = new PogramaGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
