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


public class Fragment1 extends Fragment {

    RecyclerView recyclerView;
    MedicosAdapter medicosAdapter;

    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);
        List<Medico> medicoList = new ArrayList<>();
        medicoList.add(new Medico( "Dra. Carmem Michalski", "Pediatria", "Consultar no local"));
        medicoList.add(new Medico( "Dr. Pedro Leonardo Narchi", "Pediatria", "Consultar no local"));
        medicoList.add(new Medico( "Dra. Fernanda Barbosa", "Pediatria", "Consultar no local"));
        medicoList.add(new Medico( "Dr. Roger Zorzi", "Pediatria", "Consultar no local"));

        iniciarRecyclerView(medicoList);

        return view;
    }

    private void iniciarRecyclerView(List<Medico> medicoList) {

        recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        medicosAdapter = new MedicosAdapter(getContext(), medicoList);
        recyclerView.setAdapter(medicosAdapter);

    }
}