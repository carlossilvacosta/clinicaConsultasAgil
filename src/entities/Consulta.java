package entities;


public class Consulta {
    private Paciente paciente;
    private String dia;
    private String hora;
    private String especialidade;

    public Consulta(Paciente paciente, String dia, String hora, String especialidade) {
        this.paciente = paciente;
        this.dia = dia;
        this.hora = hora;
        this.especialidade = especialidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return String.format("%s: %s às %s - %s", paciente.getNome(), dia, hora, especialidade);
    }
}
