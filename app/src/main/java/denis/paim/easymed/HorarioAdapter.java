package denis.paim.easymed;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.HorarioViewHolder> {

    Context context;
    List<Horario> horarioList;


    public HorarioAdapter(Context context, List<Horario> horarioList) {
        this.context = context;
        this.horarioList = horarioList;
    }


    @NonNull
    @Override
    public HorarioAdapter.HorarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_horarios, parent, false);

        return new HorarioAdapter.HorarioViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull HorarioAdapter.HorarioViewHolder holder, int position) {

        holder.horario.setText(horarioList.get(position).getHorario());

//        holder.horario.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//            }
//        });

    }



    @Override
    public int getItemCount() {

        return horarioList.size();

    }



    public class HorarioViewHolder extends RecyclerView.ViewHolder{

        TextView horario;

        public HorarioViewHolder(@NonNull View itemView) {
            super(itemView);

            horario = itemView.findViewById(R.id.horarios);

        }
    }
}
