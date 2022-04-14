package denis.paim.easymed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class EspecialidadesActivity extends AppCompatActivity {

    Fragment1 fragment1Action;
    Fragment2 fragment2Action;
    Fragment3 fragment3Action;
    Spinner spEspecialidades;
    List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidades);


        spEspecialidades = findViewById(R.id.spEspecialidades);
        fragment1Action = new Fragment1();
        fragment2Action = new Fragment2();
        fragment3Action = new Fragment3();

        names = new ArrayList<>();
        names.add("Especialidades");
        names.add("Pediatria");
        names.add("Oftalmologia");
        names.add("Cardiologia");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(EspecialidadesActivity.this, R.layout.item, names);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEspecialidades.setAdapter(arrayAdapter);

        spEspecialidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case  1:
                        selectFragment(fragment1Action);
                        break;

                    case  2:
                        selectFragment(fragment2Action);
                        break;

                    case  3:
                        selectFragment(fragment3Action);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void selectFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

}