import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EditarEstudante implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {

        String codigo = JOptionPane.showInputDialog("Insira o código do estudante a ser editado:");
        String idCodigo = codigo;
        String[] opcoes = {"Sim", "Não"};
    	String novoAlunoBolsista;

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
            String bolsistaAtual = campos[6].trim();

            // Exibir caixas de diálogo com os valores existentes para permitir a edição
            String novoNome = JOptionPane.showInputDialog("Nome atual: " + nomeAtual + "\nInsira o novo nome do estudante:");
            String novaDataNascimento = JOptionPane.showInputDialog("Data de Nascimento atual: " + dataNascimentoAtual + "\nInsira a nova data de nascimento do estudante:");
            String novoEmail = JOptionPane.showInputDialog("Email atual: " + emailAtual + "\nInsira o novo email do estudante:");
            String novaSenha = JOptionPane.showInputDialog("Senha atual: " + senhaAtual + "\nInsira a nova senha do estudante:");
          //  String novoBolsista = JOptionPane.showInputDialog("Bolsista atual: " + bolsistaAtual + "\nInsira a nova cidade do estudante:");

            String cidade_nome=""; 
            String[] cidades= Salvar_cidade.pegar_conteudo().split("\n");
            for (int i =0;i<cidades.length;i++) {
                cidade_nome += cidades[i].split(",")[1]+",";
            }
            
            String[] novaOption = cidade_nome.split(",");

            int x = JOptionPane.showOptionDialog(null, "Cidade atual: " + cidadeAtual + "\nInsira a nova cidade do estudante:",
                    "Selecionar cidade",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, novaOption, novaOption[0]);
            
            int escolha = JOptionPane.showOptionDialog(null, "O aluno é Bolsista?", "Aluno Bolsista", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            if (escolha == 0) {
            	novoAlunoBolsista = "Sim";
            }else novoAlunoBolsista = "Não";

            String[] array = {codigo, novoNome, novaDataNascimento, novoEmail, novaSenha, novaOption[x], novoAlunoBolsista};

            System.out.print(array);
            Salvar_aluno.salvar(array);

            // Após salvar as informações atualizadas no arquivo, você pode exibir uma mensagem informando
            // que a edição foi realizada com sucesso ou qualquer outra ação necessária.
            JOptionPane.showMessageDialog(null, "Estudante editado com sucesso!");
        } else {
            // Estudante não encontrado
            JOptionPane.showMessageDialog(null, "Estudante não encontrado.");
        }
        //atualiza a tela mostrando os dados
        Tela.remover();
        Tela.MostrarAluno();
        Tela.MostrandoAluno=true;
    }
}
