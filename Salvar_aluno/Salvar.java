import java.io.*;
import java.util.Arrays;

public class Salvar {
    static String caminhoArquivo = "src/db/db.txt";
    public static void main() {

    pegar_info_aluno();
    }
    public static void pegar_info_aluno(){
         String codigo=pegar_cod();
         String nome="nome do aluno";
         String dataNascimento="22/22/2222";
         String email="exemplo@gmail.com";
         String senha="12345678";
         String cidade="Teste";

         String [] array={codigo,nome,dataNascimento,email,senha,cidade};

        salvar(array);
    }

    public static String pegar_conteudo(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            StringBuilder conteudo = new StringBuilder();

            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }

            reader.close();
            return conteudo.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "erro";
        }
    }
    public static void salvar(String[] novo){
        try {
            String conteudo=pegar_conteudo()+Arrays.toString(novo);
            FileWriter arquivoEscrita = new FileWriter(caminhoArquivo);
            BufferedWriter escritor = new BufferedWriter(arquivoEscrita);

            escritor.write(conteudo);

            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
