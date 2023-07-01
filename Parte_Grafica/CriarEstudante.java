import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CriarEstudante implements ActionListener {
    public void actionPerformed(ActionEvent ActionEvent) {
	String[] opcoes = {"Sim", "Não"};
    	String alunoBolsista;
        //Aqui pega os valores para a classe Estudante
		//String codigo = JOptionPane.showInputDialog("Insira o Código do estudante");
        //int id_codigo = Integer.parseInt(codigo);
        String nome = JOptionPane.showInputDialog("Insira o nome do estudante");
        String dataNascimento = JOptionPane.showInputDialog("Insira a data de nascimento do estudante:");
        String email = JOptionPane.showInputDialog("Insira o email do estudante:");
        String senha = JOptionPane.showInputDialog("Insira a senha do estudante:");
        String[] cidades= Salvar_cidade.pegar_conteudo().split("\n");
        String cidade_nome=""; 
	
        for (int i =0;i<cidades.length;i++) {
            cidade_nome += cidades[i].split(",")[1]+",";
        }


        String[] options = cidade_nome.split(",");

        int x = JOptionPane.showOptionDialog(null, "Em qual cidade o aluno mora?",
                "Selecionar cidade",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);


        System.out.println(x);

	int escolha = JOptionPane.showOptionDialog(null, "O aluno é Bolsista?", "Aluno Bolsista", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
        	alunoBolsista = "Sim";
        }else alunoBolsista = "Não";


        String codigo= Salvar_aluno.pegar_cod();
        System.out.println(codigo);
        String [] array={codigo,nome,dataNascimento,email,senha,options[x],alunoBolsista};



        Salvar_aluno.salvar(array);

	JOptionPane.showMessageDialog(null, "Estudante Criado com sucesso!");


 //Fazer essa parte depois :p
        //Cidade cidade = JOptionPane.showInputDialog("Insira o estado:");
        //Criação do objeto.
        //Estudante estudante_objeto = new Estudante(codigo, nome, dataNascimento, email, senha, cidade); 
	}
}

//Para salvar os valores estou usando o JOptionPane
