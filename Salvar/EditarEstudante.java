import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EditarEstudante implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {

        String codigo = JOptionPane.showInputDialog("Insira o código do estudante a ser editado:");
        String idCodigo = codigo;

        // Buscar o estudante pelo código no arquivo de texto
        String estudanteEncontrado = Salvar_aluno.buscar_estudante_por_codigo(idCodigo);

        if (estudanteEncontrado != null) {
            // Separar as informações existentes em variáveis separadas
            String[] campos = estudanteEncontrado.split(",");
            String nomeAtual = campos[1].trim();
            String dataNascimentoAtual = campos[2].trim();
            String emailAtual = campos[3].trim();
            String senhaAtual = campos[4].trim();
            String cidadeAtual = campos[5].trim();

            // Exibir caixas de diálogo com os valores existentes para permitir a edição
            String novoNome = JOptionPane.showInputDialog("Nome atual: " + nomeAtual + "\nInsira o novo nome do estudante:");
            String novaDataNascimento = JOptionPane.showInputDialog("Data de Nascimento atual: " + dataNascimentoAtual + "\nInsira a nova data de nascimento do estudante:");
            String novoEmail = JOptionPane.showInputDialog("Email atual: " + emailAtual + "\nInsira o novo email do estudante:");
            String novaSenha = JOptionPane.showInputDialog("Senha atual: " + senhaAtual + "\nInsira a nova senha do estudante:");
            String novaCidade = JOptionPane.showInputDialog("Cidade atual: " + cidadeAtual + "\nInsira a nova cidade do estudante:");

            String[] array = {codigo, novoNome, novaDataNascimento, novoEmail, novaSenha, novaCidade};

            Salvar_aluno.salvar(array);

       
            JOptionPane.showMessageDialog(null, "Estudante editado com sucesso!");
        } else {
            // Estudante não encontrado
            JOptionPane.showMessageDialog(null, "Estudante não encontrado.");
        }
    }
}
