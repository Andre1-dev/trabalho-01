public class Sistema {
    Paciente[] pacientes = new Paciente[100];
    Anamnese[] anamneses = new Anamnese[100];
    Usuario[] users = new Usuario[10];
    int idCountPaciente = 1;
    int idCountAnamnese = 1;

    private Sistema() {
    }

    private static Sistema sistema = null;

    public static Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema();
            return sistema;
        } else {
            return sistema;
        }
    }

    // #region
    boolean adicionarUsuario(Usuario u) {
        if (u == null)
            return false;
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = u;
                return true;
            }
        }
        aumentarUsuarios();
        return false;
    }

    boolean editarUsuario(Usuario u) {
        if (u == null)
            return false;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getId() == u.getId()) {
                    users[i] = u;
                    return true;

                }
            }
        }
        return false;
    }

    Usuario getUsuarioById(int id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getId() == id) {
                    return users[i];
                }

            }
        }
        return null;
    }

    boolean deletarUsuario(Usuario u) {
        if (u == null)
            return false;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getId() == u.getId()) {
                    users[i] = null;
                    return true;
                }

            }
        }
        return false;
    }

    Usuario returnTipoUsuario(String nomeUsuario, String senha) {

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                if (users[i].getSenha().equals(senha) && users[i].getNomeUsuario().equals(nomeUsuario))
                    return users[i];
        }
        return null;

    }

    private void aumentarUsuarios() {
        Usuario[] aux = new Usuario[users.length + 10];
        for (int i = 0; i < users.length; i++) {
            aux[i] = users[i];
        }
        users = aux;
    }
    // #endregion

    // #region Pacientes
    boolean salvarPaciente(Paciente p) {

        if (p == null)
            return false;
        if (p.getIdPaciente() == 0) {
            if (verificaHomonimos(p))
                return false;

            for (int i = 0; i < pacientes.length; i++) {
                if (pacientes[i] == null) {
                    p.setIdPaciente(idCountPaciente);
                    idCountPaciente++;
                    pacientes[i] = p;
                    return true;
                }
            }
            aumentarPacientes();
            salvarPaciente(p);
        } else {
            for (int i = 0; i < pacientes.length; i++) {
                if (pacientes[i] != null) {
                    if (pacientes[i].getIdPaciente() == p.getIdPaciente()) {
                        pacientes[i] = p;
                        return true;
                    }

                }
            }
            return false;
        }

        return false;
    }

    boolean excluirPaciente(long numCNS) {
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                if (pacientes[i].getNumCNS() == numCNS) {
                    pacientes[i] = null;
                    return true;
                }

            }
        }
        return false;
    }

    boolean excluirPacienteById(int id) {
        if (buscaAnamneses(id)[0] != null)
            return false;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                if (pacientes[i].getIdPaciente() == id) {
                    pacientes[i] = null;
                    return true;
                }

            }
        }
        return false;
    }

    Paciente[] returnPacientes() {
        return pacientes;
    }

    Paciente[] pesquisarPacientes(String nome) {
        Paciente[] pacientesRetorno = new Paciente[pacientes.length];
        int pos = 0;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                if (pacientes[i].getNome().contains(nome.toUpperCase())) {
                    pacientesRetorno[pos] = pacientes[i];
                    pos++;
                }

            }
        }
        return pacientesRetorno;
    }

    Paciente pesquisaPacienteById(int id) {
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                if (pacientes[i].getIdPaciente() == id) {
                    return pacientes[i];
                }

            }
        }
        return null;
    }

    private void aumentarPacientes() {
        Paciente[] aux = new Paciente[pacientes.length + 20];
        for (int i = 0; i < pacientes.length; i++) {
            aux[i] = pacientes[i];
        }
        pacientes = aux;
    }

    private boolean verificaHomonimos(Paciente p) {
        if (p == null) {
            return false;
        }
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i] != null) {
                if (pacientes[i].getNome().toUpperCase().equals(p.getNome().toUpperCase())
                        && pacientes[i].getNomeMae().toUpperCase().equals(p.getNomeMae().toUpperCase()))
                    return true;
            }
        }
        return false;
    }

    // #endregion
    // #region Anamneses
    boolean saveAnamnese(Anamnese a) {
        if (a == null)
            return false;

        if (a.getId() > 0) {
            for (int i = 0; i < anamneses.length; i++) {
                if (anamneses[i] != null) {
                    if (anamneses[i].getId() == a.getId()) {
                        anamneses[i] = a;
                        return true;
                    }

                }
            }
        } else {
            for (int i = 0; i < anamneses.length; i++) {
                if (anamneses[i] == null) {
                    a.setId(idCountAnamnese);
                    anamneses[i] = a;
                    idCountAnamnese++;
                    return true;

                }
            }
            aumentarAnamese();
            saveAnamnese(a);
        }
        return false;
    }

    public Boolean excluirAnamnese(Anamnese a) {
        if (a == null)
            return false;
        for (int i = 0; i < anamneses.length; i++) {
            if (anamneses[i] != null) {
                if (anamneses[i].getId() == a.getId()) {
                    anamneses[i] = null;
                    return true;
                }

            }
        }
        return false;
    }

    private void aumentarAnamese() {
        Anamnese[] aux = new Anamnese[anamneses.length + 20];
        for (int i = 0; i < anamneses.length; i++) {
            aux[i] = anamneses[i];
        }
        anamneses = aux;
    }

    public Anamnese[] buscaAnamneses(Paciente buscaPaciente) {
        Anamnese[] anamnesesRetorno = new Anamnese[anamneses.length];
        int pos = 0;
        for (int i = 0; i < anamneses.length; i++) {
            if (anamneses[i] != null) {
                if (anamneses[i].getPaciente().getIdPaciente() == buscaPaciente.getIdPaciente()) {
                    anamnesesRetorno[pos] = anamneses[i];
                    pos++;
                }

            }
        }
        return anamnesesRetorno;
    }

    public Anamnese[] buscaAnamneses(int id) {
        Anamnese[] anamnesesRetorno = new Anamnese[anamneses.length];
        int pos = 0;
        for (int i = 0; i < anamneses.length; i++) {
            if (anamneses[i] != null) {
                if (anamneses[i].getPaciente().getIdPaciente() == id) {
                    anamnesesRetorno[pos] = anamneses[i];
                    pos++;
                }

            }
        }
        return anamnesesRetorno;
    }

    public Anamnese getAnamneseById(int id) {

        for (int i = 0; i < anamneses.length; i++) {
            if (anamneses[i] != null) {
                if (anamneses[i].getId() == id) {
                    return anamneses[i];
                }

            }
        }
        return null;
    }

    // #endregion
}
