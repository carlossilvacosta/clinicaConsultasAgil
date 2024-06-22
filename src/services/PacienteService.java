package services;

import java.util.ArrayList;
import java.util.List;

import entities.Paciente;

public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();

    public boolean cadastrarPaciente(String nome, String telefone) {
        for (Paciente paciente : pacientes) {
            if (paciente.getTelefone().equals(telefone)) {
                return false;
            }
        }
        pacientes.add(new Paciente(nome, telefone));
        return true;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void listarPacientes() {
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i));
        }
    }
}
