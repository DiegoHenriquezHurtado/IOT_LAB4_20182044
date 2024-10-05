package com.example.telefutbol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.telefutbol.Entity.Ligas;
import com.example.telefutbol.R;

import java.util.List;

public class LigaAdapter extends RecyclerView.Adapter<LigaAdapter.LigasViewHolder> {

    private List<Ligas> listaLigas;
    private Context context;

    public List<Ligas> getListaLigas() {
        return listaLigas;
    }

    public void setListaLigas(List<Ligas> listaLigas) {
        this.listaLigas = listaLigas;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public LigasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_ligas,parent,false);
        return new LigasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LigasViewHolder holder, int position) {
        Ligas l = listaLigas.get(position);
        holder.ligas = l;

        TextView textViewId = holder.itemView.findViewById(R.id.idLeague);
        textViewId.setText(l.getIdLeague());

        TextView textViewStrLeague = holder.itemView.findViewById(R.id.strLeague);
        textViewStrLeague.setText(l.getStrLeague());

        TextView textStrSports = holder.itemView.findViewById(R.id.strSports);
        textStrSports.setText(l.getStrSport());

        TextView textStrAlternate = holder.itemView.findViewById(R.id.strLeagueAlternate);
        textStrAlternate.setText(l.getStrLeagueAlternate());

    }

    @Override
    public int getItemCount() {
        return listaLigas.size();
    }

    public class LigasViewHolder extends RecyclerView.ViewHolder{
        Ligas ligas;
        public LigasViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
