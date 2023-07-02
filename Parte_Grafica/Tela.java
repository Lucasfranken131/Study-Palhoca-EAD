import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

class Tela extends JFrame{
    static Boolean MostrandoAluno;
    private static final JFrame frame = new JFrame("Study Palhoça EAD.");
    static JTextField barraPesquisa = new JTextField(20);
    private static JPanel panel;
    private static JTable tabela;
    private static boolean salvarAluno = true;
    public static void remover(){
        panel.remove(new JScrollPane(tabela));//remove a tabela do painel
        frame.remove(panel);//remove o painel do frame
        frame.revalidate(); // Atualizar o JPanel
        frame.repaint(); // Atualiza o frame, sem o .revalidate e o .repaint juntos não funciona
    }
    //Mostra os alunos
    public static void MostrarAluno(){
        panel = new JPanel(new BorderLayout());
        String alunos=Salvar_aluno.pegar_conteudo();

        String[] array = alunos.split("\n");
        //Matriz com quantidade de linha variável
        Object[][] dados = new Object[array.length][7];
        //Lógica para salvar na matriz os dados dos alunos
        for (int i = 0; i < array.length; i++) {
            String[] ar=array[i].split(",");
            for (int j = 0; j < 7; j++) {
                dados[i][j]= ar[j];
            }
        }
        //Nome das tabelas
        String[] colunas = {"ID","Nome","Nascimento","Email","Senha","Cidade","Bolsista"};
        //Adiciona os dados na tabela
        tabela = new JTable(dados, colunas);
        //Configurações para a tabela funcionar
        panel.add(new JScrollPane(tabela), BorderLayout.CENTER);
        frame.add(panel);
        frame.revalidate(); // Atualizar o JPanel
        frame.repaint();
    }
    //Mostra as cidades
    public static void MostrarCidade(){
        panel = new JPanel(new BorderLayout());
        String alunos=Salvar_cidade.pegar_conteudo();

        String[] array = alunos.split("\n");

        //Matriz com quantidade de linha variável
        Object[][] dados = new Object[array.length][3];

        //Lógica para salvar na matriz os dados das cidades
        for (int i = 0; i < array.length; i++) {
            String[] ar=array[i].split(",");
            for (int j = 0; j < 3; j++) {
                dados[i][j]= ar[j];
            }
        }
        //Nome das tabelas
        String[] colunas = {"id", "cidade","estado"};
        //Adiciona os dados na tabela
        tabela = new JTable(dados, colunas);
        //Configurações para a tabela funcionar
        panel.add(new JScrollPane(tabela), BorderLayout.CENTER);
        frame.add(panel);
        frame.revalidate(); // Atualizar o JPanel
        frame.repaint();
    }


    public static void salvarAlteracoes() {
        try {
            FileWriter arquivoEscrita;
            BufferedWriter escritor;

            if (salvarAluno) {
                arquivoEscrita = new FileWriter("Salvar/db/db_aluno.txt");
            } else {
                arquivoEscrita = new FileWriter("Salvar/db/db_cidade.txt");
            }

            escritor = new BufferedWriter(arquivoEscrita);

            // Obtém o modelo da tabela atual
            TableModel tableModel = tabela.getModel();

            // Percorre todas as linhas da tabela e salva os dados no arquivo
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                Object[] rowData = new Object[tableModel.getColumnCount()];
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    rowData[j] = tableModel.getValueAt(i, j);
                }
                String linha = String.join(",", Arrays.copyOf(rowData, rowData.length, String[].class));
                escritor.write(linha);
                escritor.newLine();
            }

            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void MostrarCidadePesquisada(String cidades){
        //Caso a resposta venha vazia, mostra todas as cidades e trava a função
        if(cidades.isEmpty()){
            remover();
            MostrarCidade();
            return;
        }
        //Remove oque está na tabela para ser reescrita
        remover();
        panel = new JPanel(new BorderLayout());
        String[] array = cidades.split("\n");

        //Lógica para mostrar as cidades correspondentes a pesquisa

        Object[][] dados = new Object[array.length][3];

        for (int i = 0; i < array.length; i++) {
            String[] ar=array[i].split(",");
            for (int j = 0; j < 3; j++) {
                dados[i][j]= ar[j];
            }
        }
        // Configurar a tabela
        String[] colunas = {"id", "cidade","estado"};
        tabela = new JTable(dados, colunas);
        panel.add(new JScrollPane(tabela), BorderLayout.CENTER);
        frame.add(panel);
        frame.revalidate(); // Atualizar o JPanel
        frame.repaint();
    }
    public static void MostrarAlunoPesquisado(String alunos){
        //Caso a resposta venha vazia, mostra todos os alunos e trava a função
        if(alunos.isEmpty()){
            remover();
            MostrarAluno();
            return;
        }
        //Remove oque está na tabela para ser reescrita
        remover();
        panel = new JPanel(new BorderLayout());

        //Lógica para mostrar os alunos correspondentes a pesquisa
        String[] array = alunos.split("\n");
        Object[][] dados = new Object[array.length][7];

        for (int i = 0; i < array.length; i++) {
            String[] ar=array[i].split(",");
            for (int j = 0; j < 7; j++) {
                dados[i][j]= ar[j];
            }
        }

        // Configurar a tabela
        String[] colunas = {"ID","Nome","Nascimento","Email","Senha","Cidade","Bolsista"};
        tabela = new JTable(dados, colunas);
        panel.add(new JScrollPane(tabela), BorderLayout.CENTER);
        frame.add(panel);
        frame.revalidate(); // Atualizar o JPanel
        frame.repaint();
    }

