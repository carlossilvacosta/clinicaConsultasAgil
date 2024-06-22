package application;

import java.util.Scanner;

import entities.Consulta;
import entities.Paciente;
import services.ConsultaService;
import services.PacienteService;
import util.DateUtils;

public class Main {
    private static PacienteService pacienteService = new PacienteService();
    private static ConsultaService consultaService = new ConsultaService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nClínica de Consultas Ágil");
            System.out.println("1. Cadastrar um paciente");
            System.out.println("2. Marcar consulta");
            System.out.println("3. Cancelar consulta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    cadastrarPaciente(scanner);
                    break;
                case 2:
                    marcarConsulta(scanner);
                    break;
                case 3:
                    cancelarConsulta(scanner);
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 4);

        scanner.close();
    }

    private static void cadastrarPaciente(Scanner scanner) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone do paciente: ");
        String telefone = scanner.nextLine();

        if (pacienteService.cadastrarPaciente(nome, telefone)) {
            System.out.println("Paciente cadastrado com sucesso.");
        } else {
            System.out.println("Paciente já cadastrado!");
        }
    }

    private static void marcarConsulta(Scanner scanner) {
        if (pacienteService.getPacientes().isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        System.out.println("Selecione o paciente:");
        pacienteService.listarPacientes();
        int pacienteIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (pacienteIndex < 0 || pacienteIndex >= pacienteService.getPacientes().size()) {
            System.out.println("Paciente inválido.");
            return;
        }

        Paciente paciente = pacienteService.getPacientes().get(pacienteIndex);

        System.out.print("Dia da consulta (dd/MM/yyyy): ");
        String dia = scanner.nextLine();
        System.out.print("Hora da consulta (HH:mm): ");
        String hora = scanner.nextLine();
        System.out.print("Especialidade da consulta: ");
        String especialidade = scanner.nextLine();

        if (!DateUtils.isDataFutura(dia)) {
            System.out.println("A data da consulta deve ser futura.");
            return;
        }

        if (consultaService.marcarConsulta(paciente, dia, hora, especialidade)) {
            System.out.println("Consulta marcada com sucesso.");
        } else {
            System.out.println("Horário indisponível.");
        }
    }

    private static void cancelarConsulta(Scanner scanner) {
        if (consultaService.getConsultas().isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }

        System.out.println("Selecione a consulta para cancelar:");
        consultaService.listarConsultas();
        int consultaIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (consultaIndex < 0 || consultaIndex >= consultaService.getConsultas().size()) {
            System.out.println("Consulta inválida.");
            return;
        }

        Consulta consulta = consultaService.getConsultas().get(consultaIndex);

        System.out.printf("Consulta agendada em %s às %s com %s. Confirmar cancelamento? (s/n): ",
                consulta.getDia(), consulta.getHora(), consulta.getEspecialidade());
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("s")) {
            consultaService.cancelarConsulta(consultaIndex);
            System.out.println("Consulta cancelada com sucesso.");
        }
    }
}
