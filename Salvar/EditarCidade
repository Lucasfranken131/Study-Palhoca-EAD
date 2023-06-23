import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EditarCidade implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {

        String codigo = JOptionPane.showInputDialog("Insira o código da cidade a ser editada:");
        String idCodigo = codigo;

        // Buscar a cidade pelo código no arquivo de texto
        String cidadeEncontrada = Salvar_cidade.buscar_cidade_por_codigo(idCodigo);

        if (cidadeEncontrada != null) {
            String[] campos = cidadeEncontrada.split(",");
            String nomeAtual = campos[1].trim();
            String ufAtual = campos[2].trim();
           

            // Exibir caixas de diálogo com os valores existentes para permitir a edição
            String novoNome = JOptionPane.showInputDialog("Nome atual: " + nomeAtual + "\nInsira o novo nome da cidade:");
            String novoUf = JOptionPane.showInputDialog("Estado atual: " + ufAtual + "\nInsira o novo Estado da cidade:");
         

            String[] array = {codigo, novoNome, novoUf};

            Salvar_cidade.salvar(array);

          
            JOptionPane.showMessageDialog(null, "Cidade editada com sucesso!");
        } else {
            // Cidade não encontrada
            JOptionPane.showMessageDialog(null, "Cidade não encontrada.");
        }
    }
}
