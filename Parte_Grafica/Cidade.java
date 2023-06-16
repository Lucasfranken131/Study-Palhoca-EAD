public class Cidade //Classe
{
    private int codigo; //atributos da classe
    private String descricao;
    private String uf;
    private int quantidade_de_Estudantes;
    
    public Cidade(int cod, String des, String u) //metodo Construtor (parametro1, parametro2,parametro3)
    {
        codigo = cod; //parametros do Construtor
        descricao = des;
        uf = u;
        
    }
    public int getCodigo() //metodo GET Codigo (pega codigo do objeto Cidade)
    {
        return codigo; // retorna valor do codigo do objeto
    }
    public String getDescricao() //metodo GET Descricao (pega descricao do objeto Cidade)
    {
        return descricao; // retorna valor da descricao do objeto
    }
    public void setDescricao(String des) //metodo SET Descricao (seta descricao do objeto cidade) (parametro do tipo string)
    {
        descricao = des; // 
    }
    public String getUf() // metodo GET uf (pega a uf do objeto cidade)
    {
        return uf; //retorna uf
    }
    public void setUf(String u) // SET uf (seta uf do objeto cidade) (parametro do tipo string)
    {
        uf = u;
    }
    public void adicionaNovoEstudante() //metodo adiciona estudante por cidade
    {
        quantidade_de_Estudantes = quantidade_de_Estudantes + 1; //incrementa qtd de estudantes
    }
    public void exibeDados() //exibe dados da classe cidade
    {
        System.out.println("Codigo Cidade: "+codigo);
        System.out.println("Descricao: "+descricao);
        System.out.println("Estado UF: "+uf);
        //System.out.println("----A quantidade de Estudantes Atualizada da Cidade eh: "+quantidade_de_Estudantes);        
    }
    public void exibeDados2() //exibe dados da classe cidade
    {
        System.out.println("----Quantidade de Estudantes cadastrados nessa Cidade: "+quantidade_de_Estudantes);        
    }
}