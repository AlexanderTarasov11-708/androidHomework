package com.itis.hw;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Film> films;

    DataAdapter(Context context, List<Film> films) {
        this.films = films;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.bind(films.get(position).title, films.get(position).year, films.get(position).description, films.get(position).id);
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView posterView;
        final TextView titleView, yearView;

        public String name;
        public String description;
        public int id;

        ViewHolder(View view){
            super(view);
            posterView = (ImageView)view.findViewById(R.id.i_poster);
            titleView = (TextView) view.findViewById(R.id.i_title);
            yearView = (TextView) view.findViewById(R.id.i_year);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, FilmActivity.class);
                    intent.putExtra("name", titleView.getText());
                    intent.putExtra("year", yearView.getText());
                    intent.putExtra("description",description);
                    intent.putExtra("id", id);
                    context.startActivity(intent);
                }
            });
        }

        public void bind(String name, String year, String description, int id) {
            this.name = name;
            this.description = description;
            this.id = id;
            String uri = "android.resource://com.itis.hw/drawable/film" + id;
            posterView.setImageURI(Uri.parse(uri));
            titleView.setText(name);
            yearView.setText(year);
        }
    }
}
