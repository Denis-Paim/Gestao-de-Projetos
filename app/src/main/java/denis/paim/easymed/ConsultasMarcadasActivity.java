package denis.paim.easymed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class ConsultasMarcadasActivity extends AppCompatActivity {

    TextView txtMarcarConsulta;
    TextView txtSemAgendamentos;
    TextView usuarioConsulta;

    String nomeUsuario;
    String acao;

    RecyclerView recyclerView;
    ConsultasAdapter consultasAdapter;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas_marcadas);


        txtSemAgendamentos = findViewById(R.id.txtSemAgendamentos);
        txtMarcarConsulta = findViewById(R.id.txtAgendarConsulta);
        usuarioConsulta = findViewById(R.id.usuarioPerfil);


        Bundle extras = getIntent().getExtras();
        nomeUsuario = extras.getString("nomeUsuario");


        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, nomeUsuario);
        editor.apply();


        Usuario usuarioBanco = UsuarioDAO.buscaUsuario(getApplicationContext(), nomeUsuario);
        usuarioConsulta.setText(usuarioBanco.nome);


        txtMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), EspecialidadesActivity.class);
                startActivity(intent);

            }
        });


        acao = getIntent().getStringExtra("acao");
        if (acao.equals("nome")) {
            nomeUsuario = sharedPreferences.getString(TEXT, "");
            usuarioBanco = UsuarioDAO.buscaUsuario(getApplicationContext(), nomeUsuario);

        }

        if (acao.equals("outros")) {
            nomeUsuario = extras.getString("nome");
            usuarioBanco = UsuarioDAO.buscaUsuario(getApplicationContext(), nomeUsuario);

        }


        List consultaLista = ConsultaDAO.buscaPessoaList(getApplicationContext(), usuarioBanco.getNome());
        if (consultaLista.size() == 0) {
            txtSemAgendamentos.setText("Você ainda não possui consultas agendadas.");

        } else {
            txtMarcarConsulta.setText("Agendar Nova Consulta");
            iniciarRecyclerView(consultaLista);
            usuarioBanco = UsuarioDAO.buscaUsuario(getApplicationContext(), nomeUsuario);
            usuarioConsulta.setText(usuarioBanco.nome);

        }

    }


    private void iniciarRecyclerView(List<Consulta> consultaLista) {

        recyclerView = findViewById(R.id.recyclerViewOriginal);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        consultasAdapter = new ConsultasAdapter(getApplicationContext(), consultaLista);
        recyclerView.setAdapter(consultasAdapter);

    }


}