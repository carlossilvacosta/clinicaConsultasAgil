package services;

import java.util.ArrayList;
import java.util.List;

import entities.Consulta;
import entities.Paciente;

public class ConsultaService {
    private List<Consulta> consultas = new ArrayList<>();

    public boolean marcarConsulta(Paciente paciente, String dia, String hora, String especialidade) {
        for (Consulta consulta : consultas) {
            if (consulta.getDia().equals(dia) && consulta.getHora().equals(hora)) {
                return false;
            }
        }
        consultas.add(new Consulta(paciente, dia, hora, especialidade));
        return true;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void listarConsultas() {
        for (int i = 0; i < consultas.size(); i++) {
            System.out.println((i + 1) + ". " + consultas.get(i));
        }
    }

    public void cancelarConsulta(int index) {
        consultas.remove(index);
    }
}
