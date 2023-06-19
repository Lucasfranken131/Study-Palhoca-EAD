public class Estudante // classe estudante
{
    private int codigo; //atributos da classe estudante
    private String nome;
    private String dataNascimento;
    private String email;
    private String senha;
    private Cidade cidade;
    
    public Estudante (int cod, String nom, String dat, String ema, String sen,Cidade cid) 
    //metodo Construtor (5 parametros do tipo string ou int, parametro cid do tipo Cidade)
    {
        codigo=cod; //parametros dos atributos a serem construidos
        nome=nom;
        dataNascimento=dat;
        email=ema;
        senha=sen;
        cidade=cid;
        cidade.adicionaNovoEstudante();        
    }
    public int getCodigo() //GET Codigo (pega codigo do objeto estudante)
    {
        return codigo; //retorna valor do codigo 
    }
    public void setCodigo(int cod) // SET Codigo (seta codigo do objeto estudante)
    {
        codigo = cod; //
    }
    public String getNome() //GET Nome (pega nome do objeto estudante)
    {
        return nome; //retorna valor do nome do tipo string
    }
    public void setNome(String nom) // SET Nome
    {
        nome = nom;
    }
    public String getDataNascimento() //GET DataNascimento
    {
        return dataNascimento;
    }
    public void setDataNascimento(String dat) // SET DataNascimentoo
    {
        dataNascimento = dat;
    }
    public String getEmail() //GET Email
    {
        return email;
    }
    public void setEmail(String ema) // SET Email
    {
        email = ema;
    }
    public String getSenha() //GET Senha
    {
        return senha;
    }
    public void setSenha(String sen) // SET Senha
    {
        senha = sen;
    }
    public Cidade getCidade() //GET Cidade (pega cidade do objeto cidade do tipo Cidade)
    {
        return cidade;
    }
    public void setCidade(Cidade cid) // SET Cidade (seta cidade do objeto cidade do ripo Cidade)
    {
        cidade = cid;
    }
    public void exibeDados() //exibe dados
    {
        System.out.println("\nCodigo matricula: "+codigo); //println - nova linha antes de imprimir
        System.out.println("Nome  : "+nome); //\n - nova linha apos imprimir
        System.out.println("Data de nascimento: "+dataNascimento); //"texto a ser imprimido"
        System.out.println("Email: "+email);// +email - concatena depois do texto a ser imprimido
        System.out.println("Senha: "+senha); //outra maneira de imprimir ("xxxx",senha);
        cidade.exibeDados();
        
    }
}