package com.example.telefutbol.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.telefutbol.Entity.Table;
import com.example.telefutbol.R;

import java.util.List;

public class PosicionesAdapter extends RecyclerView.Adapter<PosicionesAdapter.TableViewHolder>{
    private List<Table> listaPosiciones;
    private Context context;

    public List<Table> getListaPosiciones() {
        return listaPosiciones;
    }

    public void setListaPosiciones(List<Table> listaPosiciones) {
        this.listaPosiciones = listaPosiciones;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv_posiciones,parent,false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder holder, int position) {
        Table t = listaPosiciones.get(position);
        holder.table= t;

        TextView textViewNombre = holder.itemView.findViewById(R.id.nombreLiga);
        textViewNombre.setText(t.getStrTeam());

        TextView textViewRanking = holder.itemView.findViewById(R.id.nroRanking);
        textViewRanking.setText(t.getIntRank());

        TextView textViewVictoriaEmpateDerrota = holder.itemView.findViewById(R.id.nroVictDerroEmpate);
        textViewVictoriaEmpateDerrota.setText(t.getIntWin()+"/"+t.getIntDraw()+"/"+t.getIntLoss());

        TextView textViewAnotadosConcedidosDiferencia = holder.itemView.findViewById(R.id.nroAnotadosConcedidosDiferencia);
        textViewAnotadosConcedidosDiferencia.setText(t.getIntGoalsFor()+"/"+t.getIntGoalsAgainst()+"/"+t.getIntGoalDifference());

        //Para poder mandar una URL a un imageView - Se uso chatGPT para encontrar esta parte del codigo
        String imageUrl = t.getStrBadge();
        ImageView imgBadge = holder.itemView.findViewById(R.id.imgBadge);
        Glide.with(context)
                .load(imageUrl)
                .into(imgBadge);

    }

    @Override
    public int getItemCount() {
        return listaPosiciones.size();
    }

    public class TableViewHolder extends RecyclerView.ViewHolder{
        Table table;
        public TableViewHolder (@NonNull View itemView){
            super(itemView);
        }
    }
}
