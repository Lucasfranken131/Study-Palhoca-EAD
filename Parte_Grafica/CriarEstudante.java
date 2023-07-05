import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CriarEstudante implements ActionListener { 
   private String[] options;

   public void setOptions(String[] options) {
	        this.options = options;
	       }
	    
    public String[] getOptions() {
			return options;
		}
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

        //Quando criada uma cidade, criara 4 estudante com ela
	// if(getOptions() == null || getOptions().length == 0) {
 //        	options = cidade_nome.split(",");
 //        }else {
 //        	setOptions(getOptions());
 //        }
        String[] options = cidade_nome.split(",");

        int x = JOptionPane.showOptionDialog(null, "Em qual cidade o aluno mora?",
                "Selecionar cidade",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);


	int escolha = JOptionPane.showOptionDialog(null, "O aluno é Bolsista?", "Aluno Bolsista", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha == 0) {
        	alunoBolsista = "Sim";
        }else alunoBolsista = "Não";


        String codigo= Salvar_aluno.pegar_cod();
        String [] array={codigo,nome,dataNascimento,email,senha,options[x],alunoBolsista};


        Salvar_aluno.salvar(array);

	JOptionPane.showMessageDialog(null, "Estudante Criado com sucesso!");

    Tela.remover();
    Tela.MostrarAluno();
    Tela.MostrandoAluno=true;
	}
}