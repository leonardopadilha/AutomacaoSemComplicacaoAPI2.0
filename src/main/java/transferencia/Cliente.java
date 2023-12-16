package transferencia;

public class Cliente {
    private String nome;
    private String cpf;
    private String rg;

    public Cliente(String nome, String cpf, String rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public String getRG() {
        return rg;
    }
}
