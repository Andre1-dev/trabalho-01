import java.text.SimpleDateFormat;
import java.util.Date;

public class Paciente {
    private int idPaciente;
    private long numCNS;
    private String nome;
    private String nomeMae;
    private Date dataNasc;
    private Endereco endereco;
    private String telefone;
    private Sexo sexo;

    public int getIdPaciente() {
        return this.idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public long getNumCNS() {
        return this.numCNS;
    }

    public String getNome() {
        return this.nome;
    }

    public String getNomeMae() {
        return this.nomeMae;
    }

    public Date getDataNasc() {
        return this.dataNasc;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Paciente(long numCNS, String nome, String nomeMae, Date dataNasc, Endereco endereco, String telefone,
            Sexo sexo) {
        if (numCNS != 0) {
            this.numCNS = numCNS;
        }
        if (!nome.equals("")) {
            this.nome = nome.toUpperCase();
        }
        if (!nomeMae.equals("")) {
            this.nomeMae = nomeMae.toUpperCase();
        }
        this.dataNasc = dataNasc;
        if (endereco != null) {
            this.endereco = endereco;
        }
        if (!telefone.equals("")) {
            this.telefone = telefone.toUpperCase();
        }
        this.idPaciente = 0;
        this.sexo = sexo;
    }

    public Paciente() {
        idPaciente = 0;
        numCNS = 0;
        nome = "";
        nomeMae = "";
        dataNasc = new Date();
        endereco = new Endereco();
        telefone = "";
    }

    public Paciente(int idpaciente, long numCNS, String nome, String nomeMae, Date dataNasc, Endereco endereco,
            String telefone, Sexo sexo) {

        if (numCNS != 0) {
            this.numCNS = numCNS;
        }
        if (!nome.equals("")) {
            this.nome = nome.toUpperCase();
        }
        if (!nomeMae.equals("")) {
            this.nomeMae = nomeMae.toUpperCase();
        }
        this.dataNasc = dataNasc;
        if (endereco != null) {
            this.endereco = endereco;
        }
        if (!telefone.equals("")) {
            this.telefone = telefone.toUpperCase();
        }

        this.idPaciente = idpaciente;
        this.sexo = sexo;

    }

    public Paciente(long numCNS, String nome, String nomeMae, String dataNascStr, Endereco endereco, String telefone,
            Sexo sexo) {

        if (numCNS != 0) {
            this.numCNS = numCNS;
        }
        if (!nome.equals("")) {
            this.nome = nome.toUpperCase();
        }
        if (!nomeMae.equals("")) {
            this.nomeMae = nomeMae.toUpperCase();
        }
        if (!telefone.equals("")) {
            this.telefone = telefone.toUpperCase();
        }
        try {
            this.dataNasc = sdf.parse(dataNascStr);
        } catch (Exception e) {
            this.dataNasc = new Date();
        }
        if (endereco != null) {
            this.endereco = endereco;
        }
        this.sexo = sexo;

    }

}
