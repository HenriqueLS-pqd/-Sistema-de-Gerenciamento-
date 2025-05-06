import java.util.ArrayList;

public class Emprestimo {

    private String funcionario;
    private String epi;
    private String data;

    public Emprestimo(String funcionario, String epi, String data) {
        this.funcionario = funcionario;
        this.epi = epi;
        this.data = data;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getEpi() {
        return epi;
    }

    public void setEpi(String epi) {
        this.epi = epi;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Funcionário: " + funcionario + " - EPI: " + epi + " - Data: " + data;
    }

    private static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public static void cadastrarEmprestimo(String funcionario, String epi, String data) {
        if (funcionario.isEmpty() || epi.isEmpty() || data.isEmpty()) {
            System.out.println("Todos os campos devem ser preenchidos.");
            return;
        }
        emprestimos.add(new Emprestimo(funcionario, epi, data));
        System.out.println("Empréstimo cadastrado com sucesso.");
    }

    public static void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Não há empréstimos cadastrados.");
        } else {
            System.out.println("\n--- Lista de Empréstimos ---");
            for (int i = 0; i < emprestimos.size(); i++) {
                System.out.println(i + " - " + emprestimos.get(i));
            }
        }
    }

    public static void atualizarEmprestimo(int i, String novoFuncionario, String novoEpi, String novaData) {
        if (i >= 0 && i < emprestimos.size()) {
            Emprestimo emp = emprestimos.get(i);
            emp.setFuncionario(novoFuncionario);
            emp.setEpi(novoEpi);
            emp.setData(novaData);
            System.out.println("Empréstimo atualizado com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void removerEmprestimo(int i) {
        if (i >= 0 && i < emprestimos.size()) {
            emprestimos.remove(i);
            System.out.println("Empréstimo removido com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
}