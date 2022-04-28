package denis.paim.easymed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultasMarcadasActivity extends AppCompatActivity {

    TextView txtNomeUsuarioConsulta;
    TextView txtNomeMedicoConsulta;
    TextView txtEspecialidadeConsulta;
    TextView txtDataConsulta;
    TextView txtHorarioConsulta;
    TextView txtSalaConsulta;
    TextView txtMarcarConsulta;

    String nomeUsuario;
    String acao;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    private String text;

    Consulta consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas_marcadas);


        txtNomeUsuarioConsulta = findViewById(R.id.txtNomeUsuarioConsulta);
        txtNomeMedicoConsulta = findViewById(R.id.txtNomeMedicoConsulta);
        txtEspecialidadeConsulta = findViewById(R.id.txtEspecialidadeConsulta);
        txtHorarioConsulta = findViewById(R.id.txtHorarioConsulta);
        txtSalaConsulta = findViewById(R.id.txtSalaConsulta);
        txtDataConsulta = findViewById(R.id.txtDataConsulta);


        Bundle extras = getIntent().getExtras();



        acao = getIntent().getStringExtra("acao");
        if(acao.equals("nome")){
            nomeUsuario = extras.getString("nomeUsuario");
            //txtNomeUsuarioConsulta.setText("Bem Vindo, " + nomeUsuario + ".");
            txtNomeMedicoConsulta.setText("Você ainda não possui consultas agendadas.");


            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString(TEXT, nomeUsuario);
            editor.apply();

            txtEspecialidadeConsulta.setVisibility(View.GONE);
            txtSalaConsulta.setVisibility(View.GONE);
            txtHorarioConsulta.setVisibility(View.GONE);
            txtDataConsulta.setVisibility(View.GONE);

        }

        if (acao.equals("outros")){
            txtNomeUsuarioConsulta.setText(nomeUsuario);
            txtNomeMedicoConsulta.setText(extras.getString("nomeMed"));
            txtEspecialidadeConsulta.setText(extras.getString("especialidadeMed"));
            txtSalaConsulta.setText(extras.getString("salaConsul"));
            txtHorarioConsulta.setText(extras.getString("horario"));
            txtDataConsulta.setText(extras.getString("dataConsul"));


        }



        //carregarConsultas();


        txtMarcarConsulta = findViewById(R.id.txtMarcarConsulta);
        txtMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), EspecialidadesActivity.class);
                startActivity(intent);

            }
        });

        loadData();
        updateViews();


    }

    public void loadData(){
        SharedPreferences sharedPreferences  = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
    }

    public void updateViews(){
        txtNomeUsuarioConsulta.setText(text);
    }

//    public void confirmarConsulta(){
//
//        Bundle extras = getIntent().getExtras();
//
//        consulta = new Consulta();
//        consulta.setUsuarioNome(extras.getString("nomeUsuario"));
//        ConsultaDAO.marcarConsulta(this, consulta);
//
//
//        Toast.makeText(this, "Consulta marcada com sucesso!", Toast.LENGTH_LONG ).show();
//    }

//    private void carregarConsultas(){
//        String usuarioNome;
//        usuarioNome = getIntent().getStringExtra("nomeUsuario");
//        consulta = ConsultaDAO.buscarConsultaByNome(this, usuarioNome);
//        txtNomeUsuarioConsulta.setText( consulta.getUsuarioNome() );
//        txtNomeMedicoConsulta.setText( consulta.getMedicoNome() );
//        txtEspecialidadeConsulta.setText( consulta.getEspecialidade() );
//
//    }

}