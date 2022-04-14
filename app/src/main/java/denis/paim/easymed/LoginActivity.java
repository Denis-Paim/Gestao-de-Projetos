package denis.paim.easymed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView txtCadastrar;
    private TextView btnEntrar;
    private EditText usuarioNome;
    private EditText usuarioCpf;
    private EditText usuarioSenha;
    private EditText edEmail;
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usuarioNome = findViewById(R.id.edNome);
        usuarioSenha =  findViewById(R.id.edSenha);
        edEmail = findViewById(R.id.edEmail);
        txtCadastrar = findViewById(R.id.txtCadastrar);
        btnEntrar = findViewById(R.id.btnEntrar);


        txtCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoginActivity.this, CriarContaActivity.class);
                startActivity(intent);

            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                autenticaUsuario(usuarioNome.getText().toString(), usuarioSenha.getText().toString());

            }
        });

    }

    private void autenticaUsuario(String nome, String senha){
        usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);

        usuarioDAO = new UsuarioDAO();
        boolean resultado = usuarioDAO.autenticarUsuario(this, usuario);

        if (resultado == true){
            Intent intent = new Intent(LoginActivity.this, EspecialidadesActivity.class);
            startActivity(intent);
            finish();
        }else{
            usuarioNome.setText("");
            usuarioSenha.setText("");
            usuarioNome.requestFocus();
            Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_LONG).show();

        }

    }
}