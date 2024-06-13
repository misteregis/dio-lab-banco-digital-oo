public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;

    // Construtor padrão
    public Cliente() {}

    // Construtor com parâmetros
    public Cliente(String nome, String cpf, String endereco, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para exibir informações do cliente
    public void exibirInformacoes() {
        System.out.println("=== Informações do Cliente ===");
        System.out.println(" Nome: " + this.nome);
        System.out.println(" CPF: " + this.cpf);
        System.out.println(" Endereço: " + this.endereco);
        System.out.println(" Telefone: " + this.telefone);
        System.out.println(" Email: " + this.email);
        System.out.println("=============================");
    }

    // Método para validar o CPF (apenas exemplo de validação simples)
    public boolean validarCpf() {
        return this.cpf != null && this.cpf.matches("\\d{11}");
    }

    // Método para formatar o telefone (apenas exemplo de formatação simples)
    public String formatarTelefone() {
        if (this.telefone != null && this.telefone.length() == 11) {
            return String.format("(%s) %s-%s", this.telefone.substring(0, 2), this.telefone.substring(2, 7), this.telefone.substring(7));
        }
        return this.telefone;
    }

    // Sobrescrita do método toString para facilitar a exibição de informações
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
