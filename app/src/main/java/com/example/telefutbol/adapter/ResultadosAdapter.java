package com.example.telefutbol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.telefutbol.Entity.Events;
import com.example.telefutbol.R;

import java.util.List;

public class ResultadosAdapter extends RecyclerView.Adapter<ResultadosAdapter.EventsViewHolder> {
    private List<Events> listEventos;
    private Context context;

    public List<Events> getListEventos() {
        return listEventos;
    }

    public void setListEventos(List<Events> listEventos) {
        this.listEventos = listEventos;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_resultados,parent,false);
        return new EventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        Events e = listEventos.get(position);
        holder.events = e;

        TextView textViewNombre = holder.itemView.findViewById(R.id.nombreCompetencia);
        textViewNombre.setText(e.getStrLeague());

        TextView textViewRondaBusqueda = holder.itemView.findViewById(R.id.nroRonda);
        textViewRondaBusqueda.setText(e.getStrSeason());

        TextView textViewNombreEquipoLocal = holder.itemView.findViewById(R.id.nombreEquipoLocal);
        textViewNombreEquipoLocal.setText(e.getStrHomeTeam());

        TextView textViewNombreEquipoVisitante = holder.itemView.findViewById(R.id.nombreEquipoVisitante);
        textViewNombreEquipoVisitante.setText(e.getStrAwayTeam());

        TextView textViewResultado = holder.itemView.findViewById(R.id.resultado);
        textViewResultado.setText(e.getIntHomeScore()+" - "+e.getIntAwayScore());

        TextView textViewFechaEncuentro = holder.itemView.findViewById(R.id.fechaEncuentro);
        textViewFechaEncuentro.setText(e.getDateEvent());

        TextView textViewCantidadEspectadores = holder.itemView.findViewById(R.id.nroEspectadores);
        if(e.getIntSpectators() == null){
            textViewCantidadEspectadores.setText("sin-data");
        }else {
            textViewCantidadEspectadores.setText(e.getIntSpectators());
        }

        //Para poder mandar una URL a un imageView - Se uso chatGPT para encontrar esta parte del codigo
        String imageUrl = e.getStrLeagueBadge();
        ImageView imgBadge = holder.itemView.findViewById(R.id.imgBadge);
        Glide.with(context)
                .load(imageUrl)
                .into(imgBadge);

    }

    @Override
    public int getItemCount() {
        return listEventos.size();
    }

    public class EventsViewHolder extends RecyclerView.ViewHolder{

        Events events;

        public EventsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
