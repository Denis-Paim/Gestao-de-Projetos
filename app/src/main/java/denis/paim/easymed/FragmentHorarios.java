package denis.paim.easymed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentHorarios extends Fragment {

    HorarioAdapter horarioAdapter;
    RecyclerView recyclerView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_horarios, container, false);

        List<Horario> horarioList = new ArrayList<>();
        horarioList.add(new Horario( "8:00"));
        horarioList.add(new Horario( "8:30"));
        horarioList.add(new Horario( "9:00"));
        horarioList.add(new Horario( "9:30"));
        horarioList.add(new Horario( "10:00"));
        horarioList.add(new Horario( "10:30"));
        horarioList.add(new Horario( "11:00"));
        horarioList.add(new Horario( "11:30"));

        iniciarRecyclerViewHorario(horarioList);

        return view;
    }

    private void iniciarRecyclerViewHorario(List<Horario> horarioList) {

        recyclerView = view.findViewById(R.id.recycler_view_horarios_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        horarioAdapter = new HorarioAdapter(getContext(), horarioList);
        recyclerView.setAdapter(horarioAdapter);

    }
}