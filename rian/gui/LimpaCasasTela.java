package br.dcx.rian.gui;

import br.dcx.rian.Endereco;
import br.dcx.rian.Moradia;
import br.dcx.rian.SistemaLimpaCasas;
import br.dcx.rian.controller.SistemaCadastroDiaristaController;
import br.dcx.rian.exception.CasaJaExisteException;
import br.dcx.rian.exception.DiaristaNaoEncontradaException;

import javax.swing.*;
import java.awt.*;


public class LimpaCasasTela extends JFrame {
    JLabel linha1, linha2;
    ImageIcon limpeza = new ImageIcon();
    SistemaLimpaCasas sistema = new SistemaLimpaCasas();
    JMenuBar barraDeMenu = new JMenuBar();
    public LimpaCasasTela(){
        setTitle("Limpa Casas");
        setSize(800,900);
        setLocation(150,150);
        setResizable(true);
        setBackground(Color.LIGHT_GRAY);
        linha1 = new JLabel("Numero 1 em Diaristas");
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(limpeza, JLabel.CENTER);
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuDiarista = new JMenu("Diarista");
            JMenuItem menuCadastrarDiarista = new JMenuItem(
                "Cadastrar Diarista");
        menuDiarista.add(menuCadastrarDiarista);
        menuCadastrarDiarista.addActionListener(new SistemaCadastroDiaristaController(sistema,this));
        JMenuItem menuRemoveDiarista = new JMenuItem(
                "Remover Diarista");
        menuRemoveDiarista.addActionListener(
                (ae) -> {
                    String cpf = JOptionPane.showInputDialog(this,
                            "Qual cpf da diarista que deseja remover ?");
                    try {
                        sistema.removerDiaristaPorCPF(cpf);
                    } catch (DiaristaNaoEncontradaException e) {
                        e.printStackTrace();
                    }
                });
        JMenu menuMoradia = new JMenu("Moradia");
            JMenuItem menuCadastrarMoradia = new JMenuItem("Cadastrar Moradia");
            menuMoradia.add(menuCadastrarMoradia);
        menuCadastrarMoradia.addActionListener(
                (ae) -> {
                    String nomeProprietario = JOptionPane.showInputDialog(this,
                            "Qual nome do proprietario ?");
                    String cpfProprietario = JOptionPane.showInputDialog(this,
                            "Qual cpf do proprietario ?");
                    String cidade = JOptionPane.showInputDialog(this,
                            "Qual a cidade ?");
                    String rua = JOptionPane.showInputDialog(this,
                            "Qual a rua da moradia ?");
                    String bairro = JOptionPane.showInputDialog(this,
                            "Qual nome do bairro?");
                    String numeroCasa = JOptionPane.showInputDialog(this,
                            "Qual Numero da Casa ?");
                    Endereco endereco = new Endereco(rua,bairro,cidade,numeroCasa);
                    Moradia dono = new Moradia(nomeProprietario,cpfProprietario,endereco);
                    try {
                        sistema.cadastrarMoradia(dono, endereco);
                    } catch (CasaJaExisteException e) {
                        JOptionPane.showMessageDialog(this,"Ja existe Moradia do mesmo endereco e Proprietario");
                    }
                });
                JMenuItem menuRemoverMoradia = new JMenuItem("Remover Moradia");
        menuMoradia.add(menuRemoverMoradia);
        menuRemoverMoradia.addActionListener(
                (ae) -> {
                    String cpfProprietario = JOptionPane.showInputDialog(this,
                            "Qual cpf do proprietario ?");
                    String rua = JOptionPane.showInputDialog(this,
                            "Qual a rua da moradia ?");
                    String numeroCasa = JOptionPane.showInputDialog(this,
                            "Qual Numero da Casa ?");
                    Endereco endereco = new Endereco(rua,"","",numeroCasa);
                    sistema.removerMoradia(cpfProprietario,endereco);
                });
        menuDiarista.add(menuRemoveDiarista);
        barraDeMenu.add(menuDiarista);
        barraDeMenu.add(menuMoradia);
        setJMenuBar(barraDeMenu);
    }
    public static void main(String[] args) {
        JFrame janela = new LimpaCasasTela();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
