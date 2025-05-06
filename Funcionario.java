import java.util.ArrayList;

public class Funcionario {

    private String nome;
    private String cargo;
    private String matricula;

    public Funcionario(String nome, String cargo, String matricula) {
        this.nome = nome;
        this.cargo = cargo;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Cargo: " + cargo + " - Matrícula: " + matricula;
    }

    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void cadastrarFuncionario(String nome, String cargo, String matricula) {
        if (nome.isEmpty() || cargo.isEmpty() || matricula.isEmpty()) {
            System.out.println("Todos os campos devem ser preenchidos.");
            return;
        }
        funcionarios.add(new Funcionario(nome, cargo, matricula));
        System.out.println("Funcionário cadastrado com sucesso.");
    }

    public static void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("\n--- Lista de Funcionários ---");
            for (int i = 0; i < funcionarios.size(); i++) {
                System.out.println(i + " - " + funcionarios.get(i));
            }
        }
    }

    public static void atualizarFuncionario(int i, String novoNome, String novoCargo, String novaMatricula) {
        if (i >= 0 && i < funcionarios.size()) {
            Funcionario func = funcionarios.get(i);
            func.setNome(novoNome);
            func.setCargo(novoCargo);
            func.setMatricula(novaMatricula);
            System.out.println("Funcionário atualizado com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void removerFuncionario(int i) {
        if (i >= 0 && i < funcionarios.size()) {
            funcionarios.remove(i);
            System.out.println("Funcionário removido com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
}