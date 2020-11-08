package com.udacity.sandwichclub;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RViewAdapter extends RecyclerView.Adapter <RViewAdapter.ViewHolder> {

    private final String[] listOfIngr;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredients, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RViewAdapter.ViewHolder holder, int position) {
        holder.idView.setText(listOfIngr[position]);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return listOfIngr.length;
    }

    RViewAdapter(MainActivity parent, String[] items)
    {
        listOfIngr = items;
    }

    final private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int item = (int) view.getTag();
            Context context = view.getContext();
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_POSITION,item);
            context.startActivity(intent);
        }
    };

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        final TextView idView;
        ViewHolder(View view)
        {
            super(view);
            idView = view.findViewById(R.id.ingredients_tv);
        }
    }
}
