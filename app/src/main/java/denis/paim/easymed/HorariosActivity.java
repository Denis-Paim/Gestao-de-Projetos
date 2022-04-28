package denis.paim.easymed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class HorariosActivity extends AppCompatActivity {


    Spinner spHorarios;
    List<String> horarios;
    TextView nomeMedico;
    TextView especialidadeMedico;
    TextView txtMarcarConsulta;
    TextView salaConsulta;

    String dataAtual;
    String diaDaSemanaFinal;
    String dataFinal;

    String horario;

    AutoCompleteTextView autoCompleteTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios);


        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE, 0);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.WEEK_OF_MONTH, 1);

        // on below line we are setting up our horizontal calendar view and passing id our calendar view to it.
        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                // on below line we are adding a range
                // as start date and end date to our calendar.
                .range(startDate, endDate)
                // on below line we are providing a number of dates
                // which will be visible on the screen at a time.
                .datesNumberOnScreen(5)
                // at last we are calling a build method
                // to build our horizontal recycler view.
                .build();
        // on below line we are setting calendar listener to our calendar view.
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {


                dataAtual = String.valueOf(date);
                String[] dataArray = dataAtual.split(",");
                String[] diaDaSemana = String.valueOf(dataArray[17]).split("=");
                String[] mes = String.valueOf(dataArray[14]).split("=");
                String[] ano = String.valueOf(dataArray[13]).split("=");
                diaDaSemanaFinal = diaDaSemana[1];
                String anoString = ano[1];
                int mesFinal = Integer.parseInt(mes[1]) + 1;
                dataFinal = diaDaSemanaFinal + " / " + String.valueOf(mesFinal) + " / " + anoString;

                // on below line we are printing date
                // in the logcat which is selected.
                // Log.e("TAG", "CURRENT DATE IS " + date);

                //Toast.makeText(getApplicationContext(), "Data: " + dataFinal, Toast.LENGTH_LONG).show();

                //Toast.makeText(getApplicationContext(), "Data: " + Arrays.toString(new String[]{dataArray[17]}) + "Position: " + position + " ", Toast.LENGTH_LONG).show();

            }
        });
//
        nomeMedico = findViewById(R.id.txtMedicoTelaHorario);
        especialidadeMedico = findViewById(R.id.txtExpecialidadeTelaHorario);
        salaConsulta = findViewById(R.id.txtSala);

        Bundle extras = getIntent().getExtras();
        nomeMedico.setText(extras.getString("nomeMedico"));
        especialidadeMedico.setText(extras.getString("especialidadeMedico"));

//        spHorarios = findViewById(R.id.spHorarios);

        horarios = new ArrayList<>();
//        horarios.add("Horários");
        horarios.add("8:00");
        horarios.add("8:30");
        horarios.add("9:00");
        horarios.add("9:30");
        horarios.add("10:00");
        horarios.add("10:30");
        horarios.add("11:00");
        horarios.add("11:30");

        autoCompleteTxt = findViewById(R.id.auto_complete_txt2);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(HorariosActivity.this, R.layout.list_item, horarios);
        //arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        autoCompleteTxt.setAdapter(arrayAdapter);


//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(HorariosActivity.this, R.layout.item, horarios);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spHorarios.setAdapter(arrayAdapter);

//        spHorarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                horario = spHorarios.getSelectedItem().toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                horario = adapterView.getItemAtPosition(i).toString();

            }
        });


        String nomeMed = extras.getString("nomeMedico");
        String especialidadeMed = extras.getString("especialidadeMedico");
        String sala = extras.getString("salaConsulta");


        txtMarcarConsulta = findViewById(R.id.txtConfirmarConsulta);
        txtMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Consulta agendada com sucesso.", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getApplicationContext(), ConsultasMarcadasActivity.class);
                intent.putExtra("acao", "outros");
                intent.putExtra("nomeMed", nomeMed);
                intent.putExtra("especialidadeMed", especialidadeMed);
                intent.putExtra("salaConsul", sala);
                intent.putExtra("horario", horario);
                intent.putExtra("dataConsul", dataFinal);

                startActivity(intent);

            }
        });


    }

//    public void confirmarConsulta(){
//
//        Bundle extras = getIntent().getExtras();
//
//        consulta = new Consulta();
//        consulta.setMedicoNome(extras.getString("nomeMedico"));
//        consulta.setEspecialidade(extras.getString("especialidadeMedico"));
//        ConsultaDAO.editar(this, consulta);
//
//
//        Toast.makeText(this, "Consulta marcada com sucesso!", Toast.LENGTH_LONG ).show();
//    }


}