public class Endereco {
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String UF;

    public String getLogradouro() {
        return this.logradouro;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getCep() {
        return this.cep;
    }

    public String getUF() {
        return this.UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public Endereco(String logradouro, int numero, String bairro, String cidade, String cep, String UF) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.UF = UF;

    }

    public Endereco() {
        this.logradouro = "";
        this.numero = 0;
        this.bairro = "";
        this.cidade = "";
        this.cep = "";
        this.UF = "";

    }
}
