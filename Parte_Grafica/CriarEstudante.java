import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CriarEstudante implements ActionListener {
    public void actionPerformed(ActionEvent ActionEvent) {
        //Aqui pega os valores para a classe Estudante
		String codigo = JOptionPane.showInputDialog("Insira o Código do estudante");
        int id_codigo = Integer.parseInt(codigo);
        String nome = JOptionPane.showInputDialog("Insira o nome do estudante");
        String dataNascimento = JOptionPane.showInputDialog("Insira a data de nascimento do estudante:");
        String email = JOptionPane.showInputDialog("Insira o email do estudante:");
        String senha = JOptionPane.showInputDialog("Insira a senha do estudante:");
        
        //Fazer essa parte depois :p
        //Cidade cidade = JOptionPane.showInputDialog("Insira o estado:");
        //Criação do objeto.
        //Estudante estudante_objeto = new Estudante(codigo, nome, dataNascimento, email, senha, cidade); 
	}
}

//Para salvar os valores estou usando o JOptionPane
