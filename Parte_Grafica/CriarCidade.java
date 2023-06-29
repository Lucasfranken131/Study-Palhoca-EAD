import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CriarCidade implements ActionListener {
    public void actionPerformed(ActionEvent ActionEvent) {
        //Aqui pega os valores para a classe Cidade
        String nome = JOptionPane.showInputDialog("Insira o nome da cidade");
        String uf = JOptionPane.showInputDialog("Insira o estado:");
        //Criação do objeto.
        String[] array = {Salvar_cidade.pegar_cod(),nome,uf};


        Salvar_cidade.salvar(array);

	}
}

//Para salvar os valores estou usando o JOptionPane
