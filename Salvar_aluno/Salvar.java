import java.io.*;
import java.util.Arrays;

public class Salvar {
    static String caminhoArquivo = "src/db/db.txt";
    public static void main() {

    pegar_info_aluno();
    }
    //esta função que deverá pegar as informações dos alunos
    public static void pegar_info_aluno(){
         String codigo=pegar_cod();
         String nome="nome do aluno";
         String dataNascimento="22/22/2222";
         String email="exemplo@gmail.com";
         String senha="12345678";
         String cidade="Teste";
        //tem que ser enviado em formato de array
         String [] array={codigo,nome,dataNascimento,email,senha,cidade};

        salvar(array);
    }

    public static String pegar_conteudo(){
        try {
            //nesta função, ele tenta ler o conteúdo que está presente no arquivo de texto.
            BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            StringBuilder conteudo = new StringBuilder();
            //cada linha que existe no arquivo é lido e juntado
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
            //fecha o arquivo
            reader.close();
            //retorna a string
            return conteudo.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "erro";
        }
    }
    public static void salvar(String[] novo){

        try {
            //aqui ele vai pegar o conteúdo que já foi salvo, rodando a
            // função "pegar_conteúdo()" e juntando com o conteudo atual passado
            String conteudo=pegar_conteudo()+Arrays.toString(novo);
            //aqui ele está abrindo o arquivo, porém, ele precisa estar nesta sequência,
            //uma vez que se o mesmo arquivo for aberto duas vezes, na segunda vez ele estará vazio.
            //como o "pegar_conteúdo()" também abre o arquivo, primeiro é necessário chamar esta função
            //e só depois abrir aqui.
            FileWriter arquivoEscrita = new FileWriter(caminhoArquivo);
            BufferedWriter escritor = new BufferedWriter(arquivoEscrita);

            //escreve o conteúdo que foi pego
            escritor.write(conteudo);
            //fecha o arquivo para poder rodar outra função
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ele apenas vê quantas linhas existe e retorna o número do ID do aluno
    private static String pegar_cod(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            int codigo=0;

            while ((linha = reader.readLine()) != null) {
                codigo++;
            }

            reader.close();

            return Integer.toString(codigo);
        } catch (IOException e) {
            e.printStackTrace();
            return "99999";
        }
    }
}
