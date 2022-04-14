package denis.paim.easymed;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CriarContaActivity extends AppCompatActivity {

    private TextView btnCadastrar;
    private Usuario usuario;
    private EditText usuarioNome;
    private EditText usuarioCpf;
    private EditText edtelefone;
    private EditText edEndereco;
    private EditText edDataNascimento;
    private EditText edEmail;
    private EditText usuarioSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        usuarioNome = findViewById(R.id.edCriarNome);
        usuarioCpf = findViewById(R.id.edCpf);
        edtelefone = findViewById(R.id.edTelefone);
        edEndereco = findViewById(R.id.edEndereco);
        edDataNascimento = findViewById(R.id.edNascimento);
        edEmail = findViewById(R.id.edEmail);
        usuarioSenha = findViewById(R.id.edPassword);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });
    }

    private void salvar(){
        String nome = usuarioNome.getText().toString();
        String senha = usuarioSenha.getText().toString();
        String telefone = edtelefone.getText().toString();
        String cpf = usuarioCpf.getText().toString();
        String endereco = edEndereco.getText().toString();
        String dataNascimento = edDataNascimento.getText().toString();
        String email = edEmail.getText().toString();


        if (nome.isEmpty() || senha.isEmpty()){
            Toast.makeText(this, "Você deve preencher todos os campos!", Toast.LENGTH_LONG ).show();
        }else{
            usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setCpf(cpf);
            usuario.setTelefone(telefone);
            usuario.setEndereco(endereco);
            usuario.setDataNascimento(dataNascimento);
            usuario.setEmail(email);
            usuario.setSenha(senha);
            UsuarioDAO.inserir(this,usuario);
            Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_LONG ).show();
        }
    }
}
