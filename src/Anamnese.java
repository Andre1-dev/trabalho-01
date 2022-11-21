public class Anamnese {
    private int id;
    private Paciente paciente;
    private String motivo;
    private String relato;
    private String diagnostico;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public String getRelato() {
        return this.relato;
    }

    public String getDiagnostico() {
        return this.diagnostico;
    }

    public Anamnese() {
        motivo = "";
        relato = "";
        diagnostico = "";
        paciente = new Paciente();
    }

    public Anamnese(int id, Paciente paciente, String motivo, String relato, String diagnostico) {
        if (paciente != null) {
            this.id = id;
            this.paciente = paciente;
            this.motivo = motivo;
            this.relato = relato;
            this.diagnostico = diagnostico;

        }
    }

    public Anamnese(Paciente paciente, String motivo, String relato, String diagnostico) {
        if (paciente != null) {
            this.paciente = paciente;
            this.motivo = motivo;
            this.relato = relato;
            this.diagnostico = diagnostico;
            this.id = 0;

        }
    }

}
