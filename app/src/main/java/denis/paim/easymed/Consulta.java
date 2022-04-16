package denis.paim.easymed;

public class Consulta {

    public int id;
    public String usuarioNome, medicoNome, data, horario, especialidade, sala, enderecoConsulta;

    public Consulta() {

    }

    public Consulta(int id, String usuarioNome, String medicoNome, String data, String horario, String especialidade, String sala, String enderecoConsulta) {
        this.id = id;
        this.usuarioNome = usuarioNome;
        this.medicoNome = medicoNome;
        this.data = data;
        this.horario = horario;
        this.especialidade = especialidade;
        this.sala = sala;
        this.enderecoConsulta = enderecoConsulta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getMedicoNome() {
        return medicoNome;
    }

    public void setMedicoNome(String medicoNome) {
        this.medicoNome = medicoNome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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

    public String getEnderecoConsulta() {
        return enderecoConsulta;
    }

    public void setEnderecoConsulta(String enderecoConsulta) {
        this.enderecoConsulta = enderecoConsulta;
    }
}
