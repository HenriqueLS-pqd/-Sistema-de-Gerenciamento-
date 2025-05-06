import java.util.ArrayList;
import java.util.Scanner;

public class SistemadeGerenciamento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> epis = new ArrayList<>();
        ArrayList<String> funcionarios = new ArrayList<>();
        ArrayList<String> emprestimos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1. Módulo de EPIs");
            System.out.println("2. Módulo de Funcionários");
            System.out.println("3. Módulo de Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    submenuCRUD(epis, "EPI", scanner, true);
                    break;
                case 2:
                    submenuCRUD(funcionarios, "Funcionário", scanner, false);
                    break;
                case 3:
                    submenuCRUD(emprestimos, "Empréstimo", scanner, false);
                    break;
                case 0:
                    System.out.println(" Saindo do sistema...");
                    break;
                default:
                    System.out.println(" Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void submenuCRUD(ArrayList<String> lista, String nomeModulo, Scanner scanner, boolean usarStringComposta) {
        int opcao;
        do {
            System.out.println("\n=== " + nomeModulo + "s ===");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Remover");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1: // Cadastrar
                    String entrada;
                    do {
                        if (usarStringComposta) {
                            System.out.print("Digite os dados do " + nomeModulo + " (ex: Capacete - 20 unidades - Proteção para a cabeça): ");
                        } else {
                            System.out.print("Digite o nome do " + nomeModulo + ": ");
                        }
                        entrada = scanner.nextLine().trim();

                        if (entrada.isEmpty()) {
                            System.out.println(" Os dados não podem estar vazios. Tente novamente.");
                        }
                    } while (entrada.isEmpty());

                    lista.add(entrada);
                    System.out.println(" " + nomeModulo + " cadastrado com sucesso!");
                    break;

                case 2: // Listar
                    if (lista.isEmpty()) {
                        System.out.println(" Nenhum " + nomeModulo + " cadastrado.");
                    } else {
                        System.out.println("\n--- Lista de " + nomeModulo + "s ---");
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(i + ". " + lista.get(i));
                        }
                    }
                    break;

                case 3: // Atualizar
                    if (lista.isEmpty()) {
                        System.out.println(" Lista vazia. Nada para atualizar.");
                        break;
                    }

                    System.out.print("Digite o índice do " + nomeModulo + " para atualizar: ");
                    int indexAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    if (indexAtualizar >= 0 && indexAtualizar < lista.size()) {
                        String novoValor;
                        do {
                            System.out.print("Digite os novos dados: ");
                            novoValor = scanner.nextLine().trim();
                            if (novoValor.isEmpty()) {
                                System.out.println(" Os dados não podem estar vazios. Tente novamente.");
                            }
                        } while (novoValor.isEmpty());

                        lista.set(indexAtualizar, novoValor);
                        System.out.println(" " + nomeModulo + " atualizado com sucesso!");
                    } else {
                        System.out.println(" Índice inválido.");
                    }
                    break;

                case 4: // Remover
                    if (lista.isEmpty()) {
                        System.out.println(" Lista vazia. Nada para remover.");
                        break;
                    }

                    System.out.print("Digite o índice do " + nomeModulo + " para remover: ");
                    int indexRemover = scanner.nextInt();
                    scanner.nextLine();

                    if (indexRemover >= 0 && indexRemover < lista.size()) {
                        lista.remove(indexRemover);
                        System.out.println(" " + nomeModulo + " removido com sucesso!");
                    } else {
                        System.out.println(" Índice inválido.");
                    }
                    break;

                case 0:
                    System.out.println(" Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}