    //Está como return Object ,pois estava com bugs apenas com o void ,motivo desconhecido.
    public static Object pesquisar(){
        //Pega oque foi digitado
        String pesquisando = barraPesquisa.getText();
        String[] pesquisa = pesquisando.split("");
        //Caso nao seja os alunos que estão na tela, entra nesse if
        if(!MostrandoAluno){
            String cidades_mostrar="";
            //Pega o conteúdo das cidades
            String[] cidades = Salvar_cidade.pegar_conteudo().split("\n");
            //Lógica para testar se oque foi digitado é igual o nome das cidades existentes
            for(int i=0;i<cidades.length;i++){
                String[] cidade=cidades[i].split(",");
                String[] nome_cidade=cidade[1].split("");
                boolean igual=true;
                for(int j =0;j<pesquisa.length;j++){
                    try{
                        if(nome_cidade[j]!=null && pesquisa[j].equalsIgnoreCase(nome_cidade[j]) && igual){
                        }else{
                            igual=false;
                        }
                    }catch (Exception e){}
                }
                if(igual){
                    //Caso oque foi digitado e o nome da cidade seja igual, o conteúdo é pego e salvo
                    cidades_mostrar+=Salvar_cidade.buscar_cidade_por_codigo(cidade[0])+"\n";
                }
            }
            //Roda a função para mostrar na tela
            MostrarCidadePesquisada(cidades_mostrar);

        }else{
            //Caso seja os alunos que estão na tela, roda esta parte.
            //Igual a parte da cidade ,porém com pequenas mudanças por conta do conteúdo e
            //tamanho da tabela
            String alunos_mostrar="";
            String[] alunos = Salvar_aluno.pegar_conteudo().split("\n");
            for(int i=0;i<alunos.length;i++){
                String[] aluno=alunos[i].split(",");
                String[] nome_aluno=aluno[1].split("");
                boolean igual=true;
                for(int j =0;j<pesquisa.length;j++){
                    try{
                        if(nome_aluno[j]!=null && pesquisa[j].equalsIgnoreCase(nome_aluno[j]) && igual){
                            System.out.println(Arrays.toString(aluno));
                        }else{
                            igual=false; 
                        }
                    }catch (Exception e){}
                }
                if(igual){
                    System.out.println(aluno[0]);
                    alunos_mostrar+=Salvar_aluno.buscar_estudante_por_codigo(aluno[0])+"\n";
                }
            }
            MostrarAlunoPesquisado(alunos_mostrar);
        }
        return null;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
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
        JLabel pesquisaTexto = new JLabel("Nome do ");
        JButton pesquisaSeleciona = new JButton("Estudante");

        /* Troca o texto do Texto ao lado do botão e do botão, vai servir para escolher se queremos procurar
        um Aluno ou uma Cidade */
            pesquisaSeleciona.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    if (pesquisaTexto.getText().equals("Nome da ")){
                        pesquisaTexto.setText("Nome do ");
                        pesquisaSeleciona.setText("Estudante");
                        //Roda as funções necessárias para mudar para os alunos na tela
                        MostrandoAluno=true;
                        remover();
                        MostrarAluno();
                        salvarAluno = true;
                    }
                    else{
                        pesquisaTexto.setText("Nome da ");
                        pesquisaSeleciona.setText("Cidade");
                        //Roda as funções necessárias para mudar para as cidades na tela
                        MostrandoAluno=false;
                        remover();
                        MostrarCidade();
                        salvarAluno = false;
                    }
                }
            });

        //Ainda é os itens do footer
        footer.add(pesquisaTexto);
        footer.add(pesquisaSeleciona);
        //Adiciona uma KeyListener para cada tecla pressionada na barra de pesquisa
            // Precisa ser o KeyRealesed, pois só assim roda a função após a tecla estar na barra
        barraPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                //Função que irá pesquisar
                pesquisar();
            }
        });
        //JButton pesquisaButton = new JButton("Pesquisar");
        footer.add(barraPesquisa);
        //footer.add(pesquisaButton);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
                salvarAlteracoes();
        }});
        footer.add(salvarButton);

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
        
        //Evento para Inserir uma cidade, leva para o arquivo CriarCidade.java
        ActionListener editar_cidade = new EditarEstudante();
        cidade_editar.addActionListener(editar_cidade);

        //Evento para Inserir um aluno, leva para CriarEstudante.java
        ActionListener editar_estudante = new EditarEstudante();
        aluno_editar.addActionListener(editar_estudante);

        //Mostrar a tabela alunos assim que inicia
        MostrarAluno();
        //Salva que está mostrando os alunos
        MostrandoAluno=true;


        //Deixa em tela cheia e vísivel
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
          });
    }
}
