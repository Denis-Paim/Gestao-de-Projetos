package denis.paim.easymed;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MedicosAdapter extends RecyclerView.Adapter<MedicosAdapter.MedicosViewHolder> {

    Context context;
    List<Medico> medicoList;


    public MedicosAdapter(Context context, List<Medico> medicoList) {
        this.context = context;
        this.medicoList = medicoList;
    }


    @NonNull
    @Override
    public MedicosAdapter.MedicosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_layout, parent, false);

        return new MedicosViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MedicosAdapter.MedicosViewHolder holder, int position) {

        holder.nome.setText(medicoList.get(position).getNome());
        holder.especialidade.setText(medicoList.get(position).getEspecialidade());
        holder.sala.setText(medicoList.get(position).getSala());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, HorariosActivity.class);
                intent.putExtra("nomeMedico", medicoList.get(holder.getAdapterPosition()).getNome());
                intent.putExtra("especialidadeMedico", medicoList.get(holder.getAdapterPosition()).getEspecialidade());
                intent.putExtra("salaConsulta", medicoList.get(holder.getAdapterPosition()).getSala());

                context.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return medicoList.size();
    }


    public class MedicosViewHolder extends RecyclerView.ViewHolder{

        TextView nome;
        TextView especialidade;
        TextView sala;
        CardView cardView;

        public MedicosViewHolder(@NonNull View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.txtNomeMedico);
            especialidade = itemView.findViewById(R.id.txtEspecialidadeMedico);
            sala = itemView.findViewById(R.id.txtSala);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
