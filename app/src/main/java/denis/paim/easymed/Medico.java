package denis.paim.easymed;

public class Medico {

    String nome, especialidade, sala;

    public Medico() {
    }


    public Medico(String nome, String especialidade, String sala) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
