package denis.paim.easymed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class HorariosActivity extends AppCompatActivity {

//    RecyclerView recyclerView;
//    HorarioAdapter horarioAdapter;
//    View view;

    Spinner spHorarios;
    List<String> horarios;
    TextView nomeMedico;
    TextView especialidadeMedico;
    TextView txtMarcarConsulta;

    Calendar dataAtual;

    Consulta consulta;


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

                dataAtual = date;
                // on below line we are printing date
                // in the logcat which is selected.
                // Log.e("TAG", "CURRENT DATE IS " + date);
                // Toast.makeText(getApplicationContext(), "Data: " + date + "Position: " + position + " ", Toast.LENGTH_SHORT).show();

            }
        });

        nomeMedico = findViewById(R.id.txtMedicoTelaHorario);
        especialidadeMedico = findViewById(R.id.txtExpecialidadeTelaHorario);

        Bundle extras = getIntent().getExtras();
        nomeMedico.setText(extras.getString("nomeMedico"));
        especialidadeMedico.setText(extras.getString("especialidadeMedico"));

        spHorarios = findViewById(R.id.spHorarios);

        horarios = new ArrayList<>();
        horarios.add("Horários");
        horarios.add("8:00");
        horarios.add("8:30");
        horarios.add("9:00");
        horarios.add("9:30");
        horarios.add("10:00");
        horarios.add("10:30");
        horarios.add("11:00");
        horarios.add("11:30");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(HorariosActivity.this, R.layout.item, horarios);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spHorarios.setAdapter(arrayAdapter);


        txtMarcarConsulta = findViewById(R.id.txtConfirmarConsulta);
        txtMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                confirmarConsulta();

                Intent intent = new Intent(getApplicationContext(), ConsultasMarcadasActivity.class);
                startActivity(intent);

            }
        });


    }

    public void confirmarConsulta(){

        Bundle extras = getIntent().getExtras();

        consulta = new Consulta();
        consulta.setMedicoNome(extras.getString("nomeMedico"));
        consulta.setEspecialidade(extras.getString("especialidadeMedico"));
        ConsultaDAO.marcarConsulta(this, consulta);


        Toast.makeText(this, "Consulta marcada com sucesso!", Toast.LENGTH_LONG ).show();
    }


}