# :computer: Sistema de Clínica de Consultas Ágil

![Java](https://img.shields.io/badge/java-%23FF0000.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)

Application built with Java to manage a clinical appointment system

## :scroll: Desafio Aceleradora Ágil

### Desenvolver um sistema de clínica de consultas. Para isso, desenvolva as seguintes funcionalidades, que devem ser apresentadas para o usuário através de um menu via terminal:

- **Cadastrar um paciente:** O programa solicita o nome e o telefone do usuário. Após o
cadastro, exibe a mensagem "Paciente cadastrado com sucesso" e adiciona o paciente à
lista de Pacientes Cadastrados. Em seguida, retorna ao menu principal.

- **Marcações de consultas:** Ao selecionar essa opção, o programa exibe uma lista
numerada dos pacientes cadastrados. Ao escolher o número correspondente a um
paciente, solicita o dia, a hora e a especialidade desejada para a consulta. Após o envio
desses dados, o agendamento é adicionado à lista de agendamentos e o programa
retorna ao menu principal.

- **Cancelamento de consultas:** Ao selecionar essa opção, o programa exibe uma lista
numerada dos agendamentos existentes. Ao escolher o número correspondente ao
agendamento que deseja remarcar, é exibida uma mensagem informando a data, a hora e
a especialidade da consulta agendada. Nesse momento, o usuário pode optar por
cancelar a consulta. Ao confirmar o cancelamento, o agendamento é removido da lista e o
programa retorna ao menu principal.

- **Sair:** O programa encerra a execução.

### Tratamento de erros:

- O paciente não pode ser cadastrado mais de uma vez. Para evitar duplicidade,
garanta que o número de telefone seja diferente para cada cadastro. Caso ocorra
uma tentativa de cadastro duplicado, exiba a mensagem "Paciente já cadastrado!"
e retorne ao menu principal.

- Pacientes não podem marcar consultas em dias e horários já agendados. Verifique
se a data e a hora selecionadas estão disponíveis antes de realizar o
agendamento.

- Consultas não podem ser marcadas antes da data atual. Certifique-se de que o
usuário não possa agendar consultas retroativas.
