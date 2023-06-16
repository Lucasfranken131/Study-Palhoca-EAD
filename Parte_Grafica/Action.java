import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Action implements ActionListener {
    public void actionPerformed(ActionEvent ActionEvent) {
        //Aqui pega os valores para a classe Cidade
		String id = JOptionPane.showInputDialog("Insira o ID da cidade");
        int id_int = Integer.parseInt(id);
        String nome = JOptionPane.showInputDialog("Insira o nome da cidade");
        String uf = JOptionPane.showInputDialog("Insira o estado:");
        //Criação do objeto.
        Cidade cidade_objeto = new Cidade(id_int, nome, uf); 
        System.out.println(cidade_objeto.getCodigo());
	}
}

//Para salvar os valores estou usando o JOptionPane
