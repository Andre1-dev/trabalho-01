import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class App {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static Scanner scnString = new Scanner(System.in);
    static Scanner scnInt = new Scanner(System.in);
    static Scanner scnLong = new Scanner(System.in);
    static Sistema sistema = Sistema.getInstance();
    static Usuario t = null;
    static Boolean modoProfissional = true;
    static boolean Sair = true;

    public static void main(String[] args) throws Exception {
        // ------------------------------------------------------------------
        // - Desenvolvido por Andre Neres de Paulo
        // ------------------------------------------------------------------
        init();
        int modoAcesso = -1;
        Boolean Login = true;

        while (Sair) {
            System.out.println(" 0 - Logar");
            System.out.println(" 1 - Criar cadastro");
            int modoAcessoLogin = scnInt.nextInt();

            switch (modoAcessoLogin) {
                case (0):
                    while (t == null) {
                        System.out.println(" Informe o usuário");
                        String user = scnString.nextLine();
                        System.out.println(" Informe a senha");
                        String pass = scnString.nextLine();
                        t = sistema.returnTipoUsuario(user, pass);
                        if (t == null) {
                            System.out.println("Erro ao fazer login, usuario ou senha incorreto");
                        } else {
                            // Login = false;
                            if (t.getTipoUsuario() == Tipo.ATENDENTE)
                                modoAcesso = 0;
                            if (t.getTipoUsuario() == Tipo.PROFISSIONAL_SAUDE)
                                modoAcesso = 1;
                        }
                    }

                    break;
                case (1):
                    Usuario u = LerUsuario();
                    limpaConsole();
                    if (sistema.adicionarUsuario(u)) {
                        System.out.println("Usuario cadastrado com sucesso");
                    }

                    else {
                        System.out.println("Erro ao cadastrar");
                    }

                    break;
                default:
                    break;
            }

            Boolean menuAcesso = true;
            while (menuAcesso) {
                limpaConsole();
                // System.out.println(" Deseja sair S/N?");
                // char sair = scnString.next().charAt(0);
                // if (sair == 'S')
                // modoAcesso = 2;
                switch (modoAcesso) {
                    case (0):
                        limpaConsole();
                        modoAtendente();
                        modoAcesso = 2;
                        break;
                    case (1):
                        limpaConsole();
                        modoProfissionalSaude();
                        modoAcesso = 2;
                        break;
                    case (2):
                        menuAcesso = false;
                        limpaConsole();
                        System.out.println("Saindo");
                        break;
                    default:
                        System.out.println("Opcao Inválida");
                        break;
                }
            }

        }

    }

    private static Usuario LerUsuario(Usuario usuarioExistente) {
        Usuario u = null;
        if (usuarioExistente == null)
            return u;
        System.out.println("Informe o nome: " + usuarioExistente.getNome());
        String nome = scnString.nextLine();
        System.out.println("Informe o nome de usuario: " + usuarioExistente.getNomeUsuario());
        String nomeUsuario = scnString.nextLine();
        System.out.println("Informe a senha: " + usuarioExistente.getSenha());
        String senha = scnString.nextLine();
        System.out.println("Informe o tipo de usuario P-Profissional Saude, A- Atendente: "
                + usuarioExistente.getTipoUsuario().toString());
        String tipo = scnString.nextLine();
        switch (tipo) {
            case ("P"):
                u = new Usuario(nome, nomeUsuario, senha, Tipo.PROFISSIONAL_SAUDE);
                break;
            case ("A"):
                u = new Usuario(nome, nomeUsuario, senha, Tipo.ATENDENTE);
                break;
            default:
                System.out.println("Tipo de usuario incorreto");
                break;
        }
        u.setId(usuarioExistente.getId());
        return u;

    }

    private static Usuario LerUsuario() {
        Usuario u = null;
        System.out.println("Informe o nome: ");
        String nome = scnString.nextLine();
        System.out.println("Informe o nome de usuario: ");
        String nomeUsuario = scnString.nextLine();
        System.out.println("Informe a senha: ");
        String senha = scnString.nextLine();
        System.out.println("Informe o tipo de usuario P-Profissional Saude, A- Atendente: ");
        String tipo = scnString.nextLine();
        switch (tipo) {
            case ("P"):
                u = new Usuario(nome, nomeUsuario, senha, Tipo.PROFISSIONAL_SAUDE);
                break;
            case ("A"):
                u = new Usuario(nome, nomeUsuario, senha, Tipo.ATENDENTE);
                break;
            default:
                System.out.println("Tipo de usuario incorreto");
                break;
        }

        return u;

    }

    private static void init() {
        Endereco e = new Endereco("Av madresilva", 123, "Esperanca", "Ipatinga", "35162155", "MG");
        Paciente p1 = new Paciente(2452434, "Adriana souza Carvalho", "Neuza", "15/11/1998", e, "03192376574",
                Sexo.FEMININO);

        Paciente p2 = new Paciente(40028922, "Andre Neres de Paulo", "Enilza de Cassia Neres", "16/04/2001", e,
                "031973183145", Sexo.MASCULINO);
        Paciente p3 = new Paciente(53423245, "Renata Vasconselos de Souza", "Mirian Gonçalves da Silva", "17/05/2000",
                e,
                "031973549192", Sexo.FEMININO);
        Paciente p4 = new Paciente(734728738, "Leticia Rodrigues de Souza", "Maria Bragança Oliveira", "10/07/1999",
                e,
                "031868574782", Sexo.FEMININO);
        Paciente p5 = new Paciente(734728738, "Renato Gonçalves Da Silva", "Natiele Pereira da Silva", "09/05/1980",
                e,
                "031862323452", Sexo.MASCULINO);
        Paciente pHomonimo = new Paciente(343423434, "Renato Gonçalves Da Silva", "Natiele Pereira da Silva",
                "09/05/1988",
                e,
                "031884723452", Sexo.MASCULINO);

        Anamnese a1 = new Anamnese(p1, "Vista Cansada", "O Paciente relata vista cansada", "Colirio");
        Anamnese a2 = new Anamnese(p2, "Dor no joelho", "O paciente relata fortes dores no joelho",
                "Intervenção cirurgica");
        Anamnese a3 = new Anamnese(p3, "Cansaço", "O paciente relata cansaço e falta de ar", "Covid");
        sistema.salvarPaciente(p1);
        sistema.salvarPaciente(p2);
        sistema.salvarPaciente(p3);
        sistema.salvarPaciente(p4);
        sistema.salvarPaciente(p5);

        sistema.saveAnamnese(a1);
        sistema.saveAnamnese(a2);
        sistema.saveAnamnese(a3);

        Usuario user1 = new Usuario("ANDRE NERES DE PAULO", "andreneres808", "Mudar1234", Tipo.ATENDENTE);
        Usuario user2 = new Usuario("ANDREIA DE JESUS", "andreia", "123456", Tipo.PROFISSIONAL_SAUDE);
        sistema.adicionarUsuario(user1);
        sistema.adicionarUsuario(user2);
        // sistema.salvarPaciente(pHomonimo); // Teste de Homonimos

    }

    private static void modoProfissionalSaude() {
        modoProfissional = true;
        Paciente pacienteBO = buscaPaciente();
        if (pacienteBO == null) {
            modoProfissionalSaude();
        }
        while (modoProfissional) {
            if (modoProfissional == false)
                break;
            System.out.println(" 0 - Cadastrar novo anamnese");
            System.out.println(" 1 - Pesquisar anamnese por nome");
            System.out.println(" 2 - Listar anamneses");
            System.out.println(" 3 - Excluir anamnese");
            System.out.println(" 4 - Editar anamnese");
            System.out.println(" 5 - Trocar de Paciente");
            System.out.println(" 6 - Sair");
            System.out.println(" 7 - Alterar dados do usuario");
            System.out.println(" 8 - Apagar conta");
            int opcoesMedico = scnInt.nextInt();
            switch (opcoesMedico) {
                case (0):
                    limpaConsole();
                    sistema.saveAnamnese(LeAnamnese(null, pacienteBO));
                    break;
                case (1):
                    limpaConsole();
                    printAnamneses(sistema.buscaAnamneses(buscaPaciente()));

                    break;
                case (2):
                    printAnamneses(sistema.buscaAnamneses(pacienteBO));
                    break;
                case (3):
                    limpaConsole();
                    Anamnese exclusao = null;
                    printAnamneses(sistema.buscaAnamneses(pacienteBO));
                    System.out.println("Informe o id da anamnese");
                    int idAnamneseExclusao = scnInt.nextInt();
                    exclusao = sistema.getAnamneseById(idAnamneseExclusao);
                    if (exclusao == null) {
                        System.out.println("Anamnese não encontrada, id incorreto");
                        break;
                    }
                    if (sistema.excluirAnamnese(exclusao))
                        System.out.println("Exclusao feita com sucecsso");
                    else
                        System.out.println("Falha ao excluir");

                    break;

                case (4):
                    limpaConsole();
                    printAnamneses(sistema.buscaAnamneses(pacienteBO));
                    System.out.println("Informe o id da anamnese");
                    int idAnamnese = scnInt.nextInt();
                    Anamnese anamneseEditar = sistema.getAnamneseById(idAnamnese);
                    if (anamneseEditar == null) {
                        System.out.println("Anamnese nao encontrada");
                        break;
                    }

                    sistema.saveAnamnese(LeAnamnese(anamneseEditar, pacienteBO));
                    break;
                case (5):
                    limpaConsole();
                    pacienteBO = buscaPaciente();
                    break;

                case (6):
                    limpaConsole();
                    t = null;
                    modoProfissional = false;
                    break;
                case (7):
                    t = LerUsuario(t);
                    sistema.editarUsuario(t);
                    break;
                case (8):
                    limpaConsole();
                    sistema.deletarUsuario(t);
                    t = null;
                    modoProfissional = false;
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;

            }

        }

    }

    private static void modoAtendente() {
        boolean modoAtendente = true;
        while (modoAtendente) {
            System.out.println(" 0 - Cadastrar novo paciente");
            System.out.println(" 1 - editar paciente");
            System.out.println(" 2 - Pesquisar paciente");
            System.out.println(" 3 - Excluir paciente");
            System.out.println(" 4 - Sair");
            System.out.println(" 5 - Alterar dados do usuário");
            System.out.println(" 6 - Apagar usuario");
            int opcoesAtendente = scnInt.nextInt();
            switch (opcoesAtendente) {
                case (0):
                    Paciente p = LePaciente();

                    if (sistema.salvarPaciente(p)) {
                        limpaConsole();
                        System.out.println("Paciente: " + p.getNome() + " cadastrado com sucesso");
                    }

                    break;
                case (1):
                    System.out.println(editarPaciente());

                    break;
                case (2):
                    System.out.println("Informe o nome do paciente: ");
                    String nome = scnString.nextLine();
                    printpacientes(sistema.pesquisarPacientes(nome));
                    break;
                case (3):
                    System.out.println(excluirPaciente());
                    break;
                case (4):
                    modoAtendente = false;
                    limpaConsole();
                    t = null;
                    break;
                case (5):
                    t = LerUsuario(t);
                    sistema.editarUsuario(t);
                    break;
                case (6):
                    modoAtendente = false;
                    limpaConsole();

                    sistema.deletarUsuario(t);
                    t = null;
                    break;
                default:
                    break;
            }
        }
    }

    private static void limpaConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private static Paciente buscaPaciente() {
        Paciente pacienteBO = null;

        System.out.println("Informe o nome do paciente: ");
        String nome = scnString.nextLine();
        Paciente[] busca = sistema.pesquisarPacientes(nome);
        if (busca[0] == null) {
            System.out.println("Nenhum paciente encontrado");
            return null;
        }
        printpacientes(busca);
        System.out.println("Informe o id do paciente");
        int id = scnInt.nextInt();
        pacienteBO = sistema.pesquisaPacienteById(id);
        if (pacienteBO == null) {
            System.out.println("Paciente não encontrado");

        }
        return pacienteBO;

    }

    private static String editarPaciente() {
        Paciente p = buscaPaciente();
        if (p == null) {
            return "Erro, paciente não encontrado";
        }
        if (sistema.salvarPaciente(LePaciente(p))) {
            limpaConsole();
            return "Sucesso ao editar paciente";
        } else {
            return "Erro, paciente não encontrado";
        }

    }

    private static String excluirPaciente() {
        System.out.println("Informe o nome do paciente: ");
        String nome = scnString.nextLine();
        printpacientes(sistema.pesquisarPacientes(nome));
        System.out.println("Informe o id do paciente que deseja realizar a alterção");
        int id = scnInt.nextInt();
        Paciente p = sistema.pesquisaPacienteById(id);
        if (p == null) {
            return "Erro, paciente não encontrado";
        }
        if (sistema.excluirPacienteById(id)) {
            limpaConsole();
            return "Sucesso ao excluir paciente";
        } else {
            return "Erro, ao excluir paciente";
        }

    }

    private static void printpacientes(Paciente[] pesquisarPacientes) {

        limpaConsole();
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
        System.out.println(subString("IdPaciente") + subString("NUM_CNS") + subString("NOME") + subString("NOME_MAE")
                + subString("DATA_NASC") + subString("TELEFONE"));
        for (int i = 0; i < pesquisarPacientes.length; i++) {
            if (pesquisarPacientes[i] != null)
                System.out.println(subString(pesquisarPacientes[i].getIdPaciente() + "")
                        + subString(pesquisarPacientes[i].getNumCNS() + "")
                        + subString(pesquisarPacientes[i].getNome() + "")
                        + subString(pesquisarPacientes[i].getNomeMae() + "")
                        + subString(sdf.format(pesquisarPacientes[i].getDataNasc()))
                        + subString(pesquisarPacientes[i].getTelefone() + ""));
        }
        System.out.println(
                "-----------------------------------------------------------------------------------------------");
    }

    private static void printAnamneses(Anamnese[] pesquisarAnamnese) {

        limpaConsole();
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
        System.out.println(subString("ID") + subString("NOME_PACIENTE") + subString("NOME_MAE") + subString("MOTIVO")
                + subString("RELATO")
                + subString("DIAGNOSTICO"));
        for (int i = 0; i < pesquisarAnamnese.length; i++) {
            if (pesquisarAnamnese[i] != null)
                System.out.println(subString(pesquisarAnamnese[i].getId() + "")
                        + subString(pesquisarAnamnese[i].getPaciente().getNome() + "")
                        + subString(pesquisarAnamnese[i].getPaciente().getNomeMae() + "")
                        + subString(pesquisarAnamnese[i].getMotivo() + "")
                        + subString(pesquisarAnamnese[i].getRelato() + "")
                        + subString(pesquisarAnamnese[i].getDiagnostico() + ""));
        }
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
    }

    static Paciente LePaciente() {
        System.out.println("Informe o numero CNS: ");
        long numCNS = scnLong.nextLong();

        System.out.println("Informe o nome: ");
        String nome = scnString.nextLine();

        System.out.println("Informe o nome da mae: ");
        String nomeMae = scnString.nextLine();

        System.out.println("Informe o telefone: ");
        String telefone = scnString.nextLine();

        System.out.println("Informe a data de nascimento: ");
        String dataNascStr = scnString.nextLine();

        System.out.println("Informe o sexo (M/F): ");
        String sexo = scnString.nextLine();
        Sexo sexo2;
        if (sexo.toUpperCase().contains("M")) {
            sexo2 = Sexo.MASCULINO;
        } else if (sexo.toUpperCase().contains("F")) {
            sexo2 = Sexo.FEMININO;
        } else {
            sexo2 = Sexo.INTERSEXO;
        }

        Date dataNasc = null;
        try {
            dataNasc = sdf.parse(dataNascStr);
        } catch (Exception e) {
            dataNasc = new Date();
            System.out.println("Erro ao converter a data");
        }
        Endereco endereco = LeEndereco();
        return new Paciente(numCNS, nome, nomeMae, dataNasc, endereco, telefone, sexo2);
    }

    static Endereco LeEndereco() {
        System.out.println("Informe o logradouro: ");
        String logradouro = scnString.nextLine();

        System.out.println("Informe o bairro: ");
        String bairro = scnString.nextLine();

        System.out.println("Informe a cidade: ");
        String cidade = scnString.nextLine();

        System.out.println("Informe a UF: ");
        String UF = scnString.nextLine();

        System.out.println("Informe o CEP: ");
        String cep = scnString.nextLine();

        System.out.println("Informe o numero: ");
        Integer numero = scnInt.nextInt();
        Endereco e = new Endereco(logradouro, numero, bairro, cidade, cep, UF);
        return e;

    }

    static Paciente LePaciente(Paciente p) {
        if (p == null)
            return null;
        System.out.println("Informe o numero CNS: " + p.getNumCNS());
        long numCNS = scnLong.nextLong();

        System.out.println("Informe o nome: " + p.getNome());
        String nome = scnString.nextLine();

        System.out.println("Informe o nome da mae: " + p.getNomeMae());
        String nomeMae = scnString.nextLine();
        System.out.println("Informe o telefone: " + p.getTelefone());
        String telefone = scnString.nextLine();

        System.out.println("Informe a data de nascimento: " + p.getDataNasc().toString());
        String dataNascStr = scnString.nextLine();

        Date dataNasc = null;
        try {
            dataNasc = sdf.parse(dataNascStr);
        } catch (Exception e) {
            dataNasc = new Date();
            System.out.println("Erro ao converter a data");
        }
        Endereco endereco = LeEndereco(p.getEndereco());
        return new Paciente(p.getIdPaciente(), numCNS, nome, nomeMae, dataNasc, endereco, telefone, p.getSexo());
    }

    static Endereco LeEndereco(Endereco e) {
        if (e == null)
            return null;
        System.out.println("Informe o logradouro: " + e.getLogradouro());
        String logradouro = scnString.nextLine();

        System.out.println("Informe o bairro: " + e.getBairro());
        String bairro = scnString.nextLine();

        System.out.println("Informe a cidade: " + e.getCidade());
        String cidade = scnString.nextLine();

        System.out.println("Informe a UF: " + e.getUF());
        String UF = scnString.nextLine();

        System.out.println("Informe o CEP: " + e.getCep());
        String cep = scnString.nextLine();

        System.out.println("Informe o numero: " + e.getNumero());
        Integer numero = scnInt.nextInt();
        Endereco retorno = new Endereco(logradouro, numero, bairro, cidade, cep, UF);
        return retorno;

    }

    static Anamnese LeAnamnese(Anamnese a, Paciente p) {
        if (a == null)
            a = new Anamnese();
        if (p == null)
            return null;
        String motivo;
        String relato;
        String diagnostico;

        System.out.println("Informe o motivo: " + a.getMotivo());
        motivo = scnString.nextLine();
        System.out.println("Informe o relato: " + a.getRelato());
        relato = scnString.nextLine();
        System.out.println("Informe o diagnostico");
        diagnostico = scnString.nextLine();
        if (a.getId() > 0)
            return new Anamnese(a.getId(), a.getPaciente(), motivo, relato, diagnostico);
        else
            return new Anamnese(p, motivo, relato, diagnostico);

    }

    static String subString(String parametro) {
        int tamanho = 17;
        char[] ret = new char[tamanho];
        for (int i = 0; i < tamanho - 2; i++) {
            try {
                ret[i] = parametro.charAt(i);
            } catch (Exception e) {
                ret[i] = ' ';
            }

        }
        ret[tamanho - 1] = ' ';
        ret[tamanho - 2] = ' ';
        String retorno = new String(ret);
        return retorno;
    }
}
