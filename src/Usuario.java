public class Usuario {
    private static int idUsuarioCout = 0;
    private int id;
    private String nome;
    private String nomeUsuario;
    private String senha;
    private Tipo tipoUsuario;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario(String nome, String nomeUsuario, String senha, Tipo tipoUsuario) {
        this.nome = nome;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
        this.id = idUsuarioCout;
        idUsuarioCout++;
    }

    public String getNome() {
        return this.nome;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public Tipo getTipoUsuario() {
        return this.tipoUsuario;
    }

}
