import java.io.*;
import java.util.Arrays;

public class Salvar_cidade {
    static String caminhoArquivo = "Salvar/db/db_cidade.txt";

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


    // public static void salvar(String[] novo){

    //     try {
    //         //aqui ele vai pegar o conteúdo que já foi salvo, rodando a
    //         // função "pegar_conteúdo()" e juntando com o conteudo atual passado
    //         String nova_cidade=novo[0]+","+novo[1];
    //         String conteudo=pegar_conteudo()+nova_cidade;

    //         //aqui ele está abrindo o arquivo, porém, ele precisa estar nesta sequência,
    //         //uma vez que se o mesmo arquivo for aberto duas vezes, na segunda vez ele estará vazio.
    //         //como o "pegar_conteúdo()" também abre o arquivo, primeiro é necessário chamar esta função
    //         //e só depois abrir aqui.
    //         FileWriter arquivoEscrita = new FileWriter(caminhoArquivo);
    //         BufferedWriter escritor = new BufferedWriter(arquivoEscrita);

    //         //escreve o conteúdo que foi pego
    //         escritor.write(conteudo);
    //         //fecha o arquivo para poder rodar outra função
    //         escritor.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    public static void salvar(String[] novo) {
        try {
            String nova_cidade = novo[0] + "," + novo[1] + "," + novo[2];
            String conteudo = pegar_conteudo();

            if (conteudo.contains(novo[0] + ",")) {
                // O registro já existe, substitui as informações existentes pelas novas
                String[] linhas = conteudo.split("\n");
                StringBuilder novoConteudo = new StringBuilder();
                boolean substituiu = false;
                for (String linha : linhas) {
                    if (linha.startsWith(novo[0] + ",")) {
                        novoConteudo.append(nova_cidade).append("\n");
                        substituiu = true;
                    } else {
                        novoConteudo.append(linha).append("\n");
                    }
                }

                if (!substituiu) {
                    // Se o registro não foi substituído, adiciona as informações ao conteúdo existente
                    novoConteudo.append(nova_cidade).append("\n");
                }

                conteudo = novoConteudo.toString();
            } else {
                // O registro não existe, adiciona as informações ao conteúdo existente
                conteudo += nova_cidade + "\n";
            }

            FileWriter arquivoEscrita = new FileWriter(caminhoArquivo);
            BufferedWriter escritor = new BufferedWriter(arquivoEscrita);
            escritor.write(conteudo);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static String pegar_cod(){
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

      public static String buscar_cidade_por_codigo(String codigo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                String codigoCidade = campos[0].trim();

                if (codigoCidade.equals(codigo)) {
                    reader.close();
                    return linha;
                }
            }

            reader.close();
            return null; // Estudante não encontrado
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Erro na leitura do arquivo
        }
    }


}
