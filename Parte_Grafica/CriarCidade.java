import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CriarCidade implements ActionListener {
    public void actionPerformed(ActionEvent ActionEvent) {
        //Aqui pega os valores para a classe Cidade
       String nome = "";
	//Obriga o usuário a colocar um nome para a cidade
    	while (nome.isEmpty()) {
    	    nome = JOptionPane.showInputDialog("Insira o nome da cidade");
    	    if (nome.isEmpty()) {
    	        JOptionPane.showMessageDialog(null, "O nome da cidade não pode estar vazio. Por favor, digite um valor válido.");
    	    }
    	}
        String uf = JOptionPane.showInputDialog("Insira o estado:");
        //Criação do objeto.
        String[] array = {Salvar_cidade.pegar_cod(),nome,uf};


        Salvar_cidade.salvar(array);

	// JOptionPane.showMessageDialog(null, "Cidade Criada com sucesso!"
 //        		+ "\n Você será direcionado para criação de 4 estudantes para a Cidade");

        //Obriga o usuário a criar 4 estudantes para a cidade
  //       for (int i = 0; i<4; i++) {
  //       	// Criar uma instância da classe CriarEstudante
  //           CriarEstudante criarEstudante = new CriarEstudante();
  //           System.out.println(nome);
  //           criarEstudante.setOptions(new String[]{nome});
  //           // Chamar o método actionPerformed da instância de CriarEstudante
  //           criarEstudante.actionPerformed(ActionEvent);
  //		}

		Tela.remover();
		Tela.MostrarCidade();
		Tela.MostrandoAluno=false;
	}
}

//Para salvar os valores estou usando o JOptionPane
