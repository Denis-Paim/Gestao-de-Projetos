package denis.paim.easymed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConsultasMarcadasActivity extends AppCompatActivity {

    TextView txtNomeUsuarioConsulta;
    TextView txtNomeMedicoConsulta;
    TextView txtEspecialidadeConsulta;
    TextView txtDataConsulta;
    TextView txtHorarioConsulta;
    TextView txtSalaConsulta;
    TextView txtMarcarConsulta;

    Consulta consulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas_marcadas);

        String usuarioNome;
        usuarioNome = getIntent().getStringExtra("nomeUsuario");

        txtNomeUsuarioConsulta = findViewById(R.id.txtNomeUsuarioConsulta);


        txtMarcarConsulta = findViewById(R.id.txtMarcarConsulta);
        txtMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), EspecialidadesActivity.class);
                startActivity(intent);

            }
        });


    }

//    private void carregarConsultas(){
//        String usuarioNome = getIntent().getIntExtra("usuarioNome", 0);
//        consulta = ConsultaDAO.buscarConsultaByNome(this, usuarioNome);
//        etNome.setText( produto.getNome() );
//        String[] categorias = getResources().getStringArray(R.array.categorias);
//        for (int i = 1; i < categorias.length ;i++){
//            if( produto.getCategoria().equals( categorias[i] ) ){
//                spCategorias.setSelection(i);
//                break;
//            }
//        }
//    }

}