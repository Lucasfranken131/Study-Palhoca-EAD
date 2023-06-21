import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Array;
import java.util.Arrays;

class Tela extends JFrame{
    private static JTable table;
    private static DefaultTableModel tableModel;
    private static JFrame frame = new JFrame("Study Palhoça EAD.");

    public static void excluir_tabela(){
        try{
            table.removeAll();
        }catch (Exception e){}
    }
    private static void mostrarAluno() {
        // Cria um array com os dados da linha
        excluir_tabela();
        tableModel = new DefaultTableModel(new Object[]{"ID","Nome","Nascimento","Email","Senha","Cidade"}, 0);
        table = new JTable(tableModel);
        //O sort das linhas
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
        table.setRowSorter(sorter);

        // Adiciona uma barra de rolagem à tabela
        JScrollPane scrollPane = new JScrollPane(table);

        // Adiciona o scrollPane ao JFrame
        frame.add(scrollPane);
        String alunos=Salvar_aluno.pegar_conteudo();

        String[] array = alunos.split("\n");
        for (int i =0;i<array.length;i++) {

            String[] ar=array[i].split(",");
            Object[] mostrar={ar[0],ar[1],ar[2],ar[3],ar[4],ar[5]};
            tableModel.addRow(mostrar);
        }

    }

    private static void mostrarCidade(){
        excluir_tabela();
        tableModel = new DefaultTableModel(new Object[]{"ID", "Cidade","Estado"}, 0);
        table = new JTable(tableModel);
        //O sort das linhas
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
        table.setRowSorter(sorter);


        // Adiciona uma barra de rolagem à tabela
        JScrollPane scrollPane = new JScrollPane(table);

        // Adiciona o scrollPane ao JFrame
        frame.add(scrollPane);
        String alunos=Salvar_cidade.pegar_conteudo();

        String[] array = alunos.split("\n");
        for (int i =0;i<array.length;i++) {

            String[] ar=array[i].split(",");
            Object[] mostrar={ar[0],ar[1],ar[2]};
            tableModel.addRow(mostrar);
        }
    }

    public static void main(String[] args) {
        //Criação da tela

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        
        //Seleção do ícone da tela.
        ImageIcon image = new ImageIcon("EAD.png");
        frame.setIconImage(image.getImage());

        //Header e itens do header
        JMenuBar header = new JMenuBar();
        JMenu inserir = new JMenu("Inserir");
        JMenu editar = new JMenu("Editar");
        header.add(inserir);
        header.add(editar);
        frame.add(header);
        JMenuItem cidade = new JMenuItem("Inserir Cidade");
        JMenuItem aluno = new JMenuItem("Inserir Estudante");
        inserir.add(cidade);
        inserir.add(aluno);
        JMenuItem cidade_editar = new JMenuItem("Editar Cidade");
        JMenuItem aluno_editar = new JMenuItem("Editar Estudante");
        editar.add(cidade_editar);
        editar.add(aluno_editar);

        //Footer e itens do footer  
        JMenuBar footer = new JMenuBar();
        JLabel pesquisaTexto = new JLabel("Nome da ");
        JButton pesquisaSeleciona = new JButton("Cidade");
        
        /* Troca o texto do Texto ao lado do botão e do botão, vai servir para escolher se queremos procurar
        um Aluno ou uma Cidade */
        pesquisaSeleciona.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               if (pesquisaTexto.getText().equals("Nome da ")){
                    pesquisaTexto.setText("Nome do ");
                    pesquisaSeleciona.setText("Estudante");
                    mostrarAluno();
               }
               else{
                    pesquisaTexto.setText("Nome da ");
                    pesquisaSeleciona.setText("Cidade");
                    mostrarCidade();
               }
            }
        });
        
        //Ainda é os itens do footer
        footer.add(pesquisaTexto);
        footer.add(pesquisaSeleciona);
        JTextField barraPesquisa = new JTextField(20);
        JButton pesquisaButton = new JButton("Pesquisar");
        footer.add(barraPesquisa);
        footer.add(pesquisaButton);

        //Barras brancas dos lados
        JMenuBar bar = new JMenuBar();
        JLabel texto = new JLabel("            ");
        bar.add(texto);

        JMenuBar bar2 = new JMenuBar();
        JLabel texto2 = new JLabel("            ");
        bar2.add(texto2);

        //Posicionamento do header e footer
        frame.getContentPane().add(BorderLayout.NORTH, header);
        frame.getContentPane().add(BorderLayout.WEST, bar);
        frame.getContentPane().add(BorderLayout.EAST, bar2);
        frame.getContentPane().add(BorderLayout.SOUTH, footer);

        //Evento para Inserir uma cidade, leva para o arquivo CriarCidade.java
        ActionListener handler_cidade = new CriarCidade();
        cidade.addActionListener(handler_cidade);

        //Evento para Inserir um aluno, leva para CriarEstudante.java
        ActionListener handler_estudante = new CriarEstudante();
        aluno.addActionListener(handler_estudante);

        //Deixa em tela cheia e vísivel
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}


