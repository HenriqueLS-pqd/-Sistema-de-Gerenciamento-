import java.util.ArrayList;

public class EPI {

    private String nome;
    private int quantidade;
    private String descricao;


    public EPI(String nome, int quantidade, String descricao) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome + " - " + quantidade + " - " + descricao;  // Atualizando toString para incluir a descrição
    }

    private static ArrayList<EPI> epis = new ArrayList<>();

    public static void cadastrarEpi(String nome, int quantidade, String descricao) {
        epis.add(new EPI(nome, quantidade, descricao));  // Atualizando para incluir a descrição
        System.out.println("EPI cadastrado com sucesso.");
    }

    public static void listarEpis() {
        if (epis.isEmpty()) {
            System.out.println("Não há EPIs cadastrados.");
        } else {
            System.out.println("\n--- Lista de EPIs ---");
            for (int i = 0; i < epis.size(); i++) {
                System.out.println(i + " - " + epis.get(i));
            }
        }
    }

    public static void atualizarEpi(int i, String novoNome, int novaQuantidade, String novaDescricao) {
        if (i >= 0 && i < epis.size()) {
            EPI epi = epis.get(i);
            epi.setNome(novoNome);
            epi.setQuantidade(novaQuantidade);
            epi.setDescricao(novaDescricao);
            System.out.println("EPI atualizado com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void removerEpi(int i) {
        if (i >= 0 && i < epis.size()) {
            epis.remove(i);
            System.out.println("EPI removido com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
}

