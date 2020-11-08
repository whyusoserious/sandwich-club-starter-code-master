package com.udacity.sandwichclub;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.xml.validation.Validator;
import java.util.List;

public class RViewAdapter_second extends RecyclerView.Adapter <RViewAdapter_second.ViewHolder> {
    private final DetailActivity detailActivity;
    private final List<String> values;

    RViewAdapter_second(DetailActivity parent, List<String> items)
    {
        detailActivity = parent;
        values = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredients, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.idView.setText(values.get(position));
        holder.itemView.setTag(values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        final TextView idView;
        ViewHolder(View view)
        {
            super(view);
            idView = view.findViewById(R.id.ingredients_tv);
        }
    }
}
